import java.util.Scanner;

/**
 * This class handles the command line interface
 * with the user
 * @author Katsikas Stefanos
 * @author Gkountelos Dimitrios
 * @version 0.1.0
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
        // find in which place will the correct answer shown
        for (int i=0; i<4; i++) {
            if (questionNumbers[i] == 0) {
                correctAnswersPlace = i;
            }
        }

        // print all the answers
        System.out.println("1." + qac.getAnswers()[questionNumbers[0]] + "   " +
                            "2." + qac.getAnswers()[questionNumbers[1]] + "\n" +
                            "3." + qac.getAnswers()[questionNumbers[2]] + "   " +
                            "4." + qac.getAnswers()[questionNumbers[3]]);

        System.out.println("Select between: 1, 2, 3, 4 \n" + 
                            "Answer:");
        // get users answer
        Scanner scanner = new Scanner(System.in);
        int playersAnswer = scanner.nextInt();
        byte counter = 1;
        // check if playersAnswers is valid
        while (playersAnswer!=1 && playersAnswer!=2 && 
                playersAnswer!=3 && playersAnswer!=4) {
            if (counter == 1) {
                System.out.println("Wrong Input...please man its 1,2,3,4 how hard can it be??");
            }
            else {
                System.out.println("I SAID 1,2,3 or freaking 4, WTF is wrong with you");
            }
            playersAnswer = scanner.nextInt();
            counter += 1;
        }

        // player chose between 1-4 and we handle 0-3
        if ((playersAnswer - 1) == correctAnswersPlace) {
            System.out.println("You Win");
            return true;
        }
        else {
            System.out.println("You idiot, the correct answer is: " +
                                correctAnswersPlace);
            return false;
        }
    }
}