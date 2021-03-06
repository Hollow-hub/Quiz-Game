/**
 * This class implements questions, answers and category of each questions
 * @author Katsikas Stefanos
 * @author Gkountelos Dimitrios
 */
public class Qac {
    private final String question;
    private final String category;
    private final String[] answers;
    private final String imagePath;
    /**
     * the constructor of the class
     * @param all is a string array with the 
     * question at the first position. 
     * 1-3 are the possible answers with the
     * correct at all[1], all[5] is the
     * category and all[6] is the image path
     */
    public Qac(String[] all) {
        this.question = all[0];
        this.answers = new String[4];
        this.answers[0] = all[1];
        this.answers[1] = all[2];
        this.answers[2] = all[3];
        this.answers[3] = all[4];
        this.category = all[5];
        this.imagePath = all[6];
    }

    /**
     * getter for the question field
     * @return the question of each Qac object when needed
     */
    public String getQuestion() {
        return this.question;
    }
    /**
     * getter for the category field
     * @return the category of each Qac object when needed
     */
    public String getCategory() {
        return this.category;
    }
    /**
     * getter for the answers array
     * @return the answer of each Qac object when needed
     */
    public String[] getAnswers() {
        return this.answers;
    }

    /**
     * getter for the path of the image
     * @return the image path when needed
     */
    public String getImagePath() {
        return this.imagePath;
    }

}
