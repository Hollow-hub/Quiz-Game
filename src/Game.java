import java.util.*;
import java.io.*;

/**
 * @author Katsikas Stefanos
 * @author Gkountelos Dimitrios
 * this class implements the 
 * logic of the game and the 
 * main operation of it
 * @version 0.1.2
 */
public class Game{

    ArrayList<Qac> qac;
    public Randomizer random;
    public Players number_of_players;


    /**
     * the constructor of the class
     */
    public Game(){
        this.random = new Randomizer();
        this.qac = new ArrayList<>(20);
        this.number_of_players = new Players();
    }

    
    /**
     * the method that organizes and runs the game
     */
    public void play(){
        String file = "questions.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(",");
                qac.add(new Qac(words));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        //this function shuffles the Arraylist
        Collections.shuffle(qac);
        
        // insert types of rounds into a HashMap
        HashMap<Integer, String> roundTypes = new HashMap<>();
        roundTypes.put(0, "rightAnswer");
        roundTypes.put(1, "bid");
        roundTypes.put(2, "StopTheTimer");
        roundTypes.put(3, "FastAnswer");


        //gets how many players are gonna play
        byte players = number_of_players.getPlayers();

        System.out.println("How many rounds do you want? (type 1-5)");
        Scanner scanner = new Scanner(System.in);
        // player chooses the number of rounds
        byte numberOfRounds = scanner.nextByte();
        while (numberOfRounds < 1 || numberOfRounds > 5) {
            System.out.println("Wrong number... Type a number between 1 and 5");
            numberOfRounds = scanner.nextByte();
        }

        String typeOfRound;
        Round round = new Round();
        Random random = new Random();
        
        // a loop that runs each round 
        int shownRoundNumber = 1;
        for (int i=0; i<numberOfRounds*4; i++) {
            if (i % 4 == 0) {
                System.out.println("-----Round " + shownRoundNumber + "-----");
                shownRoundNumber++;
            }
            // random value in the HashMap, that contains
            // the different types of Round
            typeOfRound = roundTypes.get(random.nextInt(roundTypes.size()));

            if (players==1) {
                // this is for type: rightAnswer
                if (typeOfRound.equals("rightAnswer")) {
                    round.rightAnswer(qac.get(0));
                }
                // this is for type: bid
                else {
                    round.bid(qac.get(0));
                }
            }
            else{
                //this is for type: StopTheTimer
                if (typeOfRound.equals("StopTheTimer")){
                    round.StopTheTimer(qac.get(0));
                }
                //this is for type: FastAnswer
                else
                    if (typeOfRound.equals("FastAnswer")){
                        round.fastAnswer(qac.get(0));
                    }
                    //this is for type: Thermometer
                    else{
                        for (int j=0; j < 10; j++){
                            if (round.Thermometer(qac.get(0)) == 1) {
                                qac.remove(0);
                                break;
                            }
//                            qac.remove(0);
                        }
                    }
            }
            qac.remove(0);// removes shown questions
        }
        scanner.close();
        if(round.getPoint()>0)
            System.out.println("Congratulations!!!");
        else
            System.out.println("Better luck next time...");
        System.out.println("Points:" + round.getPoint());
    }
}