import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class firstFrame extends JFrame {
    static JFrame MainFrame;
    String text_path;

    public firstFrame() {
        super("firstFrame");
        JPanel root = new JPanel();
        this.setSize(1200, 900);

        //选择文件的按钮
        JButton choosePathButton = new JButton("choose text path");
        choosePathButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                // 设置默认当前目录为文件系统的用户目录（可选项）
                fileChooser.setCurrentDirectory(new java.io.File("."));
                // 显示文件选择对话框
                int returnValue = fileChooser.showOpenDialog(firstFrame.this);

                // 如果用户选择了一个文件（点击了打开）
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                    firstFrame.this.text_path = selectedFile.getAbsolutePath();
                } else {
                    // 用户取消了选择或关闭了对话框
                }
            }
        });


        //跳转到主页的按钮
        JButton jButton = new JButton("Jump to mainFrame");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainFrame.setVisible(true);
            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //稍微调整一下布局
        this.setLayout(new BorderLayout());
        root.add(choosePathButton);
        root.add(jButton);
        root.setPreferredSize(new Dimension(0,100));
        this.add(root,BorderLayout.SOUTH);

    }

    public String getText_path(){
        return this.text_path;
    }

    public static void setMainFrame(JFrame mainFrame) {
        firstFrame.MainFrame = mainFrame;
    }

}
