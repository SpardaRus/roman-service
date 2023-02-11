package ru.spardarus.roman.service;

import java.util.LinkedHashMap;
import java.util.Map;

public class RepeatingCharactersService {

    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int count = 1;

        if (s == null || s.isEmpty()) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        Map<Character, Integer> tempCharacters = new LinkedHashMap<>();
        tempCharacters.put(s.charAt(0), 0);
        for (int i = 1; i < s.length(); i++) {
            char currentCharacter = s.charAt(i);
            if (tempCharacters.containsKey(currentCharacter)) {
                count = 1;
                i = tempCharacters.get(currentCharacter) + 1;
                tempCharacters = new LinkedHashMap<>();
            } else {
                count++;
            }
            if (result < count) {
                result = count;
            }
            tempCharacters.put(s.charAt(i), i);
        }

        return result;
    }


}
