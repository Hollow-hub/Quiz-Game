import javax.swing.*;

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


    public Gui4_1(){
        add(rootPanel4_1);
        setTitle("Buzz");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

}
