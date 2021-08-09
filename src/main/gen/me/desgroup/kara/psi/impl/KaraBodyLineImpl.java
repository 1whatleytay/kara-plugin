// This is a generated file. Not intended for manual editing.
package me.desgroup.kara.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static me.desgroup.kara.psi.KaraTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import me.desgroup.kara.psi.*;

public class KaraBodyLineImpl extends ASTWrapperPsiElement implements KaraBodyLine {

  public KaraBodyLineImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KaraVisitor visitor) {
    visitor.visitBodyLine(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KaraVisitor) accept((KaraVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public KaraBodyAssign getBodyAssign() {
    return findChildByClass(KaraBodyAssign.class);
  }

  @Override
  @Nullable
  public KaraBodyBlock getBodyBlock() {
    return findChildByClass(KaraBodyBlock.class);
  }

  @Override
  @Nullable
  public KaraBodyFor getBodyFor() {
    return findChildByClass(KaraBodyFor.class);
  }

  @Override
  @Nullable
  public KaraBodyIf getBodyIf() {
    return findChildByClass(KaraBodyIf.class);
  }

  @Override
  @Nullable
  public KaraBodyStatement getBodyStatement() {
    return findChildByClass(KaraBodyStatement.class);
  }

  @Override
  @Nullable
  public KaraExpression getExpression() {
    return findChildByClass(KaraExpression.class);
  }

  @Override
  @Nullable
  public KaraFunctionStrict getFunctionStrict() {
    return findChildByClass(KaraFunctionStrict.class);
  }

  @Override
  @Nullable
  public KaraVariableStrict getVariableStrict() {
    return findChildByClass(KaraVariableStrict.class);
  }

}
