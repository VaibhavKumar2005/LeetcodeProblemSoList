/*
LeetCode 1941 — Check if All Characters Have Equal Number of Occurrences

Approach:
- Use a fixed-size array (26) to count frequencies of lowercase letters.
- Record the frequency of the first character that appears.
- Ensure all other appearing characters have the same frequency.
- Characters with zero frequency are ignored.

Time Complexity: O(n), where n is the length of the string
Space Complexity: O(1), constant extra space

Why this works well:
- Avoids HashMap by leveraging fixed alphabet size
- Single pass to count, linear pass to validate
- Early exit on mismatch improves efficiency
*/

class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] freq = new int[26];
        
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }

        int expected = 0;
        for(int count : freq){
            if(count!= 0){
                expected = count;
                break;
            }
        }

        for(int count : freq){
            if(count != 0 && expected != count){
                return false;
            }
        }
        return true;
    }
}
