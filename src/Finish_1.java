import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Finish_1 extends  JFrame{
    private JPanel finishPanel;
    private JButton ScoreBoardButton;
    private JButton quitGameButton;
    private JLabel P1points;

    Finish_1(int roundPoint,int point){

        if (point < roundPoint)
            point = roundPoint;
        setUndecorated(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2 - 150 , dim.height/2-this.getSize().height/2 - 150);
        P1points.setText(String.valueOf(roundPoint));
        add(finishPanel);
        setTitle("Buzz");
        setSize(350,230);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        quitGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        int finalPoint = point;
        ScoreBoardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gui_scores gui_scores = new Gui_scores(finalPoint);
                gui_scores.setVisible(true);
            }
        });
    }

}
