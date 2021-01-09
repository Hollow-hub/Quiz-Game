import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Finish_2 extends JFrame{
    private JPanel finishPanel;
    private JButton scoreBoardButton;
    private JButton quitGameButton;
    private JLabel P1points;
    private JLabel P2points;
    private JPanel FinishPanel2;
    public JLabel Player1;
    public JLabel Player2;
    public JLabel Won;
    public JLabel Lost;

    public Finish_2(int point1 , int point2){
        setUndecorated(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2 - 150 , dim.height/2-this.getSize().height/2 - 150);
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
