import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.HashMap;

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
    /**
     * the constructor of the class
     */
    public Game(){
        qac = new ArrayList<>(20);
    }
    
    /**
     * the method that organizes and runs the game
     */
    public void play(){
        qac.add(new Qac("Ποια χρονιά κυκλοφόρησε ο Τιτανικός;","1997","1996","1998","2000","history"));
        qac.add(new Qac("Ποιος είναι ο μεγαλύτερος σε όγκο νερού ποταμός στον κόσμο;","Αμαζόνιος","Μισισιπής","Νείλος","Βολγας","geography"));
        qac.add(new Qac("Πόσες ήταν οι μούσες στην αρχαία ελληνική Μυθολογία;","9","7","12","10","history"));
        qac.add(new Qac("Το στενό του Γιβραλτάρ χωρίζει την Ιβηρική χερσόνησο από ποια αφρικανική χώρα;","Μαροκο", "Αλγερια", "Τυνησια", "Δυτικη Σαχαρα","geography"));
        qac.add(new Qac("Ποια είναι η μεγαλύτερη έρημος στον κόσμο;","Ανταρκτικη","Σαχαρα","Γκομπι","Αραβικη", "geography"));
        qac.add(new Qac("Ποια χώρα βρίσκεται πιο κοντά στον Βόρειο Πόλο;" ,"Καναδάς","Φινλανδία" ,"Ρωσία" ,"Νορβηγία","geography"));
        qac.add(new Qac("Ποιος είναι το παγκόσμιο ρεκόρ των 100 μέτρων του Usain Bolt;","9.58 sec", "9.32 sec", "9.76 sec", "9.22 sec" ,"sports"));
        qac.add(new Qac("Ποιος ήταν πρωθυπουργός της Ελλάδας το 2005;", "Κωνσταντίνος Καραμανλής","Γιώργος Παπανδρέου" ,"Κώστας Σημίτης","Αλέξης Τσίπρας" ,"history"));
        qac.add(new Qac("Σε ποια από τις παρακάτω περιπτώσεις τα αντιβιοτικά είναι παντελώς άχρηστα;", "Ιώσεις","Στρεπτόκοκκος" ,"Φυματίωση" ,"Λημώξεις" ,"science"));
        qac.add(new Qac("Πώς ονομάζεται το σημαντικότερο βραβείο στον χώρο της πληροφορικής;", "Turing", "Torvalds", "Nobel", "Tesla" ,"science"));
        qac.add(new Qac("Ποια είναι η έκταση της Γης;", "Περίπου 500 εκ. τετραγωνικά χιλιόμετρα","Περίπου 350 εκ. τετραγωνικά χιλιόμετρα","Περίπου 600 εκ. τετραγωνικά χιλιόμετρα","Περίπου 410 εκ. τετραγωνικά χιλιόμετρα", "geography"));
        qac.add(new Qac("Ποιος έγραψε τη Διακήρυξη Ανεξαρτησίας των ΗΠΑ;", "Τόμας Τζέφερσον","Αλεξάντερ Χάμιλτον","Τζωρτζ Ουάσινγκτον","Αβραάμ Λίνκολν", "history"));
        qac.add(new Qac("Ποιος είναι ο εφευρέτης του ηλεκτρικού λαμπτήρα;" ,"Thomas Edison","Alexander Graham Bell","Benjamin Franklin","Nicola Tesla", "history"));
        qac.add(new Qac("Ποια χώρα έχει κατακτήσει τα περισσότερα παγκόσμια κύπελλα ποδοσφαίρου;" ,"Βραζιλία","Ισπανία","Ιταλία","Γερμανία" ,"sports"));
        qac.add(new Qac("Σε τι άθλημα διαγωνίζεται ο πιο ακριβοπληρωμένος αθλητής στον κόσμο;", "Γκολφ","Μπάσκετ","Formula 1","Ποδόσφαιρο" ,"sports"));
        qac.add(new Qac("Πόσα πρωταθλήματα F1 έχει κερδίσει ο Lewis Hamilton;","6","2","4","7" ,"sports"));
        qac.add(new Qac("Ποιός θεωρείται ο πατέρας της επιστήμης των υπολογιστών;", "Alan Turing", "Linus Torvalds", "Dennis Ritchie", "Steve Jobs", "science"));
        qac.add(new Qac("Ποιά ήταν η πρώτη αποστολή της NASA στη Σελήνη;", "Απόλλο 11", "Απόλλο 1", "Απόλλο 3", "Sputnik" ,"science"));
        qac.add(new Qac("Από ποία γλώσσα προήλθε ο όρος Computer;", "Λατινικά", "Αγγλικά", "Ελληνικά", "Αράβικα" ,"science"));
        qac.add(new Qac("Οι LA Lakers και οι New York Knicks παίζουν ποιο άθλημα;" ,"Μπασκετ", "Χοκεϊ", "Ραγκμπι","Baseball","sports"));
        
        // insert types of rounds into a HashMap
        HashMap<Integer, String> roundTypes = new HashMap<Integer, String>();
        roundTypes.put(0, "rightAnswer");
        roundTypes.put(1, "bid");

        System.out.println("How many rounds do you want? (type 1-20)");
        Scanner scanner = new Scanner(System.in);
        // player choses the number of rounds
        byte numberOfRounds = scanner.nextByte();
        while (numberOfRounds <1 && numberOfRounds > 20) {
            System.out.println("Wrong number... Type a number between 1 and 20");
            numberOfRounds = scanner.nextByte();
        }
        scanner.close();

        String typeOfRound = new String();
        Round round = new Round();
        Random random = new Random();
        // a loop that runs each round 
        for (int i=0; i<numberOfRounds; i++) {
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
    }
}