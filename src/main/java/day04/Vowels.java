package day04;

import java.util.HashMap;
import java.util.Map;

public class Vowels {
    public static final String VOWELS = "AaEeIiOoUu";

    public Map<Character, Integer> countVowels(String text) {
        Map<Character, Integer> result = new HashMap<>();

        for (Character c : text.toCharArray()) {
            if (VOWELS.indexOf(c) != -1) {
                if (result.containsKey(Character.toLowerCase(c))) {
                    result.put(Character.toLowerCase(c), result.get(Character.toLowerCase(c)) + 1);
                } else {
                    result.put(Character.toLowerCase(c), 1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Vowels vowels = new Vowels();

        System.out.println(vowels.countVowels("Ez egy alma, nem dinnye."));
    }
}
