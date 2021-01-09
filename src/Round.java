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
    private final Interface CLI;
    private int Player1_points;
    private int Player2_points;
    private int shownRoundNumber;

    public Round() {
        this.points = 0;
        this.CLI = new Interface();
        this.Player1_points = 0;
        this.Player2_points = 0;
    }

    public void setShownRoundNumber(int shownRoundNumber){
        this.shownRoundNumber = shownRoundNumber;
    }

    /**  
     * @return points in the game so far
     */
    public int getPoint() {
        return points;
    }

    public int getPlayer1_points() { return this.Player1_points; }

    public int getPlayer2_points() { return this.Player2_points; }

    /**
     * setter for points of player 1
     * @param points the new value
     */
    public void setPlayer1_points(int points) {
        this.Player1_points = points;
    }

    /**
     * setter for points of player 2
     * @param points the new value
     */
    public void setPlayer2_points(int points) {
        this.Player2_points = points;
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

        if (CLI.interaction(qac,"RightAnswer",shownRoundNumber)) {
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

        if (CLI.interaction(qac, "Bid", shownRoundNumber)) {
            this.points += CLI.bidding1;
        }
        else{
            this.points -= CLI.bidding1;
        }
    }

    public void rightAnswerMultiplayer(Qac qac) {
        int result = CLI.multiplayerInteraction(qac,"RightAnswerMultiplayer",shownRoundNumber);
        if (result == 3) {
            Player2_points += 1000;
            Player1_points += 1000;
        }
        else if (result == 2) {
            Player2_points += 1000;
        }
        else if (result == 1) {
            Player1_points += 1000;
        }
    }

    public void bidMultiplayer(Qac qac) {
        int result = CLI.multiplayerInteraction(qac,"BidMultiplayer",shownRoundNumber);
        if (result == 1) {
            Player1_points += CLI.bidding1;
            Player2_points -= CLI.bidding2;
        }
        else if (result == 3) {
            Player1_points += CLI.bidding1;
            Player2_points += CLI.bidding2;
        }
        else if (result == 2) {
            Player2_points += CLI.bidding2;
            Player1_points -= CLI.bidding1;
        }
        else {
            Player1_points -= CLI.bidding1;
            Player2_points -= CLI.bidding2;
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
        int[] winner = CLI.timerInteraction(qac,"StopTheTimer",shownRoundNumber);
        if (winner[0] == 0 && winner[1] == 0)
            return;
        else if (winner[0] == 0)
            this.Player2_points += (5000 - winner[1])*0.2;
        else if (winner[1] == 0)
            this.Player1_points += (5000 - winner[0])*0.2;
        else {
            this.Player1_points += (5000 - winner[0]) * 0.2;
            this.Player2_points += (5000 - winner[1]) * 0.2;
        }
    }

    /**
     * 
     * @param qac is an object from class Qac
     */
    public void fastAnswer(Qac qac){
        int result = CLI.fastAnswerInteraction(qac,"FastAnswer",shownRoundNumber);
        if (result == 1) {
            this.Player1_points += 1000;
        }
        else if (result == 2) {
            this.Player2_points += 1000;
        }
        else if (result == 10) {
            this.Player1_points += 500;
        }
        else if (result == 20) {
            this.Player2_points += 500;
        }
    }

    /**
     * this method is for "Thermometer" type
     * of round  and it gets an  array: questions[20,5] (String) as input.
     * @param qac is an object from the class Qac,
     *      * which includes question, answers[], category
     * @return 1 if someone of the 2 players found 5 correct
     * answers
     */
    public int Thermometer(Qac qac) {
        return CLI.multiplayerInteraction(qac,"Thermometer",shownRoundNumber);
    }
}