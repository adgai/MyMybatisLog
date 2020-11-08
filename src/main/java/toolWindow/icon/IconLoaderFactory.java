package toolWindow.icon;

import com.intellij.icons.AllIcons;
import com.intellij.ui.IconManager;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * @Description :
 * @Author :zhanglei6
 * @Date :2020/11/4 20:11
 **/
public class IconLoaderFactory {

     public static final Icon GREEN_BIRD = load("/pluginIcon.svg");
     private static @NotNull Icon load(@NotNull String path) {
          return IconManager.getInstance().getIcon(path, AllIcons.class);
     }
}
