import java.util.Scanner;
import java.util.Random;

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
     * @param question is a row from the questions[20,5] array as 
     *                 mentioned above
     * @return true if user won or false if he lost
     */
    public static boolean interaction(String[] question) {
        System.out.println(question[0]); // that prints the question
        
        int[] questionNumbers = {1,2,3,4};  
        int correctAnswersPlace = 1; 
        
        Random random = new Random();
        int temp, selected;
        // a loop that goes from end to start of the array
        for (int i=questionNumbers.length-1; i>=0; i--) {
            selected = random.nextInt(i); // random number between 0-i(current index)
            // swap the current array value (i) with a randomly selected one
            temp = questionNumbers[i];
            questionNumbers[i] = questionNumbers[selected];
            questionNumbers[selected] = temp;
        }
        // as mentioned before: indexes are in correct order
        // so this holds the number that is shown to the user
        // for the correct answer
        correctAnswersPlace = questionNumbers[0];
        
        // this prints the answers shuffled
        System.out.println(" 1."+question[questionNumbers[0]]+
                        " 2."+ question[questionNumbers[1]]);
        
        System.out.println(" 3."+question[questionNumbers[2]]+
                        " 4."+ question[questionNumbers[3]]);

        System.out.println("Select between: 1, 2, 3, 4 ");
        System.out.println("Answer:");
        Scanner chosen = new Scanner(System.in);
        int playersAnswer = chosen.nextInt();
        short counter=1;
        while (playersAnswer!=1 && playersAnswer!=2 && playersAnswer!=3 && playersAnswer!=4) {
            if(counter==1)
                System.out.println("Wrong Input...please man its 1,2,3,4 how hard can it be??");
            else
                System.out.println("I SAID 1,2,3 or freaking 4, WTF is wrong with you");
            playersAnswer = chosen.nextInt();
            counter+=1;
        }
        chosen.close();
        
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