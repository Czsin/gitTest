import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
    static JFrame mainFrame;

    public MyFrame(String title, boolean ifBack) {
        super(title);
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

            jPanel.add(jButton);
            this.setPanel(jPanel);
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 900);
    }

    public void setPanel(JPanel panel) {
        this.setContentPane(panel);
    }
}
