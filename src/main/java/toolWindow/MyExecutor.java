package toolWindow;

import com.intellij.execution.Executor;
import com.intellij.openapi.util.NlsActions;
import com.intellij.openapi.wm.ToolWindowId;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * @Description :
 * @Author :zhanglei6
 * @Date :2020/10/31 17:18
 **/
public class MyExecutor extends Executor {
    /**
     * Returns the ID of the toolwindow in which the run tabs created by this executor will be displayed.
     *
     * @return the ID of the toolwindow (usually {@link ToolWindowId#RUN} or
     * {@link ToolWindowId#DEBUG}).
     */
    @Override
    public @NotNull String getToolWindowId() {
        return "1212";
    }

    @Override
    public @NotNull Icon getToolWindowIcon() {
        return new ImageIcon(getClass().getResource("/toolWindow/Calendar-icon.png"));
    }

    /**
     * Returns the 16x16 icon for the toolbar button corresponding to the executor.
     *
     * @return the icon.
     */
    @Override
    public @NotNull Icon getIcon() {
        return new ImageIcon(getClass().getResource("/toolWindow/Calendar-icon.png"));
    }

    /**
     * Returns the 16x16 icon for the disabled toolbar button corresponding to the executor.
     *
     * @return the icon for the disabled button.
     */
    @Override
    public Icon getDisabledIcon() {
        return new ImageIcon(getClass().getResource("/toolWindow/Calendar-icon.png"));
    }

    /**
     * Returns the action description (text displayed in the status bar) for the toolbar button corresponding to the executor.
     *
     * @return the executor action description.
     */
    @Override
    public @NlsActions.ActionDescription String getDescription() {
        return null;
    }

    @Override
    public @NotNull @NlsActions.ActionText String getActionName() {
        return "fa2323";
    }

    /**
     * Returns the unique ID of the executor.
     *
     * @return the ID of the executor.
     */
    @Override
    public @NotNull String getId() {
        return "MyMybatisLogId";
    }


    @Override
    public @NotNull @Nls(capitalization = Nls.Capitalization.Title) String getStartActionText() {
        return "2323sgsg";
    }

    @Override
    public String getContextActionId() {
        return "2dg3223";
    }

    @Override
    public String getHelpId() {
        return "!31affa";
    }
}
