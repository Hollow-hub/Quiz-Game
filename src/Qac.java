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
     */
    public String getQuestion() {
        return this.question;
    }
    /**
     * getter for the category field
     */
    public String getCategory() {
        return this.category;
    }
    /**
     * getter for the answers array
     */
    public String[] getAnswers() {
        return this.answers;
    }
}
