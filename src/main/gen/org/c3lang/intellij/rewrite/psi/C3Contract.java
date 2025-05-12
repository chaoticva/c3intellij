// This is a generated file. Not intended for manual editing.
package org.c3lang.intellij.rewrite.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface C3Contract extends PsiElement {

  @Nullable
  C3DeprecatedContract getDeprecatedContract();

  @Nullable
  C3EnsureContract getEnsureContract();

  @Nullable
  C3ParamContract getParamContract();

  @Nullable
  C3PureContract getPureContract();

  @Nullable
  C3RequireContract getRequireContract();

  @Nullable
  C3ReturnContract getReturnContract();

}
