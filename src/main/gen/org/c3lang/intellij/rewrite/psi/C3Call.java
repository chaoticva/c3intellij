// This is a generated file. Not intended for manual editing.
package org.c3lang.intellij.rewrite.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface C3Call extends PsiElement {

  @NotNull
  C3Arguments getArguments();

  @NotNull
  C3CallName getCallName();

  C3Fn getFnDefinition();

  C3Macro getMacroDefinition();

  C3Module getModule();

}
