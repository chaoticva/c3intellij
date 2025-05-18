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

public class C3TermImpl extends ASTWrapperPsiElement implements C3Term {

  public C3TermImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull C3Visitor visitor) {
    visitor.visitTerm(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof C3Visitor) accept((C3Visitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public C3Attribute getAttribute() {
    return findChildByClass(C3Attribute.class);
  }

  @Override
  @Nullable
  public C3Call getCall() {
    return findChildByClass(C3Call.class);
  }

  @Override
  @Nullable
  public C3Cast getCast() {
    return findChildByClass(C3Cast.class);
  }

  @Override
  @Nullable
  public C3Expr getExpr() {
    return findChildByClass(C3Expr.class);
  }

  @Override
  @Nullable
  public C3Field getField() {
    return findChildByClass(C3Field.class);
  }

  @Override
  @Nullable
  public C3Init getInit() {
    return findChildByClass(C3Init.class);
  }

}
