package org.c3lang.intellij.rewrite.annotation

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.HighlightSeverity
import org.c3lang.intellij.rewrite.psi.C3Call
import org.c3lang.intellij.rewrite.util.C3ErrorMessages

object CallAnnotator
{
    fun annotateC3Call(call: C3Call, holder: AnnotationHolder)
    {
        annotateArgumentCount(call, holder)
    }

    private fun annotateArgumentCount(call: C3Call, holder: AnnotationHolder)
    {
        val fn = call.fnDefinition

        if (fn == null)
        {
            // TODO: add annotation for fun not found
            return
        }

        if (call.arguments.exprList.size < fn.parameters.parameterList.size)
        {
            // TODO: check for vararg
            if (call.arguments.exprList.size == fn.parameters.parameterList.size - 1)
            {
                holder
                    .newAnnotation(HighlightSeverity.ERROR, C3ErrorMessages.ARGUMENTS_1)
                    .create()
            } else
            {
                holder
                    .newAnnotation(HighlightSeverity.ERROR, C3ErrorMessages.ARGUMENTS_2.format(fn.parameters.parameterList.size - call.arguments.exprList.size))
                    .create()
            }
        }

        if (call.arguments.exprList.size > fn.parameters.parameterList.size)
        {
            // TODO: check for vararg
            holder
                .newAnnotation(HighlightSeverity.ERROR, C3ErrorMessages.ARGUMENTS_3)
                .range(call.arguments.exprList[fn.parameters.parameterList.size])
                .create()
        }

        // TODO: add type checking
    }
}