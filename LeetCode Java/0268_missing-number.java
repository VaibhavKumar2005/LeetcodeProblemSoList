class Solution {

    // Function to find the missing number in the range [0, n]
    public int missingNumber(int[] nums) {

        // Length of the array (numbers are from 0 to n)
        int n = nums.length;

        // This variable will store XOR of all numbers
        int xor = 0;

        // XOR all numbers from 0 to n
        // This includes every number that SHOULD be present
        for (int i = 0; i <= n; i++) {
            xor = xor ^ i;
        }

        // XOR all numbers present in the array
        // Numbers that appear in both loops will cancel out
        for (int num : nums) {
            xor = xor ^ num;
        }

        // The remaining value is the missing number
        return xor;
    }
}
