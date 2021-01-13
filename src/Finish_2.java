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

    public Finish_2(int point1, int point2,int player1Score, int player2Score){

//        if (point1 > player1Score)
//            player1Score = point1;
//        if (point2 > player2Score)
//            player2Score = point2;
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
        int finalPlayer1Score = player1Score;
        int finalPlayer2Score = player2Score;
        scoreBoardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gui_scores2 gui_scores2 = new Gui_scores2(finalPlayer1Score, finalPlayer2Score);
                gui_scores2.setVisible(true);
            }
        });
    }
}
