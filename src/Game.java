import java.util.*;

/**
 * @author Katsikas Stefanos
 * @author Gkountelos Dimitrios
 * this class implements the 
 * logic of the game and the 
 * main operation of it
 * @version 0.0.1
 */
public class Game {

    ArrayList<Qac> qac;
    public Randomizer random;
    /**
     * the constructor of the class
     */
    public Game(){
        this.random = new Randomizer();
        this.qac = new ArrayList<>(20);
    }

    
    /**
     * the method that organizes and runs the game
     */
    public void play(){
        qac.add(new Qac("What year was the Titanic released?", "1997", "1996", "1998", "2000", "history"));
        qac.add(new Qac("Which is the largest river in the world in volume of water?", "Amazon", "Mississippi", "Nile", "Volga", "geography"));
        qac.add(new Qac("How many muses were there in ancient Greek Mythology?", "9", "7", "12", "10", "history"));
        qac.add(new Qac("The Strait of Gibraltar separates the Iberian Peninsula from which African country?", "Morocco", "Algeria", "Tunisia", "Western Sahara", "geography"));
        qac.add(new Qac("Which is the largest desert in the world?", "Antarctica", "Sahara", "Gobi", "Arabian", "geography"));
        qac.add(new Qac("Which country is closest to the North Pole?" , "Canada", "Finland", "Russia", "Norway", "geography"));
        qac.add(new Qac("What is Usain Bolt's 100m world record?", "9.58 sec", "9.32 sec", "9.76 sec", "9.22 sec", "sports"));
        qac.add(new Qac("Who was the Prime Minister of Greece in 2005?", "Konstantinos Karamanlis", "George Papandreou", "Costas Simitis", "Alexis Tsipras", "history"));
        qac.add(new Qac("In which of the following cases are antibiotics completely useless?", "Viruses", "Streptococcus", "Tuberculosis", "Infections", "science"));
        qac.add(new Qac("What is the name of the most important prize in the field of information technology?", "Turing", "Torvalds", "Nobel", "Tesla", "science"));
        qac.add(new Qac("What is the area of the Earth?", "About 500 million square kilometers", "About 350 million square kilometers", "About 600 million square kilometers","Approximately 410 million square kilometers", "geography"));
        qac.add(new Qac("Who Wrote the US Declaration of Independence?", "Thomas Jefferson", "Alexander Hamilton", "George Washington", "Abraham Lincoln", "history"));
        qac.add(new Qac("Who is the inventor of the light bulb?" , "Thomas Edison", "Alexander Graham Bell", "Benjamin Franklin", "Nicola Tesla", "history"));
        qac.add(new Qac("Which country has won the most World Cups?" , "Brazil", "Spain", "Italy", "Germany", "sports"));
        qac.add(new Qac("In what sport does the highest paid athlete in the world compete?", "Golf", "Basketball", "Formula 1", "Football", "sports"));
        qac.add(new Qac("How many F1 championships has Lewis Hamilton won?", "6", "2", "4", "7", "sports"));
        qac.add(new Qac("Who is considered the father of computer science?", "Alan Turing", "Linus Torvalds", "Dennis Ritchie", "Steve Jobs", "science"));
        qac.add(new Qac("What was NASA's first mission to the Moon?", "Apollo 11", "Apollo 1", "Apollo 3", "Sputnik", "science"));
        qac.add(new Qac("From which language did the term Computer come?", "Latin", "English", "Greek", "Arabic", "science"));
        qac.add(new Qac("Which sport do the LA Lakers and the New York Knicks play?" , "Basketball", "Hockey", "Rugby", "Baseball", "sports"));


        //this function shuffles the Arraylist
        Collections.shuffle(qac);
        
        // insert types of rounds into a HashMap
        HashMap<Integer, String> roundTypes = new HashMap<Integer, String>();
        roundTypes.put(0, "rightAnswer");
        roundTypes.put(1, "bid");

        System.out.println("How many rounds do you want? (type 1-5)");
        Scanner scanner = new Scanner(System.in);
        // player chooses the number of rounds
        byte numberOfRounds = scanner.nextByte();
        while (numberOfRounds <1 || numberOfRounds > 5) {
            System.out.println("Wrong number... Type a number between 1 and 5");
            numberOfRounds = scanner.nextByte();
        }
        // scanner.close();

        String typeOfRound = new String();
        Round round = new Round();
        Random random = new Random();
        // a loop that runs each round 
        for (int i=0; i<numberOfRounds*4; i++) {
            // random value in the HashMap, that contains
            // the different types of Round
            typeOfRound = roundTypes.get(random.nextInt(roundTypes.size()));
           
            // this is for type: rightAnswer
            if (typeOfRound.equals("rightAnswer")) {
                round.rightAnswer(qac.get(i));
            }
            // this is for type: bid 
            else {
                round.bid(qac.get(i));
            }
            qac.remove(i);// removes shown questions
        }
        scanner.close();
    }
}