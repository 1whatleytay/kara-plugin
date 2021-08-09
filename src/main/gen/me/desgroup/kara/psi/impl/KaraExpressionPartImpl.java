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

public class KaraExpressionPartImpl extends ASTWrapperPsiElement implements KaraExpressionPart {

  public KaraExpressionPartImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KaraVisitor visitor) {
    visitor.visitExpressionPart(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KaraVisitor) accept((KaraVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public KaraLiteral getLiteral() {
    return findNotNullChildByClass(KaraLiteral.class);
  }

  @Override
  @NotNull
  public List<KaraModifier> getModifierList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, KaraModifier.class);
  }

  @Override
  @NotNull
  public List<KaraUnary> getUnaryList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, KaraUnary.class);
  }

}
