import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Collections;


public class Round {
    /* η round δεχεται ως ορισματα τον μονοδιαστατο  και τον αριθμο του μονοδιαστατου
    *  και το ειδος της ερωτησης
    * */
    String x="nothing";
    Scanner console = new Scanner(System.in);
    String answer_player_One;


    private int points;
    public Round() {
        points = 0;
    }
    /*  we have an array list: questions [20,5] (String) for the 
    questions(first column) and the answers (other columns)
    the second column is for the right answer
    
    this list is of type: ArrayList<String[]>
    so at each call the functions: right answer and bid
    will get a String as mentioned above
    */ 
    
    /* this method is for the right answer
    type of lap */
    public Boolean rightAnswer() {
        //  just for testing purposes i made a sample 
        //  question with answers;
        String[] question;
        question = new String[5];
        //this is the question
        question[0] = "How tall is the eiffel tower";
        //this is the right answer
        question[1] = "324 meters";
        //the next ones are just random wrong answers
        question[2] = "128 meters";
        question[3] = "256 meters";
        question[4] = "512 meters";
        if (interaction(question)) {
            points += 1000;
            return true;
        }
        else {
            return false;
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
    
    /* this method handles the
    the interaction with the user */
    public static boolean interaction(String[] question) {
        System.out.println(question[0]); // that prints the question
        int[] questionNumbers = {1,2,3,4};  
        String correctAnswer = question[1]; // this holds the correct answer
        int correctAnswersPlace = 1; 
        
        Random random = new Random();
        for (int i:questionNumbers) {
            //numbers are shuffled, but index isn't
            questionNumbers[i] = random.nextInt(512) % i; 
        }

        correctAnswersPlace = questionNumbers[0];
        
        System.out.printf("%n 1. %s   2.%s %n 3.%s  4.%s %n", 
                            question[questionNumbers[1]], 
                            question[questionNumbers[2]],
                            question[questionNumbers[3]], 
                            question[questionNumbers[4]]);
        
        
        System.out.printf("Select between: 1, 2, 3, 4: ");
        Scanner chosen = new Scanner(System.in);
        int playersAnswer = chosen.nextInt();
        chosen.close();
        
        if (playersAnswer == correctAnswersPlace) {
            System.out.printf("Win%n");
            return true;
        }
        else {
            System.out.printf("You idiot, the correct answer is: %s%n",
                                correctAnswer);
            return false;
        }

    }
}