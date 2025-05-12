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

public class C3FnImpl extends ASTWrapperPsiElement implements C3Fn {

  public C3FnImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull C3Visitor visitor) {
    visitor.visitFn(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof C3Visitor) accept((C3Visitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<C3Attribute> getAttributeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, C3Attribute.class);
  }

  @Override
  @Nullable
  public C3DocComment getDocComment() {
    return findChildByClass(C3DocComment.class);
  }

  @Override
  @Nullable
  public C3FnBody getFnBody() {
    return findChildByClass(C3FnBody.class);
  }

  @Override
  @NotNull
  public C3FqName getFqName() {
    return findNotNullChildByClass(C3FqName.class);
  }

  @Override
  @Nullable
  public C3Lambda getLambda() {
    return findChildByClass(C3Lambda.class);
  }

  @Override
  @NotNull
  public C3Parameters getParameters() {
    return findNotNullChildByClass(C3Parameters.class);
  }

  @Override
  @NotNull
  public C3Type getType() {
    return findNotNullChildByClass(C3Type.class);
  }

  @Override
  public boolean isExtern() {
    return C3PsiImplUtil.isExtern(this);
  }

  @Override
  public @NotNull LookupElementBuilder getLookupElement() {
    return C3PsiImplUtil.getLookupElement(this);
  }

}
