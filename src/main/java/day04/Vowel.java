package day04;

import java.util.HashMap;
import java.util.Map;

public class Vowel {
    private static final String VOWELS = "aeiou";

    public Map<Character, Integer> getVowels(String text){
        Map<Character, Integer> chars=new HashMap<>();
        for(Character ch : text.toCharArray()){
            Character c = Character.toLowerCase(ch);
            if (VOWELS.contains(c.toString())){
                Integer point = chars.computeIfAbsent(c, k -> 0);
                chars.put(c, point + 1);
            }
        }
        return chars;
    }

    public static void main(String[] args) {
        Vowel vowel = new Vowel();
        System.out.println(vowel.getVowels("Twist and shout! Get ready!"));
    }
}