// This is a generated file. Not intended for manual editing.
package org.c3lang.intellij.rewrite.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.c3lang.intellij.rewrite.psi.C3Types.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.c3lang.intellij.rewrite.psi.*;

public class C3FnStatementImpl extends ASTWrapperPsiElement implements C3FnStatement {

  public C3FnStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull C3Visitor visitor) {
    visitor.visitFnStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof C3Visitor) accept((C3Visitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public C3Assignment getAssignment() {
    return findChildByClass(C3Assignment.class);
  }

  @Override
  @Nullable
  public C3Call getCall() {
    return findChildByClass(C3Call.class);
  }

  @Override
  @Nullable
  public C3CompIf getCompIf() {
    return findChildByClass(C3CompIf.class);
  }

  @Override
  @Nullable
  public C3Return getReturn() {
    return findChildByClass(C3Return.class);
  }

}
