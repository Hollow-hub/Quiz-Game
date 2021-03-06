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
//    public int players;

    /**
     * the constructor of the class
     */
    public Game(){
        this.random = new Randomizer();
        this.qac = new ArrayList<>();
    }

    
    /**
     * the method that organizes and runs the game
     */
    public void play() throws IOException {
        Gui1 gui1 = new Gui1();
        gui1.setVisible(true);
        while (!gui1.access){
            System.out.println(gui1.access);
        }
        Gui2 gui2 = new Gui2();
        gui2.setVisible(true);
        while (gui2.players==0 || gui2.n_rounds == 0){
            System.out.println(gui2.players);
            System.out.println(gui2.n_rounds);
        }
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
        roundTypes.put(4, "rightAnswerMultiplayer");
        roundTypes.put(5, "bidMultiplayer");

        System.out.println("How many rounds do you want? (type 1-5)");

        int numberOfRounds = gui2.n_rounds;
        String typeOfRound;
        Round round = new Round();
        Random random = new Random();
        int rounds = qac.size()/6;
        
        // a loop that runs each round 
        int shownRoundNumber = 1;
        for (int i=0; i<numberOfRounds*rounds; i++) {
            if (i % rounds == 0) {
                System.out.println("-----Round " + shownRoundNumber + "-----");
                shownRoundNumber++;
            }
            round.setShownRoundNumber(shownRoundNumber - 1);
            // random value in the HashMap, that contains
            // the different types of Round
            typeOfRound = roundTypes.get(random.nextInt(roundTypes.size()));

            if (gui2.players==1) {
                // this is for type: rightAnswer
                if (typeOfRound.equals("rightAnswer")) {
                    round.rightAnswer(qac.get(0));
                }
                // this is for type: bid
                else {
                    round.bid(qac.get(0));
                }
            }
            else{ // for two player game
                switch (typeOfRound) {
                    case "rightAnswerMultiplayer":
                        round.rightAnswerMultiplayer(qac.get(0));
                        break;
                    case "bidMultiplayer":
                        round.bidMultiplayer(qac.get(0));
                        break;
                    case "StopTheTimer":
                        round.StopTheTimer(qac.get(0));
                        break;
                    case "FastAnswer":
                        round.fastAnswer(qac.get(0));
                        break;
                    default:
                        int p1 = 0;
                        int p2 = 0;
//                     if there are less than five questions left,
//                     thermometer can't be played
                        if (qac.size() < 5) {
                            continue;
                        }

                        for (int j = 0; j < 5; j++) {
                            int result = round.Thermometer(qac.get(0));
                            if (result == 3) {
                                p1++;
                                p2++;
                            }
                            if (result == 1) {
                                p1++;
                            } else if (result == 2) {
                                p2++;
                            }
                            qac.remove(0);
                        }

                        if (p1 == 5) {
                            round.setPlayer1_points(round.getPlayer1_points() + 5000);
                        } else if (p2 == 5) {
                            round.setPlayer2_points(round.getPlayer2_points() + 5000);
                        }
                        break;
                }

            }
            qac.remove(0);// removes shown questions
        }


        file = "scoreboard.txt";
        int player1Score=0, player2Score=0, score=0, i=0;
        String oldPlayer1String = "null", oldPlayer2String = "null", oldScore = "null";
        StringBuilder buffer = new StringBuilder();
        Scanner sc = new Scanner(new File(file));
        String line, next;
        while (sc.hasNextLine()) {
            next = sc.nextLine();
            buffer.append(next).append(System.lineSeparator());
            line = next;
            String[] words = line.split(":");
            if (i == 0) {
                player1Score = Integer.parseInt(words[1]);
                oldPlayer1String = line;
            }
            else if (i == 1) {
                player2Score = Integer.parseInt(words[1]);
                oldPlayer2String = line;
            }
            else if (i == 2) {
                score = Integer.parseInt(words[1]);
                oldScore = line;
            }
            i++;
        }
        String fileContents = buffer.toString();
        sc.close();
        boolean changed = false;
        if (gui2.players == 1) {
            if (score < round.getPoint()) {
                fileContents = fileContents.replaceAll(oldScore,
                        "Score:" + String.valueOf(round.getPoint()));
                changed = true;
            }
        }
        else {
            if (round.getPlayer1_points() > round.getPlayer2_points()) {
                fileContents = fileContents.replaceAll(oldPlayer1String,
                        "Player1:" + String.valueOf(++player1Score));
                changed = true;
            }
            else if (round.getPlayer1_points() < round.getPlayer2_points()) {
                fileContents = fileContents.replaceAll(oldPlayer2String,
                        "Player2:" + String.valueOf(++player2Score));
                changed = true;
            }
        }

        if (changed) {
            FileWriter writer = new FileWriter(file);
            writer.append(fileContents);
            writer.close();
        }

        if (gui2.players == 1) {
            Finish_1 finish_1 = new Finish_1(round.getPoint(),score);
            finish_1.setVisible(true);
            if (round.getPoint() > 0) {
                System.out.println("Congratulations!!!");
            }
            else {
                System.out.println("Better luck next time...");
            }
            System.out.println("Points:" + round.getPoint());
        }
        else {
            Finish_2 finish_2 = new Finish_2(round.getPlayer1_points(),round.getPlayer2_points(),player1Score,player2Score);
            finish_2.setVisible(true);
            if(round.getPlayer1_points() > round.getPlayer2_points()){
                finish_2.Player1.setText("Player 1");
                finish_2.Player2.setText("Player 2");
            }
            else if(round.getPlayer1_points() < round.getPlayer2_points()){
                finish_2.Player1.setText("Player 2");
                finish_2.Player2.setText("Player 1");
            }else {
                finish_2.Won.setText("DRAW");
                finish_2.Lost.setText("DRAW");
            }
            System.out.println("Player 1 points: " + round.getPlayer1_points());
            System.out.println("Player 2 points: " + round.getPlayer2_points());
        }
    }
}