// This is a generated file. Not intended for manual editing.
package org.c3lang.intellij.rewrite.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface C3Module extends PsiElement {

  @NotNull
  C3Path getPath();

  @NotNull
  List<C3Statement> getStatementList();

}
