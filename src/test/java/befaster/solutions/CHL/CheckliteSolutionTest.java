package befaster.solutions.CHL;

import org.junit.Assert;
import org.junit.Test;

/*
Some requests have failed (17/40). Here are some of them:
 - {"method":"checklite","params":["AAAAA"],"id":"CHL_R2_017"}, expected: 200, got: 230
 - {"method":"checklite","params":["AAAAAA"],"id":"CHL_R2_018"}, expected: 250, got: 260
 - {"method":"checklite","params":["AAAAAAA"],"id":"CHL_R2_019"}, expected: 300, got: 310
 Some requests have failed (9/40). Here are some of them:
 - {"method":"checklite","params":["EE"],"id":"CHL_R2_023"}, expected: 80, got: 110
 - {"method":"checklite","params":["EEB"],"id":"CHL_R2_024"}, expected: 80, got: 140
 - {"method":"checklite","params":["EEEB"],"id":"CHL_R2_025"}, expected: 120, got: 180
 Some requests have failed (4/40). Here are some of them:
 - {"method":"checklite","params":["EEEEBB"],"id":"CHL_R2_026"}, expected: 160, got: 205
 - {"method":"checklite","params":["BEBEEE"],"id":"CHL_R2_027"}, expected: 160, got: 205
 - {"method":"checklite","params":["ABCDEABCDE"],"id":"CHL_R2_038"}, expected: 280, got: 295
 */
public class CheckliteSolutionTest {

    @Test
    public void testChecklite() {
        CheckliteSolution solution = new CheckliteSolution();
        Assert.assertTrue(solution.checklite("F") == 10);
        Assert.assertTrue(solution.checklite("FF") == 20);
        Assert.assertTrue(solution.checklite("FFF") == 20);
        Assert.assertTrue(solution.checklite("FFFF") == 30);
        Assert.assertTrue(solution.checklite("FFFFF") == 40);
        Assert.assertTrue(solution.checklite("FFFFFF") == 40);
        Assert.assertTrue(solution.checklite("EE") == 80);
        Assert.assertTrue(solution.checklite("EEB") == 80);
        Assert.assertTrue(solution.checklite("EEEB") == 120);
        Assert.assertTrue(solution.checklite("EEEEBB") == 160);
        Assert.assertTrue(solution.checklite("BEBEEE") == 160);
        Assert.assertTrue(solution.checklite("ABCDEABCDE") == 280);
    }
}
