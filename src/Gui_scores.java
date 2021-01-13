import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui_scores extends JFrame {
    private JPanel scorePanel;
    private JButton backButton;
    private JLabel PointsPlayer1;

    Gui_scores(int point){
        PointsPlayer1.setText(String.valueOf(point));
        setUndecorated(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2 - 150 , dim.height/2-this.getSize().height/2 - 150);
        add(scorePanel);
        setSize(350,230);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}

