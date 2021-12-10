package me.desgroup.kara

import KaraHeaderSource
import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.openapi.project.Project
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.tree.IElementType
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType
import com.intellij.util.PlatformIcons
import com.intellij.util.ProcessingContext
import com.intellij.util.containers.concat

//import org.snakeyaml.engine.v2

import me.desgroup.kara.psi.*

import javax.swing.Icon

data class Suggestion(
    val name: String,
    val type: String?,
    val icon: Icon?,
) {
    fun toElement() = LookupElementBuilder
        .create(name)
        .withTypeText(type)
        .withIcon(icon)
}

fun KaraTypename.clean() = text.replace(Regex("\\s+"), " ")

fun getGlobals(element: PsiElement): Iterable<Suggestion> {
    val list = mutableListOf<Suggestion>()

    val functions = PsiTreeUtil.getChildrenOfType(element, KaraFunctionLoose::class.java)
    functions ?: return emptyList()

    for (function in functions) {
        val paramList = mutableListOf<String>()
        var returnTypeText = "nothing"

        val parameters = function.function.functionParameters
        if (parameters != null) {
            for (parameter in parameters.children) {
                val ignore = setOf<IElementType>(
                    KaraTypes.OPEN_BRACE,
                    KaraTypes.CLOSE_BRACE,
                    KaraTypes.COMMA,
                )

                if (ignore.contains(parameter.elementType)) {
                    continue
                }

                assert(parameter.elementType == KaraTypes.VARIABLE_LOOSE)

                val variableLoose = parameter as KaraVariableLoose
                val typename = variableLoose.variable.typename

                val name = variableLoose.variable.firstChild.text

                if (typename == null) {
                    paramList.add("$name unknown")
                } else {
                    paramList.add("$name ${typename.clean()}")
                }
            }
        }

        val returnType = function.function.typename

        if (returnType != null) {
            returnTypeText = returnType.clean()
        }

        val paramListText = paramList.joinToString(", ")

        val type = "func ($paramListText) $returnTypeText"

        val suggestion = Suggestion(
            function.function.firstChild.text,
            type,
            PlatformIcons.FUNCTION_ICON,
        )

        list.add(suggestion)
    }

    return list
}

fun rootElement(position: PsiElement): PsiElement {
    var p = position

    while (p.parent != null) {
        p = p.parent
    }

    return p
}

fun KaraVariable.toSuggestion() = Suggestion(
    firstChild.text,
    typename?.clean() ?: "unknown",
    PlatformIcons.VARIABLE_ICON,
)

fun getScopeVariables(position: PsiElement): Iterable<Suggestion> {
    val list = mutableListOf<Suggestion>()

    var origin = position

    while (origin.parent != null) {
        val variables = PsiTreeUtil.findChildrenOfType(origin, KaraVariableStrict::class.java)

        for (strict in variables) {
            val variable = strict.variable ?: continue

            list.add(variable.toSuggestion())
        }

        if (origin.elementType == KaraTypes.FUNCTION) {
            val function = origin as? KaraFunction

            if (function != null) {
                val parameters = function.functionParameters

                if (parameters != null) {
                    for (parameter in parameters.children) {
                        val ignore = setOf<IElementType>(
                            KaraTypes.OPEN_BRACE,
                            KaraTypes.CLOSE_BRACE,
                            KaraTypes.COMMA,
                        )

                        if (ignore.contains(parameter.elementType)) {
                            continue
                        }

                        assert(parameter.elementType == KaraTypes.VARIABLE_LOOSE)

                        val variableLoose = parameter as KaraVariableLoose
                        list.add(variableLoose.variable.toSuggestion())
                    }
                }
            }
        }

        origin = origin.parent
    }

    return list
}

fun searchGlobals(position: PsiElement): Iterable<Suggestion> {
    val project = position.project
    val root = rootElement(position)

    val list = mutableListOf<Suggestion>()

    val scope = GlobalSearchScope.allScope(project)
    val files = FileTypeIndex.getFiles(KaraFileType, scope)

    for (virtualFile in files) {
        val file = PsiManager.getInstance(project).findFile(virtualFile)
        file ?: continue

        if (file == root || PsiTreeUtil.findCommonParent(position, file) != null) {
            continue
        }

        list.addAll(getGlobals(file))
    }

    list.addAll(getGlobals(root))

    return list
}

fun searchHeaders(position: PsiElement, headerSource: KaraHeaderSource): Iterable<Suggestion> {
    val list = mutableListOf<Suggestion>()

    val root = rootElement(position)

    list.add(Suggestion("noHeader", null, null))

    for (element in root.children) {
        if (element.elementType == KaraTypes.IMPORT) {
            val node = element as? KaraImport ?: continue

            var child = node.firstChild

            while (child != null && child.elementType != KaraTypes.NAME) {
                child = child.nextSibling
            }

            if (child != null && child.text == "c") {
                val literal = node.literalString ?: continue

                val text = literal.text
                val headerPath = text.substring(1, text.length - 1)

                val clean = { v: String -> v.replace(Regex("\\s+"), " ") }

                list.add(Suggestion("literal-has", null, null))

                val data = headerSource.getHeader(headerPath, position.project)
                if (data == null) {
                    list.add(Suggestion("error-man", null, null))
                    continue
                }
                list.add(Suggestion("got-header ${headerPath}", null, null))

                val functionSuggestions = data.functions.map {
                    val paramListText = it.parameters.map { param ->
                        "${param.name} ${clean(param.type)}"
                    }.joinToString(", ")

                    val type = "func ($paramListText) ${clean(it.returnType)}"

                    Suggestion(it.name, type, PlatformIcons.FUNCTION_ICON)
                }

                list.addAll(functionSuggestions)
                list.addAll(data.variables.map {
                    Suggestion(it.name, clean(it.type), PlatformIcons.VARIABLE_ICON)
                })
                list.addAll(data.types.map {
                    Suggestion(it.name, null, PlatformIcons.CLASS_ICON)
                })
            }
        }
    }

    return list
}

class KaraCompletionProvider(
    private val headerSource: KaraHeaderSource) : CompletionProvider<CompletionParameters>() {
    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        result: CompletionResultSet
    ) {
        result.addAllElements(searchGlobals(parameters.position).map { it.toElement() })
        result.addAllElements(getScopeVariables(parameters.position).map { it.toElement() })
        result.addAllElements(searchHeaders(parameters.position, headerSource).map { it.toElement() })
    }
}

class KaraCompletion : CompletionContributor() {
    private val headerSource = KaraHeaderSource()
    private val provider = KaraCompletionProvider(headerSource)

    init {
        val namePattern = PlatformPatterns.psiElement(KaraTypes.NAME)
            .withParent(PlatformPatterns.psiElement(KaraTypes.LITERAL_REFERENCE))

        val dotPattern = PlatformPatterns.psiElement(KaraTypes.NAME)
            .withParent(PlatformPatterns.psiElement(KaraTypes.MODIFIER_DOT))

        val pattern = PlatformPatterns.or(namePattern, dotPattern)

        extend(CompletionType.BASIC, pattern, provider)
    }
}