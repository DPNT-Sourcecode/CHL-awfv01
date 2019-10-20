package befaster.solutions.CHL;

import org.junit.Assert;
import org.junit.Test;

/*
Some requests have failed (17/40). Here are some of them:
 - {"method":"checklite","params":["AAAAA"],"id":"CHL_R2_017"}, expected: 200, got: 230
 - {"method":"checklite","params":["AAAAAA"],"id":"CHL_R2_018"}, expected: 250, got: 260
 - {"method":"checklite","params":["AAAAAAA"],"id":"CHL_R2_019"}, expected: 300, got: 310
 */
public class CheckliteSolutionTest {

    @Test
    public void testChecklite() {
        CheckliteSolution solution = new CheckliteSolution();
        Assert.assertTrue(solution.checklite("AAAAAAA") == 300);
    }
}

