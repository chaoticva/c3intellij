package org.c3lang.intellij

import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import org.c3lang.intellij.psi.C3MacroFuncBody

class C3FoldingBuilder : FoldingBuilderEx(), DumbAware
{
    override fun buildFoldRegions(root: PsiElement, document: Document, quick: Boolean): Array<FoldingDescriptor>
    {
        val descriptors = mutableListOf<FoldingDescriptor>()

        PsiTreeUtil.processElements(root) { element ->
            if (element is C3MacroFuncBody)
            {
                descriptors.add(FoldingDescriptor(element.node, element.textRange))
            }
            true
        }

        return descriptors.toTypedArray()
    }

    override fun getPlaceholderText(node: ASTNode): String?
    {
        return when (node.psi)
        {
            is C3MacroFuncBody -> "{...}"
            else               -> null
        }
    }

    override fun isCollapsedByDefault(node: ASTNode) = false
}