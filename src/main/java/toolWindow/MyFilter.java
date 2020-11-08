package toolWindow;
import com.intellij.execution.filters.Filter;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import toolWindow.bridge.ConsoleToLogBridge;

/**
 * @Description :
 * @Author :zhanglei6
 * @Date :2020/10/31 17:00
 **/
public class MyFilter implements Filter {
    Project project;

    @Override
    public @Nullable Result applyFilter(@NotNull String line, int entireLength) {
        System.out.println(line);

        ConsoleToLogBridge.log(line);
        return null;
    }


    public MyFilter(Project project) {
        this.project = project;
    }
}
