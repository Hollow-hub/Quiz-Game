/**
 * This class implements questions, answers and category of each questions
 * @author Katsikas Stefanos
 * @author Gkountelos Dimitrios
 */
public class Qac {
    private final String question;
    private final String category;
    private final String[] answers;
    /**
     * the constructor of the class
     * @param question is an object from the class Qac
     * @param answers is an object from the class Qac
     * @param category is an object from the class Qac
     * all of them determine one object in the Arraylist qac
     *
     */
    public Qac(String question, String[] answers, String category) {
        this.question = question;
        this.category = category;
        this.answers = new String[4];
        this.answers[0] = answers[0];
        this.answers[1] = answers[1];
        this.answers[2] = answers[2];
        this.answers[3] = answers[3];
    }
    /**
     * overloading of the constructor above
     * @param question is an object from the class Qac
     * @param answer1 is an object from the class Qac
     * @param answer2 is an object from the class Qac
     * @param answer3 is an object from the class Qac
     * @param answer4 is an object from the class Qac
     * @param category is an object from the class Qac
     * The same as the above because we overloading
     * the constructor
     */
    public Qac(String question, String answer1,
                String answer2, String answer3,
                String answer4, String category) {
        this.question = question;
        this.category = category;
        this.answers = new String[4];
        this.answers[0] = answer1;
        this.answers[1] = answer2;
        this.answers[2] = answer3;
        this.answers[3] = answer4;
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
}
