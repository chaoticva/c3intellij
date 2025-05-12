package org.c3lang.intellij.rewrite.formatting

import com.intellij.formatting.Alignment
import com.intellij.formatting.Block
import com.intellij.formatting.Indent
import com.intellij.formatting.SpacingBuilder
import com.intellij.formatting.Wrap
import com.intellij.formatting.WrapType
import com.intellij.lang.ASTNode
import com.intellij.psi.TokenType
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.formatter.common.AbstractBlock
import org.c3lang.intellij.rewrite.psi.C3Parameter
import org.c3lang.intellij.rewrite.psi.C3StructBody
import org.c3lang.intellij.rewrite.psi.C3Types

class C3Block(
        node: ASTNode,
        wrap: Wrap?,
        alignment: Alignment?,
        private val spacingBuilder: SpacingBuilder,
        private val indent: Indent?,
        private val codeStyleSettings: CodeStyleSettings
) : AbstractBlock(node, wrap, alignment)
{
    override fun getSpacing(p0: Block?, p1: Block) = spacingBuilder.getSpacing(this, p0, p1)

    override fun getIndent() = indent

    override fun isLeaf() = myNode.firstChildNode == null

    override fun buildChildren(): MutableList<Block>
    {
        val blocks = arrayListOf<Block>()
        var child = myNode.firstChildNode

        while (child != null)
        {
            if (child.elementType == TokenType.WHITE_SPACE)
            {
                child = child.treeNext
                continue
            }

            val block = C3Block(
                child,
                getChildWrap(child),
                Alignment.createAlignment(),
                spacingBuilder,
                getIndentForChild(child),
                codeStyleSettings
            )
            blocks.add(block)

            child = child.treeNext
        }

        return blocks
    }

    private fun getChildWrap(child: ASTNode): Wrap
    {
        val element = child.elementType
        val parentElement = child.treeParent.elementType

        // case struct field
        if (element == C3Types.PARAMETER && parentElement == C3Types.STRUCT_BODY)
            return Wrap.createWrap(WrapType.NONE, false)
        // case enum value
        if (element == C3Types.ENUM_VALUE)
            return Wrap.createWrap(WrapType.NONE, false)
        // case fn statement
        if (element == C3Types.FN_STATEMENT)
            return Wrap.createWrap(WrapType.NONE, false)
        // case statement
        if (element == C3Types.STATEMENT)
            return Wrap.createWrap(WrapType.NONE, false)

        return Wrap.createWrap(WrapType.NONE, false)
    }

    private fun getIndentForChild(child: ASTNode): Indent
    {
        val element = child.elementType
        val parentElement = child.treeParent.elementType

        // case struct field
        if (element == C3Types.PARAMETER && parentElement == C3Types.STRUCT_BODY)
            return Indent.getNormalIndent()
        // case enum value
        if (element == C3Types.ENUM_VALUE)
            return Indent.getNormalIndent()
        // case fn statement
        if (element == C3Types.FN_STATEMENT)
            return Indent.getNormalIndent()
        // case statement
        if (element == C3Types.STATEMENT)
            return Indent.getNoneIndent()

        return Indent.getNoneIndent()
    }

    private fun handleStructMember(child: ASTNode, blocks: ArrayList<Block>)
    {
        if (child.psi !is C3Parameter) return
        if (child.psi.parent !is C3StructBody) return

        blocks.add(
            C3Block(
                child,
                Wrap.createWrap(WrapType.NONE, false),
                Alignment.createAlignment(),
                spacingBuilder,
                Indent.getNormalIndent(),
                codeStyleSettings
            )
        )
    }
}