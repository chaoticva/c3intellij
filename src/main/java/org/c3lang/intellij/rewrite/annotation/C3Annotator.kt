package org.c3lang.intellij.rewrite.annotation

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import org.c3lang.intellij.rewrite.annotation.AttributeAnnotator.annotateC3Attribute
import org.c3lang.intellij.rewrite.annotation.CallAnnotator.annotateC3Call
import org.c3lang.intellij.rewrite.annotation.FnAnnotator.annotateC3Fn
import org.c3lang.intellij.rewrite.annotation.ParameterAnnotator.annotateC3Parameter
import org.c3lang.intellij.rewrite.annotation.StructAnnotator.annotateC3Struct
import org.c3lang.intellij.rewrite.psi.C3Attribute
import org.c3lang.intellij.rewrite.psi.C3Call
import org.c3lang.intellij.rewrite.psi.C3Fn
import org.c3lang.intellij.rewrite.psi.C3Parameter
import org.c3lang.intellij.rewrite.psi.C3Struct

class C3Annotator : Annotator
{
    override fun annotate(element: PsiElement, holder: AnnotationHolder)
    {
        if (element is C3Call) annotateC3Call(element, holder)
        if (element is C3Fn) annotateC3Fn(element, holder)
        if (element is C3Parameter) annotateC3Parameter(element, holder)
        if (element is C3Struct) annotateC3Struct(element, holder)
        if (element is C3Attribute) annotateC3Attribute(element, holder)
    }
}