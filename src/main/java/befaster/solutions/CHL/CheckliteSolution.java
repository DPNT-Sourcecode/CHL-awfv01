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
            char[] temp = skus.toCharArray();
            Arrays.sort(temp);
            String input = new String(temp);
            for (String key : mapSpecial.keySet()) {
                while (input.contains(key)) {
                    result += mapSpecial.get(key);
                    input = input.replaceFirst(key, "");
                }
            }
            for (Character c : input.toCharArray()) {
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
