package me.desgroup.kara

import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

import me.desgroup.kara.psi.KaraTypes

object KaraHighlighterKeys {
    val keyword =
        createTextAttributesKey("KARA_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
    val operator =
        createTextAttributesKey("KARA_OPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN)

    val parens =
        createTextAttributesKey("KARA_PARENS", DefaultLanguageHighlighterColors.PARENTHESES)
    val brackets =
        createTextAttributesKey("KARA_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS)
    val braces =
        createTextAttributesKey("KARA_BRACES", DefaultLanguageHighlighterColors.BRACES)

    val predef =
        createTextAttributesKey("KARA_PRE_DEF", DefaultLanguageHighlighterColors.PREDEFINED_SYMBOL)

    val dot =
        createTextAttributesKey("KARA_DOT", DefaultLanguageHighlighterColors.DOT)
    val comma =
        createTextAttributesKey("KARA_COMMA", DefaultLanguageHighlighterColors.COMMA)

    val comment =
        createTextAttributesKey("KARA_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)

    val string =
        createTextAttributesKey("KARA_STRING", DefaultLanguageHighlighterColors.STRING)
    val stringEscape =
        createTextAttributesKey("KARA_ESCAPE", DefaultLanguageHighlighterColors.VALID_STRING_ESCAPE)

    val number =
        createTextAttributesKey("KARA_NUMBER", DefaultLanguageHighlighterColors.NUMBER)

    val name =
        createTextAttributesKey("KARA_NAME", DefaultLanguageHighlighterColors.LOCAL_VARIABLE)
    val badCharacter =
        createTextAttributesKey("KARA_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)
}

class KaraSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer() = KaraLexerAdapter()

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
        return when (tokenType) {
            KaraTypes.FUNC_DECL,
            KaraTypes.TYPE_DECL,
            KaraTypes.LET_DECL,
            KaraTypes.VAR_DECL,
            KaraTypes.BLOCK_DECL,
            KaraTypes.EXIT_DECL,
            KaraTypes.BREAK_DECL,
            KaraTypes.RETURN_DECL,
            KaraTypes.CONTINUE_DECL,
            KaraTypes.IMPORT_DECL,
            KaraTypes.AS_DECL,
            KaraTypes.IF_DECL,
            KaraTypes.FOR_DECL ->
                arrayOf(KaraHighlighterKeys.keyword)

            KaraTypes.COMMENT -> arrayOf(KaraHighlighterKeys.comment)

            KaraTypes.OPEN_BODY,
            KaraTypes.CLOSE_BODY ->
                arrayOf(KaraHighlighterKeys.braces)

            KaraTypes.CLOSE_BRACE,
            KaraTypes.OPEN_BRACE ->
                arrayOf(KaraHighlighterKeys.parens)

            KaraTypes.OPEN_SQUARE,
            KaraTypes.CLOSE_SQUARE ->
                arrayOf(KaraHighlighterKeys.brackets)

            KaraTypes.DOT -> arrayOf(KaraHighlighterKeys.dot)
            KaraTypes.NAME -> arrayOf(KaraHighlighterKeys.name)
            KaraTypes.COMMA -> arrayOf(KaraHighlighterKeys.comma)

            KaraTypes.COLON,
            KaraTypes.FUNC_DASH,
            KaraTypes.OP_ADD,
            KaraTypes.OP_ADD_EQUALS,
            KaraTypes.OP_AND,
            KaraTypes.OP_ANDAND,
            KaraTypes.OP_AT,
            KaraTypes.OP_COMPARE,
            KaraTypes.OP_DIV,
            KaraTypes.OP_DIV_EQUALS,
            KaraTypes.OP_EQUALS,
            KaraTypes.OP_EXCLAM,
            KaraTypes.OP_GE,
            KaraTypes.OP_GREATER,
            KaraTypes.OP_LE,
            KaraTypes.OP_LESSER,
            KaraTypes.OP_MOD,
            KaraTypes.OP_MOD_EQUALS,
            KaraTypes.OP_MUL,
            KaraTypes.OP_MUL_EQUALS,
            KaraTypes.OP_NCOMPARE,
            KaraTypes.OP_OROR,
            KaraTypes.OP_QUESTION,
            KaraTypes.OP_SUB,
            KaraTypes.OP_SUB_EQUALS ->
                arrayOf(KaraHighlighterKeys.operator)

            KaraTypes.HINT_SHARED -> arrayOf(KaraHighlighterKeys.keyword)

            KaraTypes.QUOTE -> arrayOf(KaraHighlighterKeys.string)
            KaraTypes.STRING_PART -> arrayOf(KaraHighlighterKeys.string)
            KaraTypes.STRING_ESCAPE -> arrayOf(KaraHighlighterKeys.stringEscape)
            KaraTypes.STRING_INSERT -> arrayOf(KaraHighlighterKeys.badCharacter)

            KaraTypes.NUMBER -> arrayOf(KaraHighlighterKeys.number)

            KaraTypes.FALSE,
            KaraTypes.TRUE,
            KaraTypes.ANY,
            KaraTypes.NOTHING,
            KaraTypes.NULL,
            KaraTypes.PRIMITIVE ->
                arrayOf(KaraHighlighterKeys.keyword)

            TokenType.BAD_CHARACTER -> arrayOf(KaraHighlighterKeys.badCharacter)
            else -> arrayOf()
        }
    }
}

class KaraSyntaxHighlighterFactory : SyntaxHighlighterFactory() {
    override fun getSyntaxHighlighter(project: Project?, virtualFile: VirtualFile?) = KaraSyntaxHighlighter()
}