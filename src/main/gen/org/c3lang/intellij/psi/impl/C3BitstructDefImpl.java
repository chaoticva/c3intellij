// This is a generated file. Not intended for manual editing.
package org.c3lang.intellij.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.c3lang.intellij.psi.C3Types.*;
import org.c3lang.intellij.psi.*;

public class C3BitstructDefImpl extends C3PsiElementImpl implements C3BitstructDef {

  public C3BitstructDefImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull C3Visitor visitor) {
    visitor.visitBitstructDef(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof C3Visitor) accept((C3Visitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public C3BaseType getBaseType() {
    return findNotNullChildByClass(C3BaseType.class);
  }

  @Override
  @NotNull
  public List<C3Expr> getExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, C3Expr.class);
  }

}
