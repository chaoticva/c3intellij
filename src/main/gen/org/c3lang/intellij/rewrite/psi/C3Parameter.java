// This is a generated file. Not intended for manual editing.
package org.c3lang.intellij.rewrite.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;

public interface C3Parameter extends PsiElement {

  @Nullable
  C3Type getType();

  @NotNull String getName();

  LookupElementBuilder getLookupElement();

  C3Fn getContainingFn();

  C3Macro getContainingMacro();

  boolean isBorrowed();

  boolean isUsed();

}
