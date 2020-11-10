import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Collections;

/**
 * This class represents each Round 
 * in the game. Different method are 
 * for different types of rounds 
 * @author Katsikas Stefanos
 * @author Gkountelos Dimitrios
 * @version 0.0.2
 */
public class Round {
    /**
     * Round takes as parameters, 2 arrays and the question category
     */

    Scanner console = new Scanner(System.in);
    private int points;

    public Round() {
        this.points = 0;
    }

    /**
     * this method is for the "right answer" type of round and it
     * gets an array: questions[20,5] (String) as input
     * the first column has the questions
     * the second column has the correct answer for each question
     * the other columns have the incorrect answers (one per column)
     */
    public void rightAnswer() {
        //  just for testing purposes i made a sample 
        //  question with answers;
        String[] question;// this will be a parameter in the function
        question = new String[5];
        //this is the question
        question[0] = "How tall is the eiffel tower";
        //this is the right answer
        question[1] = "324 meters";
        //the next ones are just random wrong answers
        question[2] = "128 meters";
        question[3] = "256 meters";
        question[4] = "512 meters";
       
        if (interaction(question) == true) {
            //this.points += 1000;
        }

    }

    /**
     * this method is for "bidding" type of round and it
     * gets an array: questions[20,5] (String) as input
     * and it has the same input as the "right answer" type
     * for the moment
     */

    public void bid(){

        //  just for testing purposes i made a sample
        //  question with answers;
        String[] question;// this will be a parameter in the function
        question = new String[5];
        //this is the question
        question[0] = "How tall is the eiffel tower";
        //this is the right answer
        question[1] = "324 meters";
        //the next ones are just random wrong answers
        question[2] = "128 meters";
        question[3] = "256 meters";
        question[4] = "512 meters";


        System.out.println("The category is bidding!");
        System.out.println("You can bid 250,500,750 and 1000 points");
        int bid_player = console.nextInt();    // here it takes an input "bid" from the user
        while (bid_player != 250 && bid_player != 500 && bid_player != 750 && bid_player != 1000){ //checks for wrong input
            System.out.println("You can't bid" + console + "points");
            System.out.println("Please bid again");
            bid_player = console.nextInt();
        }
        if (interaction(question) == true) {
            System.out.println("take your" + bid_player + "that you had bidden");
            //this.points += bid_player;
        }

    }
    
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