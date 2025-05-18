package org.c3lang.intellij.rewrite.annotation

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.tree.TokenSet
import org.c3lang.intellij.rewrite.psi.C3Contract
import org.c3lang.intellij.rewrite.psi.C3DocComment
import org.c3lang.intellij.rewrite.psi.C3Types

object DocCommentAnnotator
{
    fun annotateC3DocComment(docComment: C3DocComment, holder: AnnotationHolder)
    {

        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
            .range(docComment.firstChild)
            .textAttributes(DefaultLanguageHighlighterColors.DOC_COMMENT)
            .create()

        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
            .range(docComment.lastChild)
            .textAttributes(DefaultLanguageHighlighterColors.DOC_COMMENT)
            .create()

        docComment.node.getChildren(TokenSet.create(C3Types.IDENTIFIER)).forEach {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                .range(it)
                .textAttributes(DefaultLanguageHighlighterColors.DOC_COMMENT)
                .create()
        }

        docComment.contractList.forEach { annotateC3Contract(it, holder) }
    }

    private fun annotateC3Contract(contract: C3Contract, holder: AnnotationHolder)
    {
        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
            .range(contract.firstChild.firstChild)
            .textAttributes(DefaultLanguageHighlighterColors.DOC_COMMENT_TAG)
            .create()

        contract.ensureContract?.let {
            it.description?.let { desc ->
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(desc)
                    .textAttributes(DefaultLanguageHighlighterColors.FUNCTION_DECLARATION)
                    .create()
            }
        }
        contract.paramContract?.let {
            it.description?.let { desc ->
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(desc)
                    .textAttributes(DefaultLanguageHighlighterColors.FUNCTION_DECLARATION)
                    .create()
            }
        }
        contract.requireContract?.let {
            it.description?.let { desc ->
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(desc)
                    .textAttributes(DefaultLanguageHighlighterColors.FUNCTION_DECLARATION)
                    .create()
            }
        }
    }
}