import java.util.Random;

/**
 * This class randomizes numbers
 * @author Katsikas Stefanos
 * @author Gkountelos Dimitrios
 */
public class Randomizer {
    /**
     * this method randomizes numbers in range(start, end)
     * @param start is the first number of the range
     *              that will get randomized
     * @param end is the last number
     * @return shuffled[] which is the array with the numbers start->end shuffled
     */
    public int[] randomize(int start, int end) {
        int[] shuffled = new int[end+1-start];
        Random random = new Random();
        for (int i=0; i<shuffled.length; i++) {
            shuffled[i] = i+start;
        }

        int temp, selected;
        for (int i=shuffled.length-1; i>0; i--) {
            selected = random.nextInt(i);// random number between 0-i(current index)
            // swap the current array value (i) with a randomly selected one
            temp = shuffled[i];
            shuffled[i] = shuffled[selected];
            shuffled[selected] = temp;
        }
        return shuffled;
    }
}
