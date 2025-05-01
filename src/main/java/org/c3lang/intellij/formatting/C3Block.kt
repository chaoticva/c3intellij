package org.c3lang.intellij.formatting

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
import org.c3lang.intellij.psi.C3Types

class C3Block(
        node: ASTNode,
        wrap: Wrap?,
        alignment: Alignment?,
        private val spacingBuilder: SpacingBuilder,
        private val indent: Indent?,
        private val codeStyleSettings: CodeStyleSettings
) : AbstractBlock(node, wrap, alignment)
{

    override fun buildChildren(): MutableList<Block>
    {
        val blocks = arrayListOf<Block>()
        var child = myNode.firstChildNode

        while (child != null)
        {
            if (child.elementType != TokenType.WHITE_SPACE)
            {
                val childIndent = if (isStatement(child))
                {
                    Indent.getNormalIndent()
                } else
                {
                    Indent.getNoneIndent()
                }
                val childWrap = if (child.elementType == C3Types.LB)
                {
                    Wrap.createWrap(WrapType.ALWAYS, true)
                } else
                {
                    Wrap.createWrap(WrapType.NONE, false)
                }

                val childAlignment = Alignment.createAlignment()
                val block = C3Block(
                    child,
                    childWrap,
                    childAlignment,
                    spacingBuilder,
                    childIndent,
                    codeStyleSettings
                )
                blocks.add(block)
            }
            child = child.treeNext
        }

        return blocks
    }

    private fun isStatement(node: ASTNode): Boolean
    {
        return node.elementType in listOf(
            C3Types.CONST_IDENT,
            C3Types.STRUCT_MEMBER_DECLARATION,
            C3Types.STATEMENT
        ) && node.firstChildNode?.elementType != C3Types.COMPOUND_STATEMENT
    }

    override fun getIndent(): Indent?
    {
        return indent
    }

    override fun getSpacing(p0: Block?, p1: Block) = spacingBuilder.getSpacing(this, p0, p1)

    override fun isLeaf() = myNode.firstChildNode == null
}