// This is a generated file. Not intended for manual editing.
package me.desgroup.kara.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface KaraBodyLine extends PsiElement {

  @Nullable
  KaraBodyAssign getBodyAssign();

  @Nullable
  KaraBodyBlock getBodyBlock();

  @Nullable
  KaraBodyFor getBodyFor();

  @Nullable
  KaraBodyIf getBodyIf();

  @Nullable
  KaraBodyStatement getBodyStatement();

  @Nullable
  KaraExpression getExpression();

  @Nullable
  KaraFunctionStrict getFunctionStrict();

  @Nullable
  KaraVariableStrict getVariableStrict();

}
