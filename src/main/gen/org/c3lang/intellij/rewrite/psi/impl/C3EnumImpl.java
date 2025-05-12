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

public class C3EnumImpl extends ASTWrapperPsiElement implements C3Enum {

  public C3EnumImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull C3Visitor visitor) {
    visitor.visitEnum(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof C3Visitor) accept((C3Visitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public C3EnumBody getEnumBody() {
    return findNotNullChildByClass(C3EnumBody.class);
  }

  @Override
  @Nullable
  public C3Parameters getParameters() {
    return findChildByClass(C3Parameters.class);
  }

  @Override
  public @NotNull String getName() {
    return C3PsiImplUtil.getName(this);
  }

  @Override
  public @NotNull LookupElementBuilder getLookupElement() {
    return C3PsiImplUtil.getLookupElement(this);
  }

}
