// This is a generated file. Not intended for manual editing.
package org.c3lang.intellij.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface C3InterfaceDefinition extends C3PsiElement {

  @NotNull
  C3InterfaceBody getInterfaceBody();

  @NotNull
  List<C3Type> getTypeList();

  @NotNull
  C3TypeName getTypeName();

}
