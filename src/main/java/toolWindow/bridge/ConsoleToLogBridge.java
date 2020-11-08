package toolWindow.bridge;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Description :
 * @Author :zhanglei6
 * @Date :2020/11/1 22:03
 **/
public class ConsoleToLogBridge {
    public static JTextArea textArea1;
    /**
     * 不完整sql 参数用 ? 表示
     */
    public static final String Preparing = "Preparing";
    /**
     * 参数，替换不完整sql中的?
     */
    public static final String Parameters = "Parameters";

    public static ArrayBlockingQueue<String> sqlLineArray = new ArrayBlockingQueue<>(1000, true);
    public static ArrayBlockingQueue<String> paraLineArray = new ArrayBlockingQueue<>(1000, true);

    static {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        String paraLine = paraLineArray.take();
                        String sqlLine = sqlLineArray.take();
                        print(sqlLine, paraLine);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }
        });


        thread.setName("fasdfasfdasfdsa");
        thread.start();

    }


    public static boolean log(String line) {
        DefaultCaret caret = (DefaultCaret)textArea1.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);


        if (line.contains(Preparing)) {
            sqlLineArray.add(line);
        } else if (line.contains(Parameters)) {
            paraLineArray.add(line);
        }

        return true;
    }


    public static void print(String sqlLine, String paraLine) {
        String sql = sqlLine.split("Preparing:")[1];
        String allParaStr = paraLine.split("Parameters:")[1];
        if (allParaStr.isEmpty()){
        }else if (allParaStr.trim().replace("\n","").isEmpty()){
        }else {
            String[] paraUnProcessArray = allParaStr.split("\\),");

            List<Para> paraList = new ArrayList<>(paraUnProcessArray.length);


            Arrays.stream(paraUnProcessArray).forEach(paraUnProcess -> {
                String[] split = paraUnProcess.split("\\(");

                String value = split[0];
                String type = split[1].split("\\)")[0];
                Para para = new Para();
                para.type = type;
                para.value = value;
                paraList.add(para);
            });

            for (Para para : paraList) {
                String replacedSql = para.replace(sql);
                sql = replacedSql;
            }
        }

        textArea1.append("--------------");
        textArea1.append("\n");
        String s = sql.replaceFirst("from", "\nfrom").replaceFirst("From", "\nFrom");
        textArea1.append(s);
        textArea1.append("--------------");
        textArea1.append("\n");
    }
}
