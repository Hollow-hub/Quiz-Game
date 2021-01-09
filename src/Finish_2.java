import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Finish_2 extends JFrame{
    private JPanel finishPanel;
    private JButton scoreBoardButton;
    private JButton quitGameButton;
    private JLabel P1points;
    private JLabel P2points;
    private JPanel FinishPanel2;

    public Finish_2(int point1 , int point2){
        setUndecorated(true);
        P1points.setText(String.valueOf(point1));
        P2points.setText(String.valueOf(point2));
        add(finishPanel);
        setTitle("Buzz");
        setSize(350,330);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        quitGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        scoreBoardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }
}
