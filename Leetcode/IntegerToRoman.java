public class IntegertoRoman {
    public String intToRoman(int num) {
        TreeMap<Integer, String> intMap = new TreeMap<>((a, b) -> b - a);
        intMap.put(1, "I");
        intMap.put(4, "IV");
        intMap.put(5, "V");
        intMap.put(9, "IX");
        intMap.put(10, "X");
        intMap.put(40, "XL");
        intMap.put(50, "L");
        intMap.put(90, "XC");
        intMap.put(100, "C");
        intMap.put(400, "CD");
        intMap.put(500, "D");
        intMap.put(900, "CM");
        intMap.put(1000, "M");

        String result = "";
        for (Map.Entry<Integer, String> entry : intMap.entrySet()) {
            while (num >= entry.getKey()) {
                result += entry.getValue();
                num -= entry.getKey();
            }
        }
        ;

        return result;
    }
}
