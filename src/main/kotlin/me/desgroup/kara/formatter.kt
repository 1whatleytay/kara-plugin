package me.desgroup.kara

import com.intellij.formatting.*
import com.intellij.lang.*
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import com.intellij.psi.formatter.common.*
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.formatter.FormatterUtil

import me.desgroup.kara.psi.KaraTypes

// useless, copied from rust but I'm leaving it here for now until I get everything right...
data class KaraFormatContext(private val alignment: Alignment?)

class KaraBlock(private val astNode: ASTNode,
                private val myWrap: Wrap?,
                private val myAlignment: Alignment?,
                private val myIndent: Indent?,
                private val spacingBuilder: SpacingBuilder,
                private val context: KaraFormatContext) : ASTBlock {
    private val children = buildChildren()

    override fun getTextRange(): TextRange = astNode.textRange

    override fun getSubBlocks(): MutableList<Block> = children

    override fun getWrap(): Wrap? = myWrap
    override fun getIndent(): Indent? = myIndent
    override fun getAlignment(): Alignment? = myAlignment
    override fun getSpacing(child1: Block?, child2: Block): Spacing? = null

//    private val isIncompleteLazy : Boolean by lazy { FormatterUtil.isIncomplete(node) }

    override fun getChildAttributes(newChildIndex: Int): ChildAttributes
        = ChildAttributes(
        if (setOf(KaraTypes.CODE, KaraTypes.BODY).contains(astNode.elementType))
            Indent.getNormalIndent()
        else
            Indent.getNoneIndent(),
        null)

    override fun isIncomplete(): Boolean = false

    override fun isLeaf(): Boolean = true
    override fun getNode(): ASTNode = astNode

    private fun buildChildren(): MutableList<Block> {
        val blocks = mutableListOf<Block>()
        var child = astNode.firstChildNode

        val alignsChildren = setOf(
            KaraTypes.BODY,
            KaraTypes.TYPE_ELEMENTS,
        )

        val indent =
            if (alignsChildren.contains(astNode.elementType))
                Indent.getNormalIndent()
            else
                Indent.getNoneIndent()
//        val alignment =
//            if (alignsChildren.contains(astNode.elementType))
//                Alignment.createAlignment()
//            else
//                null

        // Don't know how to map this...
        while (child != null) {
            if (child.elementType != TokenType.WHITE_SPACE) {
                val block = KaraBlock(
                    child, null, myAlignment, indent, spacingBuilder, context
                )

                blocks.add(block)
            }

            child = child.treeNext
        }

        return blocks
    }
}

fun createSpaceBuilder(settings: CodeStyleSettings) : SpacingBuilder {
    return SpacingBuilder(settings, KaraLanguage)
//        .around(KaraTypes.BODY_ASSIGN_OP)
//        .spaceIf(settings.getCommonSettings(KaraLanguage.id).SPACE_AROUND_ASSIGNMENT_OPERATORS)
//        .before(KaraTypes.EXPRESSION)
//        .none()
}

class KaraFormattingModelBuilder : FormattingModelBuilder {
    override fun createModel(formattingContext: FormattingContext): FormattingModel {
        val style = formattingContext.codeStyleSettings

        val context = KaraFormatContext(Alignment.createAlignment())

        return FormattingModelProvider
            .createFormattingModelForPsiFile(
                formattingContext.containingFile,
                KaraBlock(
                    formattingContext.node,
                    null,
//                    null,
//                    Wrap.createWrap(WrapType.NONE, false),
                    null,
                    Indent.getNoneIndent(),
                    createSpaceBuilder(style),
                    context
                ),
                style
            )
    }
}
