import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui_timer extends JFrame{
    private JLabel TypeRound;
    private JLabel question;
    public JLabel correctAnswer;
    private JPanel rootPanel4_2;
    private JPanel player2;
    private JPanel Player1;
    public JButton Button1;
    private JButton Button2;
    private JButton Button3;
    private JButton Button4;
    private JLabel NumRound;
    public JButton hbutton;
    private JButton jbutton;
    private JButton kbutton;
    private JButton lbutton;
    public JLabel Timer;
    private JButton nextButton;
    private JButton Exit;
    public int correctAnswersPlace;
    public char answer1;
    public char answer2;
    public boolean buttonPressed1;
    public boolean buttonPressed2;
    public boolean nextButtonPressed;



    private int[] showQuestions(Qac qac){
        correctAnswersPlace = 0;
        Randomizer randomizer = new Randomizer();
        int[] questionNumbers = randomizer.randomize(0, 3);
        // this holds the randomized number of the correct answer
        // find in which place will the correct answer shown
        for (int i=0; i<4; i++) {
            if (questionNumbers[i] == 0) {
                correctAnswersPlace = i;
            }
        }
        int[] answers = {questionNumbers[0],questionNumbers[1],
                questionNumbers[2],questionNumbers[3],correctAnswersPlace};
        return answers;
    }

    public Gui_timer(Qac qac, String typeofRound, int shownRoundNumber) {

        setUndecorated(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2 - 330 , dim.height/2-this.getSize().height/2 - 330);
        NumRound.setText("Round " + String.valueOf(shownRoundNumber));
        TypeRound.setText(typeofRound);
        question.setText(qac.getQuestion());
        add(rootPanel4_2);
        setTitle("Buzz");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        int[] answers = showQuestions(qac);


        Button1.setText("1. " + qac.getAnswers()[answers[0]]);
        Button2.setText("2. " + qac.getAnswers()[answers[1]]);
        Button3.setText("3. " + qac.getAnswers()[answers[2]]);
        Button4.setText("4. " + qac.getAnswers()[answers[3]]);

        hbutton.setText("h. " + qac.getAnswers()[answers[0]]);
        jbutton.setText("j. " + qac.getAnswers()[answers[1]]);
        kbutton.setText("k. " + qac.getAnswers()[answers[2]]);
        lbutton.setText("l. " + qac.getAnswers()[answers[3]]);


        Button1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                answer1 = e.getKeyChar();
                buttonPressed1 = true;
//                if(typeofRound.equals("FastAnswer"))
//                    dispose();
            }
        });
        Button2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
//                super.keyTyped(e);
                answer1 = e.getKeyChar();
                buttonPressed1 = true;
            }
        });
        Button3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
//                super.keyTyped(e);
                answer1 = e.getKeyChar();
                buttonPressed1 = true;
            }
        });
        Button4.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
//                super.keyTyped(e);
                answer1 = e.getKeyChar();
                buttonPressed1 = true;
            }
        });
        hbutton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
//                super.keyTyped(e);
                answer2 = e.getKeyChar();
                buttonPressed2 = true;
            }
        });
        jbutton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
//                super.keyTyped(e);
                answer2 = e.getKeyChar();
                buttonPressed2 = true;
            }
        });
        kbutton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
//                super.keyTyped(e);
                answer2 = e.getKeyChar();
                buttonPressed2 = true;
            }
        });
        lbutton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
//                super.keyTyped(e);
                answer2 = e.getKeyChar();
                buttonPressed2 = true;
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextButtonPressed = true;
            }
        });
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

}