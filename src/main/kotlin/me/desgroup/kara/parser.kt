package me.desgroup.kara

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.ParserDefinition.SpaceRequirements
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import me.desgroup.kara.psi.KaraTypes

val comments = TokenSet.create(KaraTypes.COMMENT)
val whiteSpaces = TokenSet.create(TokenType.WHITE_SPACE)

val fileType = IFileElementType(KaraLanguage)

class KaraParserDefinition : ParserDefinition {
    override fun createLexer(project: Project?) = KaraLexerAdapter()
    override fun createParser(project: Project?) = KaraParser()

    override fun getFileNodeType() = fileType

    override fun getCommentTokens() = comments
    override fun getWhitespaceTokens() = whiteSpaces

    override fun getStringLiteralElements() : TokenSet = TokenSet.EMPTY

    override fun spaceExistenceTypeBetweenTokens(left: ASTNode?, right: ASTNode?) = SpaceRequirements.MAY

    override fun createElement(node: ASTNode?): PsiElement = KaraTypes.Factory.createElement(node)
    override fun createFile(viewProvider: FileViewProvider) = KaraFile(viewProvider)
}