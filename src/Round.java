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
 * @version 0.0.1
 */
public class Round {
    /* η round δεχεται ως ορισματα τον μονοδιαστατο  και τον αριθμο του μονοδιαστατου
    *  και το ειδος της ερωτησης
    * */
    String x="nothing";
    Scanner console = new Scanner(System.in);
    String answer_player_One;


    private int points;

    public Round() {
        this.points = 0;
    }

    /**
     * this method is for the "right answer" type of lap and it
     * gets an array: questions[20,5] (String) as input
     * the first column has the questions
     * the seconde column has the correct answer for each question
     * the other columns have the incorrect answers (one per column)
     * @return true if player won or 
     *         false if he lost
     */
    public Boolean rightAnswer() {
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
            return true; // true means he won
        }
        else {
            return false; // false means he lost
        }
    }

    public void bid(){
        System.out.println("The category is bidding!");
        System.out.println("You can bid 250,500,750 and 1000 points");
        int bid_player_One=console.nextInt();
        while (bid_player_One != 250 && bid_player_One != 500 && bid_player_One != 750 && bid_player_One != 1000){
            System.out.println("You can't bid" + console + "points");
            System.out.println("Please bid again");
            bid_player_One = console.nextInt();
        }
        System.out.println("");  /* εδω εμφανιζεται η ερωτηση */
        System.out.println("");  /* εδω εμφανιζονται οι 4 απαντησεις */
        answer_player_One = console.nextLine();
        if (answer_player_One.equals(x)) /* εδω γινεται ελεγχος για το αν ο παιχτης απαντησε σωστα */
            System.out.println("You WIN!" + bid_player_One + "points");
        else
            System.out.println("You LOSE" + bid_player_One + "points");
    }
    
    /**
     * this method handles the interaction (questions and anwers)
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
        
        // this prints the questions shuffled
        System.out.println("1."+question[questionNumbers[0]]+
                        " 2."+ question[questionNumbers[1]]);
        
        System.out.println("3."+question[questionNumbers[2]]+
                        " 4."+ question[questionNumbers[3]]);

        System.out.println("Select between: 1, 2, 3, 4: ");
        Scanner chosen = new Scanner(System.in);
        int playersAnswer = chosen.nextInt();
        chosen.close();
        
        if (playersAnswer == correctAnswersPlace) {
            System.out.println("Win");
            return true;
        }
        else {
            System.out.println("You idiot, the correct answer is: "+
                                question[1]);
            return false;
        }
    }
}