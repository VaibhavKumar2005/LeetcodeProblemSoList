class Solution {
    public int equalSubstring(String s, String t, int maxCost) {

        // Left pointer of the sliding window
        int left = 0;

        // Stores the total cost of the current window
        int currentCost = 0;

        // Stores the maximum valid window length found
        int maxLen = 0;

        // Right pointer expands the window one character at a time
        for (int right = 0; right < s.length(); right++) {

            // Add the cost of converting s[right] to t[right]
            currentCost += Math.abs(s.charAt(right) - t.charAt(right));

            // If the cost exceeds the budget, shrink the window from the left
            while (currentCost > maxCost) {
                currentCost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }

            // Update the maximum length of a valid window
            maxLen = Math.max(maxLen, right - left + 1);
        }

        // Return the maximum length found
        return maxLen;
    }
}
