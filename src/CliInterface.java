import java.util.Scanner;
import java.util.HashMap;

/**
 * This class handles the command line interface
 * with the user
 * @author Katsikas Stefanos
 * @author Gkountelos Dimitrios
 * @version 1.1.0
 */
public class CliInterface {

    private int k;
    public CliInterface () {
        this.k = 1;
    }
    
    /**
     * this method prints the questions
     * we may need to change it to show it on the gui...
     */
    public int showQuestions(Qac qac) {
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
        return correctAnswersPlace;
    }

    public int timerInteraction(int correctAnswer) {
        HashMap<Character, Integer> player2 = new HashMap<>();
        player2.put('h', 1);
        player2.put('j', 2);
        player2.put('k', 3);
        player2.put('l', 4);
        Scanner scanner = new Scanner(System.in);
        char input = scanner.next().charAt(0);
        if (isNotValid(input)) {
            System.out.println("Wrong input... Aborting:( :( :(");
            return 0;
        }

        boolean player1 = isPlayer1(input);
        int playersAnswer;
        if (player1) {
            playersAnswer =  Character.getNumericValue(input);
        }
        else {
            playersAnswer = player2.get(input);
        }

        // player chose between 1-4 and we handle 0-3
        if ((playersAnswer - 1) == correctAnswer) {
            if (player1) {
                return 1;
            }
            else {
                return 2;
            }
        }
        // I have to change this. if a player gets it wrong, the other should answer
        return 0;
    }
    /**
     * this method handles the interaction (questions and answers)
     * with the user
     * @param qac is an object from the class: Qac,
     *          which has question, answers[4] and category
     * @param typeofRound
     * @return true if user won or false if he lost
     */
    public boolean interaction(Qac qac, String typeofRound, int shownRoundNumber) {
        Gui4_1 gui4_1 = new Gui4_1(qac,typeofRound,shownRoundNumber);
        gui4_1.setVisible(true);
        while (gui4_1.buttonPressed == false){
            System.out.println("MHTSO eisai malakas");
        }
        if (Character.getNumericValue(gui4_1.answer) == gui4_1.correctAnswersPlace + 1){
            return true;
        }
        return false;

//        int correctAnswersPlace = showQuestions(qac);

        // get users answer
//        Scanner scanner = new Scanner(System.in);
//        int playersAnswer = scanner.nextInt();
//        byte counter = 1;
//        // check if playersAnswers is valid
//        while (playersAnswer!=1 && playersAnswer!=2 &&
//                playersAnswer!=3 && playersAnswer!=4) {
//            if (counter == 1) {
//                System.out.println("Wrong Input...please man its 1,2,3,4 how hard can it be??");
//            }
//            else {
//                System.out.println("I SAID 1,2,3 or freaking 4, WTF is wrong with you");
//            }
//            playersAnswer = scanner.nextInt();
//            counter += 1;
//        }
//
//        // player chose between 1-4 and we handle 0-3
//        if ((playersAnswer - 1) == correctAnswersPlace) {
//            System.out.println("You Win");
//            return true;
//        }
//        else {
//            System.out.println("You idiot, the correct answer is: " +
//                                (correctAnswersPlace+1));
//            return false;
//        }
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
    public int fastAnswerInteraction(Qac qac) {
        int correctAnswersPlace = showQuestions(qac);
        HashMap<Character, Integer> player2 = new HashMap<>();
        player2.put('h', 1);
        player2.put('j', 2);
        player2.put('k', 3);
        player2.put('l', 4);
        
        // get the input and check if it's valid
        Scanner scanner = new Scanner(System.in);
        char input = scanner.next().charAt(0);
        if (isNotValid(input)) {
            System.out.println("Wrong input... Aborting:( :( :(");
            return 0;
        }

        boolean player1 = isPlayer1(input);
        int playersAnswer;
        if (player1) {
            playersAnswer =  Character.getNumericValue(input);
        }
        else {
            playersAnswer = player2.get(input);
        }
        
        // player chose between 1-4 and we handle 0-3
        if ((playersAnswer - 1) == correctAnswersPlace) {
            System.out.println("You Win");
            if (player1) {
                return 1;
            }
            else {
                return 2;
            }
        }
        else {
            System.out.println("Wrong, the other player should answer");
            input = scanner.next().charAt(0);
            if (isNotValid(input))
                return 0;
                
            if (isPlayer1(input)) {
                playersAnswer =  Character.getNumericValue(input);
            }
            else {
                playersAnswer = player2.get(input);
            }

            if (playersAnswer - 1 == correctAnswersPlace) {
                return player1 ? 10 : 20;
            }
        }
        
        System.out.println("You idiot, the correct answer is: " +
                            (correctAnswersPlace+1));
        // I have to change this. if a player gets it wrong, the other should answer
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
    public int multiplayerInteraction(Qac qac) {
        int correctAnswersPlace = showQuestions(qac);
        HashMap<Character, Integer> player2 = new HashMap<>();
        player2.put('h', 1);
        player2.put('j', 2);
        player2.put('k', 3);
        player2.put('l', 4);

        //gets the two inputs and checks if they are valid
        Scanner scanner = new Scanner(System.in);
        char firstInput = scanner.next().charAt(0);
        char secondInput = scanner.next().charAt(0);
        if (isNotValid(firstInput) || isNotValid(secondInput)) {
            System.out.println("Wrong input... Aborting:( :( :(");
            return 0;
        }

        // match inputs with players
        int player1Answer, player2Answer;
        if (isPlayer1(firstInput)) {
            player1Answer = Character.getNumericValue(firstInput);
            player2Answer = player2.get(secondInput);
        }
        else {
            player1Answer = player2.get(firstInput);
            player2Answer = Character.getNumericValue(secondInput);
        }

        // check who got it right
        if (player1Answer - 1 == correctAnswersPlace && 
            player2Answer - 1 == correctAnswersPlace) {
            System.out.println("You both got it right!");
            return 3;
        }
        else if (player1Answer - 1 == correctAnswersPlace) {
            System.out.println("Only player 1 got it right :(");
            return 1;
        }   
        else if (player2Answer - 1 == correctAnswersPlace) {
            System.out.println("Only player 2 got it right :(");
            return 2;
        }

        System.out.println("You both idiots, the correct answer is: " + 
                                (correctAnswersPlace+1));
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