// This is a generated file. Not intended for manual editing.
package me.desgroup.kara.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface KaraTypenameReference extends PsiElement {

  @Nullable
  KaraTypename getTypename();

  @NotNull
  List<KaraTypenameReferenceAttribute> getTypenameReferenceAttributeList();

}
