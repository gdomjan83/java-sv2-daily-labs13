package day04;

import java.util.HashMap;
import java.util.Map;

public class Vowels {
    public static final String VOWELS = "aeiou";

    public Map<Character, Integer> countVowels(String text) {
        Map<Character, Integer> result = new HashMap<>();

        for (Character c : text.toCharArray()) {
            char character = Character.toLowerCase(c);
            if (VOWELS.indexOf(character) != -1) {
                if (result.containsKey(character)) {
                    result.put(character, result.get(character) + 1);
                } else {
                    result.put(character, 1);
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
