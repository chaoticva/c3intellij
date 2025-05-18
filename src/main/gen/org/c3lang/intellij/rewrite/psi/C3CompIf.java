// This is a generated file. Not intended for manual editing.
package org.c3lang.intellij.rewrite.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface C3CompIf extends PsiElement {

  @Nullable
  C3CompElse getCompElse();

  @NotNull
  C3CompEndif getCompEndif();

  @NotNull
  C3Expr getExpr();

  @NotNull
  List<C3FnStatement> getFnStatementList();

}
