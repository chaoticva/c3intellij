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

public class C3CompIfImpl extends ASTWrapperPsiElement implements C3CompIf {

  public C3CompIfImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull C3Visitor visitor) {
    visitor.visitCompIf(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof C3Visitor) accept((C3Visitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public C3CompElse getCompElse() {
    return findChildByClass(C3CompElse.class);
  }

  @Override
  @NotNull
  public C3CompEndif getCompEndif() {
    return findNotNullChildByClass(C3CompEndif.class);
  }

  @Override
  @NotNull
  public C3Expr getExpr() {
    return findNotNullChildByClass(C3Expr.class);
  }

  @Override
  @NotNull
  public List<C3FnStatement> getFnStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, C3FnStatement.class);
  }

}
