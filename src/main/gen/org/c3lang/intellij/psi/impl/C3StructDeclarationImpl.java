// This is a generated file. Not intended for manual editing.
package org.c3lang.intellij.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.c3lang.intellij.psi.C3Types.*;
import org.c3lang.intellij.stubs.C3StructDeclarationStub;
import org.c3lang.intellij.psi.*;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.tree.IElementType;

public class C3StructDeclarationImpl extends C3StubBasedPsiElementBase<C3StructDeclarationStub> implements C3StructDeclaration {

  public C3StructDeclarationImpl(@NotNull C3StructDeclarationStub stub, @NotNull IStubElementType<?, ?> type) {
    super(stub, type);
  }

  public C3StructDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public C3StructDeclarationImpl(@NotNull C3StructDeclarationStub stub, @Nullable IElementType type, @Nullable ASTNode node) {
    super(stub, type, node);
  }

  public void accept(@NotNull C3Visitor visitor) {
    visitor.visitStructDeclaration(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof C3Visitor) accept((C3Visitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public C3Attributes getAttributes() {
    return PsiTreeUtil.getChildOfType(this, C3Attributes.class);
  }

  @Override
  @Nullable
  public C3InterfaceImpl getInterfaceImpl() {
    return PsiTreeUtil.getChildOfType(this, C3InterfaceImpl.class);
  }

  @Override
  @NotNull
  public C3StructBody getStructBody() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, C3StructBody.class));
  }

  @Override
  @NotNull
  public C3TypeName getTypeName() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, C3TypeName.class));
  }

}
