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
        System.out.println(qac.getQuestion()); // that prints the question
        
        int correctAnswersPlace;
        Randomizer randomizer = new Randomizer();
        int[] questionNumbers = randomizer.randomize(1, 4);// shuffle numbers 1-4

        // indexes are in correct order (0-3)
        // so this holds the number that is shown to the user
        // for the correct answer
        correctAnswersPlace = questionNumbers[0];
        
        // this prints the answers in random order
        System.out.println(" 1."+qac.getAnswers()[questionNumbers[0]-1]+
                        " 2."+ qac.getAnswers()[questionNumbers[1]-1]);
        
        System.out.println(" 3."+qac.getAnswers()[questionNumbers[2]-1]+
                        " 4."+ qac.getAnswers()[questionNumbers[3]-1]);

        System.out.println("Select between: 1, 2, 3, 4 ");
        System.out.println("Answer:");
        Scanner chosen = new Scanner(System.in);
        int playersAnswer = chosen.nextInt();
        short counter=1;
        while (playersAnswer!=1 && playersAnswer!=2 && 
                playersAnswer!=3 && playersAnswer!=4) {
            if (counter == 1) {
                System.out.println("Wrong Input...please man its 1,2,3,4 how hard can it be??");
            }
            else {
                System.out.println("I SAID 1,2,3 or freaking 4, WTF is wrong with you");
            }
            playersAnswer = chosen.nextInt();
            counter += 1;
        }
        
        if (playersAnswer == correctAnswersPlace) {
            System.out.println("You Win");
            return true;
        }
        else {
            System.out.println("You idiot, the correct answer is: "+
                                correctAnswersPlace);
            return false;
        }
    }
}