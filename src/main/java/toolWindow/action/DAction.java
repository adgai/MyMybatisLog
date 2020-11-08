package toolWindow.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.ui.content.Content;
import org.jetbrains.annotations.NotNull;

public class DAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here

        ToolWindow toolWindow = e.getData(PlatformDataKeys.TOOL_WINDOW);
        Content myMybatisLog = toolWindow.getContentManager().findContent("MyMybatisLog");
        @NotNull Content[] contents = myMybatisLog.getManager().getContents();

        System.out.println("---------------------------");
        System.out.println(contents);
    }
}
