// This is a generated file. Not intended for manual editing.
package org.c3lang.intellij.rewrite.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface C3FnStatement extends PsiElement {

  @Nullable
  C3Assignment getAssignment();

  @Nullable
  C3Call getCall();

  @Nullable
  C3Return getReturn();

}
