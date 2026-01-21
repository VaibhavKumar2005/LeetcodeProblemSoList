class Solution {
    /**
     * Check if all binary representations of integers from 1 to n exist as substrings in s
     * 
     * @param s The input string containing binary digits
     * @param n The upper bound of the range [1, n] to check
     * @return true if all binary representations exist as substrings, false otherwise
     */
    public boolean queryString(String s, int n) {
        // Optimization: If n is too large, the string cannot contain all binary representations
        // For n > 1000, the required string length would exceed practical limits
        if (n > 1000) {
            return false;
        }
      
        // Check only numbers from (n/2 + 1) to n
        // Key insight: If binary representations of larger numbers exist,
        // smaller numbers are likely covered as substrings of larger ones
        for (int currentNumber = n; currentNumber > n / 2; currentNumber--) {
            // Convert current number to binary string representation
            String binaryRepresentation = Integer.toBinaryString(currentNumber);
          
            // Check if the binary representation exists as a substring
            if (!s.contains(binaryRepresentation)) {
                return false;
            }
        }
      
        // All checked numbers have their binary representations in the string
        return true;
    }
}
