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

public class C3CallImpl extends ASTWrapperPsiElement implements C3Call {

  public C3CallImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull C3Visitor visitor) {
    visitor.visitCall(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof C3Visitor) accept((C3Visitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public C3Arguments getArguments() {
    return findNotNullChildByClass(C3Arguments.class);
  }

  @Override
  @NotNull
  public C3CallName getCallName() {
    return findNotNullChildByClass(C3CallName.class);
  }

  @Override
  public C3Fn getFnDefinition() {
    return C3PsiImplUtil.getFnDefinition(this);
  }

  @Override
  public C3Macro getMacroDefinition() {
    return C3PsiImplUtil.getMacroDefinition(this);
  }

  @Override
  public C3Module getModule() {
    return C3PsiImplUtil.getModule(this);
  }

}
