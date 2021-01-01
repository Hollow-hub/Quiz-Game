import org.junit.Assert;
import org.junit.Test;

public class qacTest {
    String[] words1, words2;
    public qacTest() {
        words1 = new String[]{"Ποια χρονιά κυκλοφόρησε ο Τιτανικός;", "1997", "1996", "1998", "2000", "history"};
        words2 = new String[]{"Πόσες ήταν οι μούσες στην αρχαία ελληνική Μυθολογία;", "9", "7", "12", "10", "history"};
    }

    @Test
    public void testQuestion() {
        Qac qac = new Qac(words1);
        Assert.assertEquals("Ποια χρονιά κυκλοφόρησε ο Τιτανικός;", qac.getQuestion());
        Qac qac2 = new Qac(words2);
        Assert.assertEquals("Πόσες ήταν οι μούσες στην αρχαία ελληνική Μυθολογία;", qac2.getQuestion());
    }

    @Test
    public void testAnswers() {
        Qac qac1 = new Qac(words1);
        Assert.assertArrayEquals(new String[]{"1997", "1996", "1998", "2000"}, qac1.getAnswers());
        Qac qac2 = new Qac(words2);
        Assert.assertArrayEquals(new String[]{"9", "7", "12", "10"}, qac2.getAnswers());
    }

    @Test
    public void testCategory() {
        Qac qac1 = new Qac(words1);
        Assert.assertEquals("history", qac1.getCategory());
        Qac qac2 = new Qac(words2);
        Assert.assertEquals("history", qac2.getCategory());
    }
}