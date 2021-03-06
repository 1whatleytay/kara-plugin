// This is a generated file. Not intended for manual editing.
package me.desgroup.kara.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface KaraExpressionPart extends PsiElement {

  @NotNull
  List<KaraExpressionGrouping> getExpressionGroupingList();

  @NotNull
  KaraLiteral getLiteral();

  @NotNull
  List<KaraModifier> getModifierList();

  @NotNull
  List<KaraUnary> getUnaryList();

}
