class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];
        int index = 0;

        for(int x : nums){
            if(x < pivot){
                result[index++] = x;
            }
        }
        for(int x : nums){
            if(x == pivot){
                result[index++] = x;
            }
        }
        for(int x : nums){
            if(x > pivot){
                result[index++] = x;
            }
        }
        return result;
    }
}
