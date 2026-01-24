/**
 * Problem: 594. Longest Harmonious Subsequence
 * Link: https://leetcode.com/problems/longest-harmonious-subsequence/
 * * Logic: Sliding Window (Two Pointers)
 * 1. Sorting the array allows us to use a sliding window since elements 
 * differing by 1 will be contiguous.
 * 2. We maintain a window [left...right] where the difference between 
 * nums[right] and nums[left] is at most 1.
 * 3. A window is only "harmonious" if the difference is EXACTLY 1.
 */

import java.util.Arrays;

public class LongestHarmoniousSubsequence {

    public int findLHS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        // Step 1: Sort to bring potential harmonious pairs together
        Arrays.sort(nums);
        
        int left = 0;
        int maxLength = 0;
        
        // Step 2: Slide the 'right' pointer across the array
        for (int right = 0; right < nums.length; right++) {
            
            // Step 3: Maintain window property (max - min <= 1)
            // If difference > 1, shrink window from the left
            while (nums[right] - nums[left] > 1) {
                left++;
            }
            
            // Step 4: Check if current window is valid (Difference must be EXACTLY 1)
            if (nums[right] - nums[left] == 1) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }
        
        return maxLength;
    }

    /*
     * DRY RUN EXAMPLE:
     * Input: [1, 3, 2, 2, 5, 2, 3, 7]
     * Sorted: [1, 2, 2, 2, 3, 3, 5, 7]
     * * R=0, L=0: nums[0]-nums[0]=0. max=0
     * R=1, L=0: nums[1]-nums[0]=1. max=2 ([1,2])
     * R=3, L=0: nums[3]-nums[0]=1. max=4 ([1,2,2,2])
     * R=4, L=0: nums[4]-nums[0]=2. (Diff > 1) -> While loop: L++ until nums[L]=2
     * R=4, L=1: nums[4]-nums[1]=1. max=4 ([2,2,2,3])
     * R=5, L=1: nums[5]-nums[1]=1. max=5 ([2,2,2,3,3]) -> Final Answer
     */

    public static void main(String[] args) {
        LongestHarmoniousSubsequence lhs = new LongestHarmoniousSubsequence();
        int[] test1 = {1, 3, 2, 2, 5, 2, 3, 7};
        System.out.println("Max Harmonious Length: " + lhs.findLHS(test1)); // Output: 5
    }
}
