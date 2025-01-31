import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class random_wonder extends JFrame {
    static JFrame mainFrame;
    String result;
    String node_now;
    JLabel textLabel;

    public random_wonder(String title, boolean ifBack) {
        //设置标题
        super(title);

        //设置三个区域的Panel
        JPanel jPanel_NORTH = new JPanel();
        JPanel jPanel_CENTER = new JPanel();
        JPanel jPanel_SOUTH = new JPanel();
        jPanel_NORTH.setLayout(new BorderLayout());
        jPanel_SOUTH.setLayout(new BorderLayout());
        jPanel_CENTER.setLayout(new BorderLayout());
        this.setLayout(new BorderLayout());

        //设置一个返回到mainFrame的按钮
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

        //插入一个展示结果的文本Label
        textLabel = new JLabel();
        textLabel.setSize(80, 40);
        textLabel.setText(this.result);
        System.out.println(this.result);
        textLabel.setPreferredSize(new Dimension(0,100));
        jPanel_CENTER.add(textLabel,BorderLayout.SOUTH);

        //以及存储所有结果的stringBuilder
        StringBuilder stringBuilder = new StringBuilder();

        //设置下一步按钮
        JButton jButton = new JButton("Start Searching");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //让node_now获取返回的结果
                node_now = "aa";

                //每次按钮，stringBuilder就多连接一个字符串
                stringBuilder.append(node_now).append(" ");

                //这里获取到随机游走节点的信息了，存入result即可
                random_wonder.this.result = stringBuilder.toString();

                if (random_wonder.this.node_now != null) {
                    textLabel.setText(random_wonder.this.node_now);
                }


            }
        });
        jPanel_SOUTH.add(jButton,BorderLayout.WEST);

        //设置写入文件按钮
        JButton jButton2 = new JButton("save as file");
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (FileWriter writer = new FileWriter("file_saved/random_wonder.txt")) {
                    writer.write(random_wonder.this.result);
                    System.out.println("成功写入文件！");
                } catch (IOException e2) {
                    e2.printStackTrace();
                    System.out.println("写入文件时发生错误！");
                }
            }
        });
        jPanel_SOUTH.add(jButton2,BorderLayout.EAST);

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
            jPanel_CENTER.add(imgLabel,BorderLayout.CENTER);
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
        random_wonder.this.textLabel.setText("");
    }
}
