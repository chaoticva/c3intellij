package org.c3lang.intellij.rewrite.annotation

import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import org.c3lang.intellij.rewrite.fix.RemoveUnusedParameterFix
import org.c3lang.intellij.rewrite.psi.C3Parameter
import org.c3lang.intellij.rewrite.psi.C3Types
import org.c3lang.intellij.rewrite.util.C3ErrorMessages

object ParameterAnnotator
{
    fun annotateC3Parameter(parameter: C3Parameter, holder: AnnotationHolder)
    {
        annotateMissingTypeInFn(parameter, holder)
        highlightType(parameter, holder)
        highlightName(parameter, holder)
    }

    private fun highlightName(parameter: C3Parameter, holder: AnnotationHolder)
    {
        val nameEl = parameter.node.findChildByType(C3Types.IDENTIFIER)!!

        if (parameter.isUsed)
        {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                .range(nameEl)
                .textAttributes(DefaultLanguageHighlighterColors.FUNCTION_DECLARATION)
                .create()
        } else
        {
            if (parameter.name == "unused") return

            holder.newAnnotation(HighlightSeverity.WEAK_WARNING, C3ErrorMessages.UNUSED_1.format(parameter.name))
                .range(nameEl)
                .highlightType(ProblemHighlightType.LIKE_UNUSED_SYMBOL)
                .withFix(RemoveUnusedParameterFix(parameter))
                .create()
        }
    }

    private fun highlightType(parameter: C3Parameter, holder: AnnotationHolder)
    {
        if (parameter.type == null) return

        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
            .range(parameter.type!!)
            .textAttributes(DefaultLanguageHighlighterColors.CONSTANT)
            .create()
    }

    private fun annotateMissingTypeInFn(parameter: C3Parameter, holder: AnnotationHolder)
    {
        if (parameter.containingFn == null) return

        val fnName = parameter.containingFn.fqName.text
        if (fnName.contains("."))
        {
            if (parameter == parameter.containingFn.parameters.parameterList[0]) return

            if (parameter.type == null)
            {
                holder.newAnnotation(HighlightSeverity.ERROR, "Only typed parameters are allowed for functions.")
                    .range(parameter)
                    .create()
            }
        } else
        {
            if (parameter.type == null)
            {
                holder.newAnnotation(HighlightSeverity.ERROR, "Only typed parameters are allowed for functions.")
                    .range(parameter)
                    .create()
            }
        }
    }
}