package toolWindow;

import com.intellij.openapi.wm.ToolWindow;
import toolWindow.bridge.ConsoleToLogBridge;

import javax.swing.*;

/**
 * @Description :
 * @Author :zhanglei6
 * @Date :2020/10/31 15:17
 **/
public class MyMybatisLogWindow {
    private JTextArea textArea1;
    private JButton create;
    private JPanel myContent;
    private JButton clear;


    void  setAutoScroll(){
    }

    public MyMybatisLogWindow(ToolWindow toolWindow) {

        clear.addActionListener(e ->
        {
            textArea1.setText("");
        });

        ConsoleToLogBridge.textArea1 = textArea1;
    }

    public JPanel getContent() {
        return myContent;
    }


    public void print(String s){
        textArea1.append(s+"\n");
    }


}
