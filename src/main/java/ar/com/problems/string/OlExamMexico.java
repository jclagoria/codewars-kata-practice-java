package ar.com.problems.string;

import java.util.HashMap;
import java.util.Map;

public class OlExamMexico {

    public static void main(String[] args) {

        findOcurrecesInStr("Hola Tamara HOla tAmARa HoLA");

    }

    private static void findOcurrecesInStr(final String strOriginal) {

        String temporal = strOriginal.toLowerCase().trim();

        String[] arrayStr = temporal.split("\\s");

        Map<String, Integer> ocurrences = new HashMap<>();

        for (int i = 0; i < arrayStr.length; i++) {

            if(ocurrences.containsKey(arrayStr[i])) {
                int valueOcurrences = ocurrences.get(arrayStr[i]);
                ocurrences.put(arrayStr[i], valueOcurrences + 1);
            } else {
                ocurrences.put(arrayStr[i], 1);
            }

        }

        StringBuilder strValue = new StringBuilder();

        for (String keyStr: ocurrences.keySet()) {
            strValue.append(keyStr).append(": ").append(ocurrences.get(keyStr)).append("\n");
        }
        
        System.out.println(strValue.toString());

    }


}
