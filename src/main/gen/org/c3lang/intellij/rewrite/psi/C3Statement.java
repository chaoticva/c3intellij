// This is a generated file. Not intended for manual editing.
package org.c3lang.intellij.rewrite.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface C3Statement extends PsiElement {

  @Nullable
  C3Const getConst();

  @Nullable
  C3Enum getEnum();

  @Nullable
  C3Fn getFn();

  @Nullable
  C3Import getImport();

  @Nullable
  C3Macro getMacro();

  @Nullable
  C3Struct getStruct();

  @Nullable
  C3Union getUnion();

  C3Module getModule();

}
