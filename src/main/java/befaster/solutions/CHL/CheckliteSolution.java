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
        mapRegular.put("F", 10);
        mapRegular.put("G", 20);
        mapRegular.put("H", 10);
        mapRegular.put("I", 35);
        mapRegular.put("J", 60);
        mapRegular.put("K", 80);
        mapRegular.put("L", 90);
        mapRegular.put("M", 15);
        mapRegular.put("N", 40);
        mapRegular.put("O", 10);
        mapRegular.put("P", 50);
        mapRegular.put("Q", 30);
        mapRegular.put("R", 50);
        mapRegular.put("S", 30);
        mapRegular.put("T", 20);
        mapRegular.put("U", 40);
        mapRegular.put("V", 50);
        mapRegular.put("W", 20);
        mapRegular.put("X", 90);
        mapRegular.put("Y", 10);
        mapRegular.put("Z", 50);

        mapRegular.put("a", 200);
        mapRegular.put("b", 130);
        mapRegular.put("c", 45);
        mapRegular.put("d", 45);
        mapRegular.put("e", 80);
        mapRegular.put("f", 150);
        mapRegular.put("g", 200);
        mapRegular.put("h", 80);
        mapRegular.put("i", 90);
        mapRegular.put("j", 130);

        Map<String, String> fiveA = new HashMap<>();
        fiveA.put("AAAAA", "a");
        listSpecial.add(fiveA);
        Map<String, String> threeA = new HashMap<>();
        threeA.put("AAA", "b");
        listSpecial.add(threeA);
        Map<String, String> doubleB = new HashMap<>();
        doubleB.put("BB", "c");
        listSpecial.add(doubleB);
        Map<String, String> tenH = new HashMap<>();
        tenH.put("HHHHHHHHHH", "e");
        listSpecial.add(tenH);
        Map<String, String> fiveH = new HashMap<>();
        fiveH.put("HHHHH", "d");
        listSpecial.add(fiveH);
        Map<String, String> twoK = new HashMap<>();
        twoK.put("KK", "f");
        listSpecial.add(twoK);
        Map<String, String> fiveP = new HashMap<>();
        fiveP.put("PPPPP", "g");
        listSpecial.add(fiveP);
        Map<String, String> threeQ = new HashMap<>();
        threeQ.put("QQQ", "h");
        listSpecial.add(threeQ);
        Map<String, String> treeV = new HashMap<>();
        treeV.put("VVV", "j");
        listSpecial.add(treeV);
        Map<String, String> twoV = new HashMap<>();
        twoV.put("VV", "i");
        listSpecial.add(twoV);

        mapBonus.put("EE", "B");
        mapBonus.put("FF", "F");
        mapBonus.put("NNN", "M");
        mapBonus.put("RRR", "Q");
        mapBonus.put("UUU", "U");
    }

    public Integer checklite(String skus) {
        int result = -1;
        if (validateInput(skus)) {
            result = 0;
            char[] temp = skus.toCharArray();
            Arrays.sort(temp);
            String input = new String(temp);
            for (String key: mapBonus.keySet()) {
                String temporary = new String(input);
                while (temporary.contains(key)) {
                    if (temporary.replaceFirst(key, "").contains(mapBonus.get(key))) {
                        temporary = temporary.replaceFirst(key, "");
                        temporary = temporary.replaceFirst(mapBonus.get(key), "");
                        input = input.replaceFirst(mapBonus.get(key), "");
                    } else {
                        break;
                    }
                }
            }
            for (Map<String, String> special : listSpecial) {
                for (String key : special.keySet()) {
                    input = input.replaceAll(key, special.get(key));
                }
            }
            for (Character c : input.toCharArray()) {
                result += mapRegular.get(c.toString());
            }

        }
        System.out.println(String.format("[%s] -> %s", skus, result));
        return result;
    }

    private boolean validateInput(String skus) {
        for (char c : skus.toCharArray()) {
            if (c )
        }
        return true;
        String input = new String(skus).trim();
        for (String key : mapRegular.keySet()) {
            input = input.replaceAll(key, "");
        }
        return input.length() == 0;
    }
}


