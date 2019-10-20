package befaster.solutions.CHL;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckliteSolution {

    private static Map<String, Integer> mapRegular = new HashMap<>();
    private static Map<String, Integer> mapSpecial = new HashMap<>();

    static {
        mapRegular.put("A", 50);
        mapRegular.put("B", 30);
        mapRegular.put("C", 20);
        mapRegular.put("D", 15);

        mapSpecial.put("AAA", 130);
        mapSpecial.put("BB", 45);
    }

    public Integer checklite(String skus) {
        int result = -1;
        if (validateInput(skus)) {
            result = 0;
            Arrays.sort(skus.toCharArray());
            for (String key : mapSpecial.keySet()) {
                while (skus.contains(key)) {
                    result += mapSpecial.get(key);
                    skus = skus.replace(key, "");
                }
            }
            for (Character c : skus.toCharArray()) {
                result += mapRegular.get(c.toString());
            }

        }
        return result;
    }

    private boolean validateInput(String skus) {
        String input = new String(skus).trim();
        for (String key : mapRegular.keySet()) {
            input = input.replaceAll(key, "");
        }
        return input.length() == 0;
    }
}


