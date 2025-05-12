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

public class C3EnumBodyImpl extends ASTWrapperPsiElement implements C3EnumBody {

  public C3EnumBodyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull C3Visitor visitor) {
    visitor.visitEnumBody(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof C3Visitor) accept((C3Visitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<C3EnumValue> getEnumValueList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, C3EnumValue.class);
  }

}
