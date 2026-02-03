class Solution {
    public int search(int[] nums, int target) {

        // Left pointer at the start of the array
        int left = 0;

        // Right pointer at the end of the array
        int right = nums.length - 1;

        // Continue searching while the search space is valid
        while (left <= right) {

            // Calculate mid safely to avoid integer overflow
            int mid = left + (right - left) / 2;

            // If target is found at mid, return its index
            if (nums[mid] == target) {
                return mid;
            }

            // If target is greater than mid element,
            // discard the left half
            else if (nums[mid] < target) {
                left = mid + 1;
            }

            // If target is smaller than mid element,
            // discard the right half
            else {
                right = mid - 1;
            }
        }

        // Target not found in the array
        return -1;
    }
}
