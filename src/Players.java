import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class represents how many players
 * are in the game.
 * @author Katsikas Stefanos
 * @author Gkountelos Dimitrios
 * @version 0.0.1
 */


public class Players {


    ArrayList<Integer> array_single_player;
    ArrayList<String> array_multi_player;
    public Round point_single_player;

    /**
     * the constructor of the class
     */
    public Players(){
        this.array_single_player = new ArrayList<>(40);
        this.array_multi_player = new ArrayList<>(40);
        this.point_single_player = new Round();
    }

    /**
     * asks and returns the number of players
     */
    public Byte getPlayers(){
        System.out.println("How many players are gonna play?");
        Scanner console = new Scanner(System.in);
        byte scanner_players = console.nextByte();
        while (scanner_players != 1 && scanner_players != 2){
            System.out.println("Wrong Input, try again. Hint: (1 or 2)");
            scanner_players = console.nextByte();
        }
        return scanner_players;
    }

    /**
     * method the saves the progress of singleplayer
     */
    public void single_player(){
        //array_single_player.add(point_single_player.getPoint());

    }

    /**
     * method the saves the progress of multiplayer
     */

    public void multi_player(){

    }

}
