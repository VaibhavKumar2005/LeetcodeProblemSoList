class Solution {

    /*
     * Problem: Valid Anagram
     *
     * Two strings are anagrams if they contain the same characters
     * with the same frequency.
     *
     * Since the problem states that both strings contain only
     * lowercase English letters ('a' to 'z'), we can use
     * a fixed-size array of 26 integers to count frequencies.
     *
     * Approach:
     * 1. If lengths differ, they cannot be anagrams.
     * 2. Count each character in string 's'.
     * 3. Subtract counts using characters from string 't'.
     * 4. If all counts are zero at the end, they are anagrams.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)  // fixed 26-size array
     */

    public boolean isAnagram(String s, String t) {

        // If lengths differ, cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        // Count frequency of characters in s
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Subtract frequency using characters from t
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }

        // If any count is not zero, not an anagram
        for (int num : count) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }
}
