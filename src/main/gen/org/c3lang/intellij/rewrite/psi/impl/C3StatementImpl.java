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

public class C3StatementImpl extends ASTWrapperPsiElement implements C3Statement {

  public C3StatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull C3Visitor visitor) {
    visitor.visitStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof C3Visitor) accept((C3Visitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public C3Const getConst() {
    return findChildByClass(C3Const.class);
  }

  @Override
  @Nullable
  public C3Enum getEnum() {
    return findChildByClass(C3Enum.class);
  }

  @Override
  @Nullable
  public C3Faultdef getFaultdef() {
    return findChildByClass(C3Faultdef.class);
  }

  @Override
  @Nullable
  public C3Fn getFn() {
    return findChildByClass(C3Fn.class);
  }

  @Override
  @Nullable
  public C3Import getImport() {
    return findChildByClass(C3Import.class);
  }

  @Override
  @Nullable
  public C3Macro getMacro() {
    return findChildByClass(C3Macro.class);
  }

  @Override
  @Nullable
  public C3Struct getStruct() {
    return findChildByClass(C3Struct.class);
  }

  @Override
  @Nullable
  public C3Union getUnion() {
    return findChildByClass(C3Union.class);
  }

  @Override
  public C3Module getModule() {
    return C3PsiImplUtil.getModule(this);
  }

}
