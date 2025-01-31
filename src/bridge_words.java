import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class bridge_words extends JFrame {
    static JFrame mainFrame;
    String result;
    JLabel textLabel;
    String[] result_list;

    public bridge_words(String title, boolean ifBack) {
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
            this.add(jPanel_NORTH,BorderLayout.NORTH);
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 900);

        //设置节点输入框
        JTextField jTextField1 = new JTextField(20);
        JTextField jTextField2 = new JTextField(20);
        jPanel_CENTER.add(jTextField1,BorderLayout.WEST);
        jPanel_CENTER.add(jTextField2,BorderLayout.CENTER);

        //插入一个展示结果的文本Label
        textLabel = new JLabel();
        textLabel.setText("");
        textLabel.setSize(80, 40);
        textLabel.setText(this.result);
        System.out.println(this.result);
        jPanel_SOUTH.setPreferredSize(new Dimension(0,100));
        jPanel_SOUTH.add(textLabel,BorderLayout.CENTER);

        //设置开始按钮
        JButton jButton = new JButton("Start Searching");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String start = jTextField1.getText();
                String end = jTextField2.getText();
                System.out.println("开始词为：" + start);
                System.out.println("结束词为：" + end);
                //这里获取到开始节点与结束节点的信息了，调用获取结果存入result即可
                result_list = new String[]{"aa", "bb", "cc"};
                StringBuilder stringBuilder = new StringBuilder();
                for (String i : result_list) {
                    stringBuilder.append(i).append(" ");
                }
                bridge_words.this.result = stringBuilder.toString();
                jTextField1.setText("");
                jTextField2.setText("");

                if (bridge_words.this.result != null) {
                    textLabel.setText(bridge_words.this.result);
                } else {
                    textLabel.setText(String.format("找不到%s和%s间的桥接词", start, end));
                }


            }
        });
        jPanel_CENTER.add(jButton,BorderLayout.EAST);

        //插入一张图片
        try {
            BufferedImage originalImage = ImageIO.read(new File("src/tmp.jpg"));

            // 缩放图片尺寸为400*300
            int scaledWidth = 800;
            int scaledHeight = 600;
            BufferedImage scaledImage = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = scaledImage.createGraphics();
            g2d.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null);
            g2d.dispose();

            ImageIcon imageIcon = new ImageIcon(scaledImage);
            JLabel imgLabel = new JLabel(imageIcon);
            imgLabel.setSize(imageIcon.getIconWidth(), imageIcon.getIconHeight());
            jPanel_NORTH.add(imgLabel,BorderLayout.CENTER);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.add(jPanel_CENTER,BorderLayout.CENTER);
        this.add(jPanel_NORTH,BorderLayout.NORTH);
        this.add(jPanel_SOUTH,BorderLayout.SOUTH);
    }

    public void setPanel(JPanel panel) {
        this.setContentPane(panel);
    }

    public String getResult() {
        return this.result;
    }

    public void setTextLabelNull() {
        bridge_words.this.textLabel.setText("");
    }
}
