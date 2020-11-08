package toolWindow;

import com.intellij.execution.filters.ConsoleFilterProvider;
import com.intellij.execution.filters.Filter;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

/**
 * @Description :
 * @Author :zhanglei6
 * @Date :2020/10/31 16:52
 **/
public class MyConsoleFilterProvider implements ConsoleFilterProvider {


    @Override
    public @NotNull Filter[] getDefaultFilters(@NotNull Project project) {
        Filter[] filters = new Filter[]{new MyFilter(project)};
        return filters;
    }
}
