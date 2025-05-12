// This is a generated file. Not intended for manual editing.
package org.c3lang.intellij.rewrite.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;

public interface C3Fn extends PsiElement {

  @NotNull
  List<C3Attribute> getAttributeList();

  @Nullable
  C3DocComment getDocComment();

  @Nullable
  C3FnBody getFnBody();

  @NotNull
  C3FqName getFqName();

  @Nullable
  C3Lambda getLambda();

  @NotNull
  C3Parameters getParameters();

  @NotNull
  C3Type getType();

  boolean isExtern();

  @NotNull LookupElementBuilder getLookupElement();

}
