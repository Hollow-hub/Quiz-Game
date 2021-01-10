import java.util.HashMap;

/**
 * This class handles the command line interface
 * with the user
 * @author Katsikas Stefanos
 * @author Gkountelos Dimitrios
 * @version 1.1.0
 */
public class Interface {

    public int bidding1;
    public int bidding2;

    private int k;
    public Interface() {
        bidding1 = 0;
        bidding2 = 0;
        this.k = 1;
    }
    
    /**
     * this method prints the questions
     * we may need to change it to show it on the gui...
     */
    public String showQuestions(Qac qac) {
        int correctAnswersPlace = 0;
        System.out.println(k++ + "." + qac.getQuestion());
        Randomizer randomizer = new Randomizer();
        int[] questionNumbers = randomizer.randomize(0, 3);
        // this holds the randomized number of the correct answer
        // find in which place will the correct answer shown
        for (int i=0; i<4; i++) {
            if (questionNumbers[i] == 0) {
                correctAnswersPlace = i;
            }
        }

        // print all the answers
        System.out.println("1." + qac.getAnswers()[questionNumbers[0]] + "   " +
                "2." + qac.getAnswers()[questionNumbers[1]]);
        System.out.println("3." + qac.getAnswers()[questionNumbers[2]] + "   " +
                "4." + qac.getAnswers()[questionNumbers[3]]);
        System.out.printf("Select between: 1, 2, 3, 4 %nAnswer:");
        return qac.getAnswers()[questionNumbers[correctAnswersPlace]];
    }

    public int[] timerInteraction(Qac qac, String typeofRound, int shownRoundNumber) {
        HashMap<Character, Integer> player2 = new HashMap<>();
        player2.put('h', 1);
        player2.put('j', 2);
        player2.put('k', 3);
        player2.put('l', 4);

        PassedTime timer1 = new PassedTime();
        PassedTime timer2 = new PassedTime();
        int[] results = new int[2];

        timer1.start1();
        timer2.start2();
        PassedTime timerGeneral = new PassedTime();
        timerGeneral.start1();

        Gui_Image gui_image = new Gui_Image(qac.getImagePath());
        if (!qac.getImagePath().equals("none")) {
            gui_image.setVisible(true);
        }
        Gui_timer gui_timer = new Gui_timer(qac,typeofRound,shownRoundNumber);
        gui_timer.setVisible(true);
        while (!gui_timer.buttonPressed1 || !gui_timer.buttonPressed2){
            System.out.println("RAM");
            gui_timer.Timer.setText(String.valueOf(timerGeneral.startingSeconds1));

            if (gui_timer.buttonPressed1) {
                timer1.stop1();
                gui_timer.hbutton.requestFocus();
            }
            else {
                gui_timer.Button1.requestFocus();
            }
            if (gui_timer.buttonPressed2)
                timer2.stop2();
        }
        timerGeneral.stop1();
        gui_timer.correctAnswer.setText(String.valueOf(gui_timer.correctAnswersPlace + 1));
        int player1Answer, player2Answer;
        if(isPlayer1(gui_timer.answer1)){
            player1Answer = (Integer.parseInt(String.valueOf(gui_timer.answer1)));
            player2Answer = player2.get(gui_timer.answer2);
        }else{
            player1Answer = player2.get(gui_timer.answer1);
            player2Answer = (Integer.parseInt(String.valueOf(gui_timer.answer2)));
        }

        results[0] = timer1.getSeconds1();
        results[1] = timer2.getSeconds2();

        if (player1Answer - 1 == gui_timer.correctAnswersPlace &&
                player2Answer - 1 == gui_timer.correctAnswersPlace) {
            System.out.println("You both got it right!");
            while (!gui_timer.nextButtonPressed){
                System.out.println("nothing");
            }
            gui_image.dispose();
            gui_timer.dispose();
            results[1] = 0;
        }
        else if (player1Answer - 1 == gui_timer.correctAnswersPlace) {
            System.out.println("Only player 1 got it right :(");
            while (!gui_timer.nextButtonPressed){
                System.out.println("nothing");
            }
            gui_image.dispose();
            gui_timer.dispose();
            results[1] = 0;

        }
        else if (player2Answer - 1 == gui_timer.correctAnswersPlace) {
            System.out.println("Only player 2 got it right :(");
            while (!gui_timer.nextButtonPressed){
                System.out.println("nothing");
            }
            gui_image.dispose();
            gui_timer.dispose();
            results[0] = 0;

        }
        else {
            System.out.println("You both idiots, the correct answer is: " +
                    (gui_timer.correctAnswersPlace + 1));
            while (!gui_timer.nextButtonPressed){
                System.out.println("nothing");
            }
            gui_image.dispose();
            gui_timer.dispose();
            results[0] = 0;
            results[1] = 0;
        }
        return results;
    }
    /**
     * this method handles the interaction (questions and answers)
     * with the user
     * @param qac is an object from the class: Qac,
     *          which has question, answers[4] and category
     * @param typeofRound is the type of the current round
     * @return true if user won or false if he lost
     */
    public boolean interaction(Qac qac, String typeofRound, int shownRoundNumber) {
        if (typeofRound.equals("Bid")) {
            Gui_Bidding gui_bidding = new Gui_Bidding(qac.getCategory());
            gui_bidding.Player.setText("Player 1");
            gui_bidding.setVisible(true);
            while(gui_bidding.bidding == 0) {
                System.out.println("Bidding");
            }
            bidding1 = gui_bidding.bidding;

            Gui4_1 gui4_1 = new Gui4_1(qac, typeofRound, shownRoundNumber);
            gui4_1.setVisible(true);
            Gui_Image gui_image = new Gui_Image(qac.getImagePath());
            if (!qac.getImagePath().equals("none")) {
                gui_image.setVisible(true);
            }
            while (!gui4_1.buttonPressed) {
                System.out.println("Bid");
            }

            if (Character.getNumericValue(gui4_1.answer) == gui4_1.correctAnswersPlace + 1) {
                while (!gui4_1.nextButtonPressed) {
                    System.out.println("nothing");
                }
                gui_image.dispose();
                gui4_1.dispose();
                return true;
            }
            while (!gui4_1.nextButtonPressed) {
                System.out.println("nothing");
            }
            gui_image.dispose();
            gui4_1.dispose();
        }
        else {
            Gui4_1 gui4_1 = new Gui4_1(qac, typeofRound, shownRoundNumber);
            gui4_1.setVisible(true);
            Gui_Image gui_image = new Gui_Image(qac.getImagePath());
            if (!qac.getImagePath().equals("none")) {
                gui_image.setVisible(true);
            }
            while (!gui4_1.buttonPressed) {
                System.out.println("RightAnswer");
            }
            if (Character.getNumericValue(gui4_1.answer) == gui4_1.correctAnswersPlace + 1) {
                while (!gui4_1.nextButtonPressed) {
                    System.out.println("nothing");
                }
                gui_image.dispose();
                gui4_1.dispose();
                return true;
            }
            while (!gui4_1.nextButtonPressed) {
                System.out.println("nothing");
            }
            gui_image.dispose();
            gui4_1.dispose();
        }
        return false;
    }

    /**
     * that can't work, because in command line
     * we can't have events and the user should press enter
     * at each question. We can fix this later in the qui.
     * I still want to make it just to have a plan #sad
     * firstly, it gets the players answer. Player one 
     * has 1, 2, 3, 4 as possible answers and player two 
     * has h, j, k, l, that means: h == 1, j == 2, k == 3, l == 4
     * @param qac is an object from class Qac
     * @return 0 if nobody won, 1 if player 1 won and 2 if player 2 won 
     */
    public int fastAnswerInteraction(Qac qac,String typeofRound,int shownRoundNumber) {
        HashMap<Character, Integer> player2 = new HashMap<>();
        player2.put('h', 1);
        player2.put('j', 2);
        player2.put('k', 3);
        player2.put('l', 4);

        Gui4_2 gui4_2 = new Gui4_2(qac,typeofRound,shownRoundNumber);
        gui4_2.setVisible(true);
        Gui_Image gui_image = new Gui_Image(qac.getImagePath());
        if (!qac.getImagePath().equals("none")) {
            gui_image.setVisible(true);
        }
        while (!gui4_2.buttonPressed1 || !gui4_2.buttonPressed2){
            System.out.println("RAM");
            if (gui4_2.buttonPressed1) {
                gui4_2.hbutton.requestFocus();
            }
            else{
                gui4_2.Button1.requestFocus();
            }
        }
        gui4_2.correctAnswer.setText(String.valueOf(gui4_2.correctAnswersPlace + 1));

        int player1Answer = 0, player2Answer = 0;

        boolean flag = false;
        if(isPlayer1(gui4_2.answer1)){
            flag = true;
            player1Answer = (Integer.parseInt(String.valueOf(gui4_2.answer1)));
            player2Answer = player2.get(gui4_2.answer2);
        }else{
            player1Answer = player2.get(gui4_2.answer1);
            player2Answer = (Integer.parseInt(String.valueOf(gui4_2.answer2)));
        }

        if (player1Answer - 1 == gui4_2.correctAnswersPlace && player2Answer - 1 == gui4_2.correctAnswersPlace) {
            while (!gui4_2.nextButtonPressed) {
                System.out.println("nothing");
            }
            gui_image.dispose();
            gui4_2.dispose();
            if (flag) {
                return 3; // both right, 1 first
            }
            else {
                return 4; // both right, 2 first
            }
        } else if (player1Answer - 1 == gui4_2.correctAnswersPlace) {
            while (!gui4_2.nextButtonPressed){
                System.out.println("nothing");
            }
            gui_image.dispose();
            gui4_2.dispose();
            return 1; // only 1 right
        }
        else if (player2Answer - 1 == gui4_2.correctAnswersPlace) {
            System.out.println("Only player 2 got it right :(");
            while (!gui4_2.nextButtonPressed){
                System.out.println("nothing");
            }
            gui_image.dispose();
            gui4_2.dispose();
            return 2; // only 2 right
        }
        while (!gui4_2.nextButtonPressed){
            System.out.println("nothing");
        }
        gui_image.dispose();
        gui4_2.dispose();
        return 0;
    }

    /**
     * this method handles the interaction when we need to get 
     * an answer from each player
     * @param qac is an object from class Qac (question, answers[], category)
     * @return 0 if nobody got it correct or
     * invalid input. 1 if only player 1 got it right. 2 if only player 2 got
     * it right and 3 if both players got it right
     */
    public int multiplayerInteraction(Qac qac, String typeofRound, int shownRoundNumber) {
//        int correctAnswersPlace = showQuestions(qac);
        HashMap<Character, Integer> player2 = new HashMap<>();
        player2.put('h', 1);
        player2.put('j', 2);
        player2.put('k', 3);
        player2.put('l', 4);

        if (typeofRound.equals("BidMultiplayer")) {
            Gui_Bidding gui_bidding = new Gui_Bidding(qac.getCategory());
            gui_bidding.Player.setText("Player 1");
            gui_bidding.setVisible(true);
            while (gui_bidding.bidding == 0) {
                System.out.println("Bidding");
            }
            bidding1 = gui_bidding.bidding;

            Gui_Bidding gui_bidding2 = new Gui_Bidding(qac.getCategory());
            gui_bidding2.Player.setText("Player 2");
            gui_bidding2.setVisible(true);
            while (gui_bidding2.bidding == 0) {
                System.out.println("Bidding");
            }
            bidding2 = gui_bidding2.bidding;
        }
        Gui4_2 gui4_2 = new Gui4_2(qac, typeofRound, shownRoundNumber);
        gui4_2.setVisible(true);
        Gui_Image gui_image = new Gui_Image(qac.getImagePath());
        if (!qac.getImagePath().equals("none")) {
            gui_image.setVisible(true);
        }
        while (!gui4_2.buttonPressed1 || !gui4_2.buttonPressed2) {
            System.out.println("RAM");
            if (gui4_2.buttonPressed1) {
                gui4_2.hbutton.requestFocus();
            } else {
                gui4_2.Button1.requestFocus();
            }
        }
        gui4_2.correctAnswer.setText(String.valueOf(gui4_2.correctAnswersPlace + 1));
        int player1Answer, player2Answer;
        if (isPlayer1(gui4_2.answer1)) {
            player1Answer = (Integer.parseInt(String.valueOf(gui4_2.answer1)));
            player2Answer = player2.get(gui4_2.answer2);
        } else {
            player1Answer = player2.get(gui4_2.answer1);
            player2Answer = (Integer.parseInt(String.valueOf(gui4_2.answer2)));
        }
        if (player1Answer - 1 == gui4_2.correctAnswersPlace &&
                player2Answer - 1 == gui4_2.correctAnswersPlace) {
            System.out.println("You both got it right!");
            while (!gui4_2.nextButtonPressed) {
                System.out.println("nothing");
            }
            gui_image.dispose();
            gui4_2.dispose();
            return 3;
        } else if (player1Answer - 1 == gui4_2.correctAnswersPlace) {
            System.out.println("Only player 1 got it right :(");
            while (!gui4_2.nextButtonPressed) {
                System.out.println("nothing");
            }
            gui_image.dispose();
            gui4_2.dispose();
            return 1;
        } else if (player2Answer - 1 == gui4_2.correctAnswersPlace) {
            while (!gui4_2.nextButtonPressed) {
                System.out.println("nothing");
            }
            gui_image.dispose();
            gui4_2.dispose();
            return 2;
        }

        System.out.println("You both idiots, the correct answer is: " +
                (gui4_2.correctAnswersPlace + 1));
        while (!gui4_2.nextButtonPressed) {
            System.out.println("nothing");
        }
        gui_image.dispose();
        gui4_2.dispose();
        return 0;
    }

    /**
     * this method checks if the input is valid
     */
    public boolean isNotValid(char input) {
        return input != '1' && input != '2' && input != '3' && input != '4' &&
                input != 'h' && input != 'j' && input != 'k' && input != 'l';
    }

    /**
     * this method checks if input is from player one 
     */
    public boolean isPlayer1(char input) {
        return input == '1' || input == '2' || input == '3' || input == '4';
    }
}