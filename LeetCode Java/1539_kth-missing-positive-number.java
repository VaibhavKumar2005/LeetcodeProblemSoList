class Solution {
    public int findKthPositive(int[] arr, int k) {

        // Left pointer starts at the beginning of the array
        int left = 0;

        // Right pointer starts at the last valid index
        int right = arr.length - 1;

        // Binary search to find the first index
        // where missing numbers >= k
        while (left <= right) {

            // Calculate mid safely to avoid overflow
            int mid = left + (right - left) / 2;

            /*
             * Number of missing positive integers before arr[mid]
             * If the array had no missing numbers,
             * the value at index mid should be (mid + 1)
             */
            int missing = arr[mid] - (mid + 1);

            // If missing numbers are less than k,
            // move to the right half
            if (missing < k) {
                left = mid + 1;
            }
            // Otherwise, move to the left half
            else {
                right = mid - 1;
            }
        }

        /*
         * After the loop:
         * left represents the count of numbers in the array
         * before the kth missing number.
         * So the kth missing number is:
         */
        return left + k;
    }
}
