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

public class KaraTypeBodyImpl extends ASTWrapperPsiElement implements KaraTypeBody {

  public KaraTypeBodyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KaraVisitor visitor) {
    visitor.visitTypeBody(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KaraVisitor) accept((KaraVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public KaraTypeAliasBody getTypeAliasBody() {
    return findChildByClass(KaraTypeAliasBody.class);
  }

  @Override
  @Nullable
  public KaraTypeDeclarationBody getTypeDeclarationBody() {
    return findChildByClass(KaraTypeDeclarationBody.class);
  }

}
