import java.util.Scanner;
import java.util.Random;

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
}