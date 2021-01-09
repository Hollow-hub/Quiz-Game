import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Gui4_1 extends JFrame {
    private JButton Button1;
    private JPanel rootPanel4_1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JLabel question;
    private JLabel NumOfRound;
    private JLabel TypeRound;
    private JLabel correctAnswer;
    public JButton nextButton;
    private JButton Exit;
    public int correctAnswersPlace;
    public char answer;
    public boolean buttonPressed;
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

    public Gui4_1(Qac qac, String typeofRound, int shownRoundNumber){

        setUndecorated(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2 - 330 , dim.height/2-this.getSize().height/2 - 330);
        NumOfRound.setText("Round " + String.valueOf(shownRoundNumber));
        TypeRound.setText(typeofRound);
        question.setText(qac.getQuestion());
        add(rootPanel4_1);
        setTitle("Buzz");
        setSize(650,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        int[] answers = showQuestions(qac);
        Button1.setText("1. " + qac.getAnswers()[answers[0]]);
        button2.setText("2. " + qac.getAnswers()[answers[1]]);
        button3.setText("3. " + qac.getAnswers()[answers[2]]);
        button4.setText("4. " + qac.getAnswers()[answers[3]]);
        Button1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                //super.keyTyped(e.getKeyCode());
                answer = e.getKeyChar();
                buttonPressed = true;
                correctAnswer.setText(String.valueOf(correctAnswersPlace + 1));
            }
        });
        button2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
//                super.keyTyped(e);
                answer = e.getKeyChar();
                buttonPressed = true;
                correctAnswer.setText(String.valueOf(correctAnswersPlace + 1));
            }
        });
        button3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
//                super.keyTyped(e);
                answer = e.getKeyChar();
                buttonPressed = true;
                correctAnswer.setText(String.valueOf(correctAnswersPlace + 1));
            }
        });
        button4.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
//                super.keyTyped(e);
                answer = e.getKeyChar();
                buttonPressed = true;
                correctAnswer.setText(String.valueOf(correctAnswersPlace + 1));
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
