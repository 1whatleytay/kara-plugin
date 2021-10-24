package me.desgroup.kara

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

class KaraCompletionProvider : CompletionProvider<CompletionParameters>() {
    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        result: CompletionResultSet
    ) {
        result.addAllElements(searchGlobals(parameters.position).map { it.toElement() })
        result.addAllElements(getScopeVariables(parameters.position).map { it.toElement() })
    }
}

class KaraCompletion : CompletionContributor() {
    private val provider = KaraCompletionProvider()

    init {
        val namePattern = PlatformPatterns.psiElement(KaraTypes.NAME)
            .withParent(PlatformPatterns.psiElement(KaraTypes.LITERAL_REFERENCE))

        val dotPattern = PlatformPatterns.psiElement(KaraTypes.NAME)
            .withParent(PlatformPatterns.psiElement(KaraTypes.MODIFIER_DOT))

        val pattern = PlatformPatterns.or(namePattern, dotPattern)

        extend(CompletionType.BASIC, pattern, provider)
    }
}