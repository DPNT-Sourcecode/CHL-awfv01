package befaster.solutions.CHL;

import java.util.*;

public class CheckliteSolution {

    private static Map<String, Integer> mapRegular = new HashMap<>();
    private static List<Map<String, String>> listSpecial = new ArrayList<>();
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

        Map<String, String> fiveA = new HashMap<>();
        fiveA.put("AAAAA", "X");
        listSpecial.add(fiveA);
        Map<String, String> threeA = new HashMap<>();
        threeA.put("AAA", "Y");
        listSpecial.add(threeA);
        Map<String, String> doubleB = new HashMap<>();
        doubleB.put("BB", "Z");
        listSpecial.add(doubleB);

        mapBonus.put("EE", "B");
    }

    public Integer checklite(String skus) {
        int result = -1;
        if (validateInput(skus)) {
            result = 0;
            char[] temp = skus.toCharArray();
            Arrays.sort(temp);
            String input = new String(temp);
            for (Map<String, String> special : listSpecial) {
                for (String key : special.keySet()) {
                    input = input.replaceAll(key, special.get(key));
                }
            }
            for (String key: mapBonus.keySet()) {
                while (input.contains(key)) {
                    input = input.replaceFirst(mapBonus.get(key), "");
                }
            }
            temp = input.toCharArray();
            Arrays.sort(temp);
            String finalCount = new String(temp);
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





