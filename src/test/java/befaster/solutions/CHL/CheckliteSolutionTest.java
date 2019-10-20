package befaster.solutions.CHL;

import org.junit.Assert;
import org.junit.Test;

public class CheckliteSolutionTest {

    @Test
    public void testChecklite() {
        CheckliteSolution solution = new CheckliteSolution();
        Assert.assertTrue(solution.checklite("ABCDABCD") == 215);
    }
}
