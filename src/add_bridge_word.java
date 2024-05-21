import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class add_bridge_word extends JFrame {
    static JFrame mainFrame;
    String result;
    JLabel textLabel;

    public add_bridge_word(String title, boolean ifBack) {
        super(title);

        //设置三个区域的Panel
        JPanel jPanel_NORTH = new JPanel();
        JPanel jPanel_CENTER = new JPanel();
        JPanel jPanel_SOUTH = new JPanel();
        jPanel_NORTH.setLayout(new BorderLayout());
        jPanel_SOUTH.setLayout(new BorderLayout());
        jPanel_CENTER.setLayout(new BorderLayout());
        this.setLayout(new BorderLayout());

        if (ifBack) {
            JButton jButton = new JButton("BACK");
            JPanel jPanel = new JPanel();

            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    mainFrame.setVisible(true);
                }
            });

            jPanel_NORTH.add(jButton,BorderLayout.WEST);
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 900);

        //设置输入框
        JTextField jTextField1 = new JTextField(20);
        jPanel_CENTER.add(jTextField1,BorderLayout.CENTER);

        //插入一个展示结果的文本Label
        textLabel = new JLabel();
        textLabel.setText(" ");
        textLabel.setSize(80, 40);
        textLabel.setText(this.result);
        System.out.println(this.result);
        jPanel_SOUTH.add(textLabel,BorderLayout.CENTER);

        //设置开始按钮
        JButton jButton = new JButton("Start Searching");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textToSwitch = jTextField1.getText();
                System.out.println("要转换的句子文本为：" + textToSwitch);
                //这里获取到开始节点与结束节点的信息了，调用获取结果存入result即可
                add_bridge_word.this.result = "tmp String";
                jTextField1.setText("");

                if (add_bridge_word.this.result != null) {
                    textLabel.setText(add_bridge_word.this.result);
                }


            }
        });
        jPanel_CENTER.add(jButton,BorderLayout.EAST);

        this.add(jPanel_CENTER,BorderLayout.CENTER);
        this.add(jPanel_NORTH,BorderLayout.NORTH);
        this.add(jPanel_SOUTH,BorderLayout.SOUTH);
        jPanel_SOUTH.setPreferredSize(new Dimension(0,100));
    }

    public void setPanel(JPanel panel) {
        this.setContentPane(panel);
    }

    public String getResult() {
        return this.result;
    }

    public void setTextLabelNull() {
        add_bridge_word.this.textLabel.setText("");
    }
}
