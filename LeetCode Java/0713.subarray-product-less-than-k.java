class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        /*
         * Edge case:
         * Since all numbers in nums are positive (>= 1),
         * the minimum possible product of any subarray is 1.
         * So if k <= 1, no valid subarray exists.
         */
        if (k <= 1) return 0;

        // Left pointer of the sliding window
        int left = 0;

        // Stores the product of elements in the current window
        int product = 1;

        // Counts the number of valid subarrays
        int count = 0;

        // Expand the window using the right pointer
        for (int right = 0; right < nums.length; right++) {

            // Include the current element in the product
            product *= nums[right];

            /*
             * If product becomes >= k,
             * shrink the window from the left until
             * product < k again
             */
            while (product >= k) {
                product /= nums[left];
                left++;
            }

            /*
             * All subarrays ending at index 'right'
             * and starting anywhere from 'left' to 'right'
             * have product < k
             */
            count += (right - left + 1);
        }

        return count;
    }
}
