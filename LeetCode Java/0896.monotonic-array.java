class Solution {
    public boolean isMonotonic(int[] nums) {
        // Step 1: Assume it's both until proven otherwise
        boolean isIncreasing = true;
        boolean isDecreasing = true;

        // Step 2: Loop through the array, comparing neighbors
        for (int i = 0; i < nums.length - 1; i++) {
            
            // If the next number is bigger, it can't be decreasing
            if (nums[i] < nums[i + 1]) {
                isDecreasing = false;
            } 
            
            // If the next number is smaller, it can't be increasing
            else if (nums[i] > nums[i + 1]) {
                isIncreasing = false;
            }
            
            // Note: If they are equal, both flags stay as they are!
        }

        // Step 3: If it's still "marked" as either one, it's monotonic
        return isIncreasing || isDecreasing;
    }
}
