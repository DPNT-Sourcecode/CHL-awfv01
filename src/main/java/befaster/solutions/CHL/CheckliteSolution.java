package befaster.solutions.CHL;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckliteSolution {

    private static Map<String, Integer> mapRegular = new HashMap<>();
    private static Map<String, String> mapSpecial = new HashMap<>();
    private static Map<String, String> mapBonus = new HashMap<>();

    static {
        mapRegular.put("A", 50);
        mapRegular.put("B", 30);
        mapRegular.put("C", 20);
        mapRegular.put("D", 15);
        mapRegular.put("E", 40);
        mapRegular.put("X", 200);
        mapRegular.put("Y", 130);
        mapRegular.put("Z", 45);

        mapSpecial.put("AAAAA", "X");
        mapSpecial.put("AAA", "Y");
        mapSpecial.put("BB", "Z");

        mapBonus.put("EE", "EEB");
    }

    public Integer checklite(String skus) {
        int result = -1;
        if (validateInput(skus)) {
            result = 0;
            char[] temp = skus.toCharArray();
            Arrays.sort(temp);
            String input = new String(temp);
            for (String key : mapSpecial.keySet()) {
                input = input.replaceAll(key, mapSpecial.get(key));
            }
            for (String key: mapBonus.keySet()) {
                input = input.replaceAll(key, mapBonus.get(key));
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

