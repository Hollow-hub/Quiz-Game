import java.util.Scanner;

/**
 * This class handles the command line interface
 * with the user
 * @author Katsikas Stefanos
 * @author Gkountelos Dimitrios
 * @version 0.0.1
 */
public class CliInterface {
    /**
     * this method handles the interaction (questions and answers)
     * with the user
     * @param qac is an object from the class: Qac,
     *          which has question, answers[4] and category
     * @return true if user won or false if he lost
     */
    public boolean interaction(Qac qac) {
        System.out.println(qac.getQuestion());
        int correctAnswersPlace = 0;
        Randomizer randomizer = new Randomizer();
        int[] questionNumbers = randomizer.randomize(0, 3);
        // this holds the randomized number of the correct answer
        // correctAnswersPlace = questionNumbers[0];
        for (int i=0; i<4; i++) {
            if (questionNumbers[i] == 0) {
                correctAnswersPlace = i;
            }
        }

        System.out.println("1."+qac.getAnswers()[questionNumbers[0]]);
        System.out.println("2."+qac.getAnswers()[questionNumbers[1]]);
        System.out.println("3."+qac.getAnswers()[questionNumbers[2]]);
        System.out.println("4."+qac.getAnswers()[questionNumbers[3]]);

        Scanner scanner = new Scanner(System.in);
        int playersAnswer = scanner.nextInt();

        if ((playersAnswer - 1) == correctAnswersPlace) {
            System.out.println("Correct");
            return true;
        }
        else {
            System.out.println("Nope");
            return false;
        }
    }
}