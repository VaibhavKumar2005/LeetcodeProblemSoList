/*  189. Rotate Array

 Problem
Rotate an integer array `nums` to the right by `k` steps.

Constraints require:
- In-place modification
- O(1) extra space
- Optimal time complexity

Optimal Approach: Reversal Technique

  Idea
Rotation can be achieved using **three in-place reversals**:

1. Reverse the entire array
2. Reverse the first `k` elements
3. Reverse the remaining `n - k` elements

This works because reversing rearranges elements so that the last `k`
elements move to the front in correct order.


Complexity
- **Time:** O(n)
- **Space:** O(1)

Java Implementation (Optimized)
*/ 

class Solution {
    public void rotate(int[] nums, int k) {

        int n = nums.length;

        // Handle cases where k >= n
        k = k % n;

        int start, end, temp;

        // 1) Reverse the entire array
        start = 0;
        end = n - 1;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

        // 2) Reverse the first k elements
        start = 0;
        end = k - 1;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

        // 3) Reverse the remaining n-k elements
        start = k;
        end = n - 1;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}


class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k -1);
        reverse(nums, k, n - 1);

    }
    private void reverse (int[] nums, int start, int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
