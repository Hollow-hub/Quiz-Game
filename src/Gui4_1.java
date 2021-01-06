import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui4_1 extends JFrame {
    private JButton Button1;
    private JPanel rootPanel4_1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JLabel WinOrLose;
    private JLabel question;
    private JLabel NumOfRound;
    private JLabel TypeRound;
    private JLabel correctAnswer;
    public Gui_connection gui_con;
    public Game game;


    public Gui4_1(){
        game = new Game();
        gui_con = new Gui_connection();
        add(rootPanel4_1);
        setTitle("Buzz");
        setSize(450,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui_con.answer1 = 1;
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui_con.answer1 = 2;
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui_con.answer1 = 3;
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { gui_con.answer1 = 4; }
        });
    }

}
