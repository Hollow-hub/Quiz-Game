import org.junit.Assert;
import org.junit.Test;

public class showQuestionsTest {
    public String[] words1, words2;
    public showQuestionsTest() {
        words1 = new String[]{"Ποια χρονιά κυκλοφόρησε ο Τιτανικός;",
                "1997", "1996", "1998", "2000", "history", "none"};
        words2 = new String[]{"Πόσες ήταν οι μούσες στην αρχαία ελληνική Μυθολογία;",
                "9", "7", "12", "10", "history", "none"};
    }

    @Test
    public void testShowQuestion() {
        Qac qac1 = new Qac(words1);
        Interface cli = new Interface();
        String answer = cli.showQuestions(qac1);
        Assert.assertEquals("1997", answer);
        Qac qac2 = new Qac(words2);
        String answer2 = cli.showQuestions(qac2);
        Assert.assertEquals("9", answer2);
    }
}
