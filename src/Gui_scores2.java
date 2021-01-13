import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui_scores2 extends JFrame{
    private JPanel scorePanel2;
    private JLabel winsPLayer1;
    private JLabel winsPLayer2;
    private JButton backButton;

    Gui_scores2(int player1Score, int player2Score){
        winsPLayer1.setText(String.valueOf(player1Score));
        winsPLayer2.setText(String.valueOf(player2Score));
        setUndecorated(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2 - 220 , dim.height/2-this.getSize().height/2 - 150);
        add(scorePanel2);
        setSize(450,330);
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
