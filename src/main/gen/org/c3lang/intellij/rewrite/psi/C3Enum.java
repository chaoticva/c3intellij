// This is a generated file. Not intended for manual editing.
package org.c3lang.intellij.rewrite.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;

public interface C3Enum extends PsiElement {

  @NotNull
  C3EnumBody getEnumBody();

  @Nullable
  C3Parameters getParameters();

  @NotNull String getName();

  @NotNull LookupElementBuilder getLookupElement();

}
