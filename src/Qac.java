/**
 * This class implements questions, answers and category of each questions
 * @author Katsikas Stefanos
 * @author Gkountelos Dimitrios 
 */
public class Qac {
    private String question, category;
    private String[] answers;
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
