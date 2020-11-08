import java.util.Scanner;


public class Round {
    /* η round δεχεται ως ορισματα τον μονοδιαστατο  και τον αριθμο του μονοδιαστατου
    *  και το ειδος της ερωτησης
    * */
    String x="nothing";
    Scanner console = new Scanner(System.in);
    String answer_player_One;
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
}
