package com.example.algo;

import java.util.HashMap;

/**
 * Given a dictionary of words,
 * find all strings that matches the given pattern where every character
 * in the pattern is uniquely mapped to a character in the dictionary.
 * <p>
 * Input:
 * <p>
 * dict = ["abb", "abc", "xyz", "xyy"];
 * <p>
 * pattern = "foo"
 * <p>
 * Output: [xyy abb]
 * <p>
 * <p>
 * Input:
 * <p>
 * dict = ["abb", "abc", "xyz", "xyy"];
 * <p>
 * pat = "mno"
 * <p>
 * Output: [abc xyz]
 * <p>
 * <p>
 * Input:
 * <p>
 * dict = ["abb", "abc", "xyz", "xyy"];
 * <p>
 * pattern = "aba"
 * <p>
 * Output: []
 * <p>
 * <p>
 * Input:
 * <p>
 * dict = ["abab", "aba", "xyz", "xyx"];
 * <p>
 * pattern = "aba"
 * <p>
 * Output: [aba xyx]
 */
public class FindMatchedWord {
    public static void main(String[] arg) {
        String[] dict = {"abab", "aba", "xyz", "xyx"};
        String pattern = "aba";
        String patternHash = encodeString(pattern);
        System.out.println("Patter Hash: " + patternHash);

        for (String word : dict) {
            if (word.length() == pattern.length()) {
                String wordHash = encodeString(word);
//                System.out.println("Word Hash: " + wordHash);
                if (wordHash.equals(patternHash))
                    System.out.println(word);
            }
        }


    }

    public static String encodeString(String str) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        StringBuilder res = new StringBuilder();
        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!map.containsKey(ch))
                map.put(ch, j++);
            res.append(map.get(ch));
        }
        return res.toString();
    }
}
