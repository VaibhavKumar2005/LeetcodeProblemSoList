import java.util.*;

class Solution {

    public List<String> letterCombinations(String digits) {

        // Result list to store all combinations
        List<String> result = new ArrayList<>();

        // Edge case: if input is empty, return empty list
        if (digits == null || digits.length() == 0) {
            return result;
        }

        // Mapping of digits to corresponding letters
        // Index represents the digit
        String[] map = {
            "", "", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"
        };

        // Start with an empty combination
        result.add("");

        // Process each digit one by one
        for (char digit : digits.toCharArray()) {

            // Letters corresponding to current digit
            String letters = map[digit - '0'];

            // Temporary list to store new combinations
            List<String> temp = new ArrayList<>();

            // Expand each existing combination
            for (String combination : result) {

                // Append each possible letter of current digit
                for (char letter : letters.toCharArray()) {

                    temp.add(combination + letter);
                }
            }

            // Update result with newly formed combinations
            result = temp;
        }

        // Final list contains all possible letter combinations
        return result;
    }
}
