class Solution {

    /*
     * Problem: Valid Palindrome
     *
     * A string is considered a palindrome if, after:
     *  - converting all letters to lowercase
     *  - removing all non-alphanumeric characters
     * it reads the same forward and backward.
     *
     * Approach:
     * We use a two-pointer technique:
     *  - One pointer starts from the beginning (left)
     *  - One pointer starts from the end (right)
     *
     * We skip all non-alphanumeric characters and compare
     * the remaining characters in a case-insensitive manner.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        // Traverse the string from both ends
        while (left < right) {

            // Skip non-alphanumeric characters from the left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Skip non-alphanumeric characters from the right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters in a case-insensitive way
            if (Character.toLowerCase(s.charAt(left)) !=
                Character.toLowerCase(s.charAt(right))) {
                return false; // mismatch found
            }

            // Move both pointers inward
            left++;
            right--;
        }

        // All characters matched
        return true;
    }
}
