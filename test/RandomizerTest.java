import org.junit.Assert;
import org.junit.Test;

public class RandomizerTest {
    public RandomizerTest() {}

    @Test
    public void randomizeTest() {
        Randomizer obj = new Randomizer();
        Assert.assertNotNull(obj.randomize(0, 3));
        Assert.assertNull(obj.randomize(0, -5));
        Assert.assertNotNull(obj.randomize(0, 0));
    }
}
