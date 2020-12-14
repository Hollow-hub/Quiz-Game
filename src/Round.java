import java.util.ArrayList;
import java.util.Scanner;


/**
 * This class represents each Round 
 * in the game. Different method are 
 * for different types of rounds 
 * @author Katsikas Stefanos
 * @author Gkountelos Dimitrios
 * @version 1.1.1
 */
public class Round {


    private int points;
    private final CliInterface CLI;
    private PassedTime timer;
    private int Player1_points;
    private int Player2_points;

    public Round() {
        this.points = 0;
        this.CLI = new CliInterface();
        this.timer = new PassedTime();
        this.Player1_points = 0;
        this.Player2_points = 0;
    }

    /**  
     * @return points in the game so far
     */
    public int getPoint() {
        return points;
    }
    /**
     * this method is for the "right answer" type of round and it
     * @param qac is an object from the class: Qac
     * the first column has the questions
     * the second column has the correct answer for each question
     * the other columns have the incorrect answers (one per column)
     */
    public void rightAnswer(Qac qac) {
        //  question with answers;
        if (CLI.interaction(qac)) {
            this.points += 1000;
            System.out.println("Take 1000 points!!!");
        }
    }
    
    /**
     * this method is for "bidding" type of round and it
     * gets an array: questions[20,5] (String) as input.
     * @param qac is an object from the class Qac, which
     *            includes question, answers[], category
     */
    public void bid(Qac qac){
        String category = qac.getCategory();
        System.out.println("The category is" + category);
        System.out.println("You can bid 250,500,750 and 1000 points");
        Scanner console = new Scanner(System.in);
        int bid_player = console.nextInt();    // here it takes an input "bid" from the user
        while (bid_player != 250 && bid_player != 500 && bid_player != 750 && bid_player != 1000){ //checks for wrong input
            System.out.println("You can't bid " + bid_player + " points");
            System.out.println("Please bid again");
            bid_player = console.nextInt();
        }
        // console.close();
        
        if (CLI.interaction(qac)) {
            System.out.println("take your " + bid_player + " that you had bidden");
            this.points += bid_player;
        }
        else{
            System.out.println("You have lost " + bid_player + " points");
            this.points -= bid_player;
        }
    }

    /**
     * this method is for "stop the timer" type
     * of round  and it gets an
     * array: questions[20,5] (String) as input.
     * @param qac is an object from the class Qac,
     * which includes question, answers[], category
     */
    public void StopTheTimer(Qac qac){
        System.out.println("You are playing stop the timer!!!");
        System.out.println("Player1 goes first");
        //player1 timer
        timer.start1();
        if (CLI.multiplayerInteraction(qac) == 1){
            timer.stop1();
            this.Player1_points += timer.getSeconds1()*0.2;
        }
        System.out.println("Now is Player2 row");
        //player2 timer
        timer.start2();
        if (CLI.multiplayerInteraction(qac) == 2){
            timer.stop2();
            this.Player2_points += timer.getSeconds2()*0.2;
        }

    }

    /**
     * 
     * @param qac
     */
    public void fastAnswer(Qac qac){
        int result = CLI.fastAnswerInteraction(qac);
        if (result == 1) {
            Player1_points += 1000;
        }
        else if (result == 2) {
            Player2_points += 1000;
        }
    }

    /**
     * 2 Arraylists to save the progress of the 2 players
     */
    ArrayList<Integer> p1Answers = new ArrayList<>(5);
    ArrayList<Integer> p2Answers = new ArrayList<>(5);

    /**
     * this method is for "Thermometer" type
     * of round  and it gets an  array: questions[20,5] (String) as input.
     * @param qac is an object from the class Qac,
     *      * which includes question, answers[], category
     * @return 1 if someone of the 2 players found 5 correct
     * answers
     */
    public int Thermometer(Qac qac){
        if (CLI.multiplayerInteraction(qac) == 1 && CLI.multiplayerInteraction(qac) == 2){
            p1Answers.add(1);
            p2Answers.add(1);
        }
        else if (CLI.multiplayerInteraction(qac) == 1) {
            p1Answers.add(1);
        }
        else if (CLI.multiplayerInteraction(qac) == 2){
            p2Answers.add(1);
        }
        if (p1Answers.get(4) == 1){
            Player1_points += 5000;
            return 1;
        }
        else if (p2Answers.get(4) == 2){
            Player2_points += 5000;
            return 1;
        }
        return 0;
    }
}