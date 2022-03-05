import com.intellij.openapi.project.Project

import java.nio.file.Paths

import org.snakeyaml.engine.v2.api.Load
import org.snakeyaml.engine.v2.api.LoadSettings

import java.io.File

import com.intellij.execution.configurations.GeneralCommandLine

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

import kotlin.concurrent.thread

class KaraHeaderFunctionParameter(
    val name: String,
    val type: String)

class KaraHeaderFunction(
    val name: String,
    val parameters: Iterable<KaraHeaderFunctionParameter>,
    val returnType: String)

class KaraHeaderVariable(
    val name: String,
    val type: String,
    val isMutable: Boolean)

class KaraHeaderType(
    val name: String,
    val isAlias: Boolean)

class KaraHeaderData(
    val functions: Iterable<KaraHeaderFunction>,
    val variables: Iterable<KaraHeaderVariable>,
    val types: Iterable<KaraHeaderType>)

fun getKaraExecutable(): String? {
    val elements = System.getenv("PATH").split(File.pathSeparator)

    val x = mutableListOf<String>()

    for (dirname in elements) {
        val file = File(dirname, "kara")

        x.add("Tried ${file.absolutePath}")

        if (file.isFile && file.canExecute()) {
            return file.absolutePath
        }
    }

    throw Exception("Error: tried a bunch of paths: [${x.joinToString(", ")}]")
}

class KaraHeaderSource {
    private val mutex = Mutex()
    private val cache = hashMapOf<String, KaraHeaderData?>()

    private suspend fun loadCache(name: String, project: Project) = coroutineScope {
        try {
            val basePath = project.basePath ?: return@coroutineScope
            val projectPath = Paths.get(basePath, "project.yaml")

            if (!projectPath.toFile().exists()) {
                return@coroutineScope
            }

            val process = GeneralCommandLine("kara", "expose", name, "--type", "c")
                .withWorkDirectory(basePath)
                .createProcess()

            val loader = Load(LoadSettings.builder().build())
            val result = loader
                .loadAllFromInputStream(process.inputStream)
                .toList().firstOrNull() as? Map<*, *>
            result ?: throw Exception()

            if (result.containsKey("error")) {
                throw Exception()
            }

            val root = result["root"] as List<*>

            val functions = mutableListOf<KaraHeaderFunction>()
            val variables = mutableListOf<KaraHeaderVariable>()
            val types = mutableListOf<KaraHeaderType>()

            for (element in root) {
                val map = element as? Map<*, *> ?: continue

                when (map["kind"]) {
                    "function" -> {
                        val functionName = map["name"] as String
                        val returnType = map["return-type"] as String

                        val parameters = mutableListOf<KaraHeaderFunctionParameter>()

                        val listParameters = map["parameters"] as List<*>

                        for (parameter in listParameters) {
                            val parameterMap = parameter as? Map<*, *> ?: continue

                            val parameterName = parameterMap["name"] as String
                            val parameterType = parameterMap["type"] as String

                            parameters.add(
                                KaraHeaderFunctionParameter(
                                    name = parameterName,
                                    type = parameterType
                                )
                            )
                        }

                        functions.add(
                            KaraHeaderFunction(
                                name = functionName,
                                parameters = parameters,
                                returnType = returnType
                            )
                        )
                    }

                    "variable" -> {
                        val variableName = map["name"] as String
                        val variableType = map["type"] as String
                        val mutable = map["mutable"] as Boolean

                        variables.add(
                            KaraHeaderVariable(
                                name = variableName,
                                type = variableType,
                                isMutable = mutable
                            )
                        )
                    }

                    "type" -> {
                        val typeName = map["name"] as String

                        types.add(
                            KaraHeaderType(
                                name = typeName,
                                isAlias = false,
                            )
                        )
                    }

                    "type-alias" -> {
                        val typeName = map["name"] as String

                        types.add(
                            KaraHeaderType(
                                name = typeName,
                                isAlias = true,
                            )
                        )
                    }
                }
            }

            val data = KaraHeaderData(
                functions = functions,
                variables = variables,
                types = types
            )

            runBlocking {
                mutex.withLock {
                    cache[name] = data
                }
            }
        } catch (e: Exception) {
            runBlocking {
                mutex.withLock {
                    cache[name] = null
                }
            }
        }
    }

    fun getHeader(name: String, project: Project): KaraHeaderData? {
        if (cache.containsKey(name)) { // inefficient
            return cache[name]
        }

        thread {
            runBlocking {
                loadCache(name, project)
            }
        }

        return null
    }
}
