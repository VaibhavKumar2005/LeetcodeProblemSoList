import java.util.List;

class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String result = "";

        for (String word : dictionary) {
            int i = 0; // pointer for string s
            int j = 0; // pointer for the current word
            
            // Walk through both strings
            while (i < s.length() && j < word.length()) {
                // If characters match, move the word pointer
                if (s.charAt(i) == word.charAt(j)) {
                    j++;
                }
                // Always move the source string pointer
                i++;
            }

            // If j reached the end, the word is a valid subsequence
            if (j == word.length()) {
                // Check if this word is better than our current result
                if (word.length() > result.length() || 
                   (word.length() == result.length() && word.compareTo(result) < 0)) {
                    result = word;
                }
            }
        }

        return result;
    }
}
