class Solution {
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int vote = 1;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (vote == 0) {
                majority = nums[i];
                vote++;
            }
            else if (nums[i] == majority) {
                vote++;
            }
            else {
                vote--;
            }
        }
        return majority;
    }
}
