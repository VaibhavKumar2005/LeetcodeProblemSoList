class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> myset = new HashSet<>();

        for (int val : nums) {
            myset.add(val);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!myset.contains(i)) {
                list.add(i);
            }
        }

        return list;
    }
}
