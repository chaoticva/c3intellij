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

public class C3ContractImpl extends ASTWrapperPsiElement implements C3Contract {

  public C3ContractImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull C3Visitor visitor) {
    visitor.visitContract(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof C3Visitor) accept((C3Visitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public C3DeprecatedContract getDeprecatedContract() {
    return findChildByClass(C3DeprecatedContract.class);
  }

  @Override
  @Nullable
  public C3EnsureContract getEnsureContract() {
    return findChildByClass(C3EnsureContract.class);
  }

  @Override
  @Nullable
  public C3ParamContract getParamContract() {
    return findChildByClass(C3ParamContract.class);
  }

  @Override
  @Nullable
  public C3PureContract getPureContract() {
    return findChildByClass(C3PureContract.class);
  }

  @Override
  @Nullable
  public C3RequireContract getRequireContract() {
    return findChildByClass(C3RequireContract.class);
  }

  @Override
  @Nullable
  public C3ReturnContract getReturnContract() {
    return findChildByClass(C3ReturnContract.class);
  }

}
