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
import com.intellij.codeInsight.lookup.LookupElementBuilder;

public class C3ConstImpl extends ASTWrapperPsiElement implements C3Const {

  public C3ConstImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull C3Visitor visitor) {
    visitor.visitConst(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof C3Visitor) accept((C3Visitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public C3Expr getExpr() {
    return findNotNullChildByClass(C3Expr.class);
  }

  @Override
  @Nullable
  public C3Type getType() {
    return findChildByClass(C3Type.class);
  }

  @Override
  public @NotNull String getName() {
    return C3PsiImplUtil.getName(this);
  }

  @Override
  public LookupElementBuilder getLookupElement() {
    return C3PsiImplUtil.getLookupElement(this);
  }

}
