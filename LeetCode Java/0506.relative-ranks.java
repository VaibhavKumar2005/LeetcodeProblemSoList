import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];

        Integer[] sorted = new Integer[n];
        for (int i = 0; i < n; i++) {
            sorted[i] = score[i];
        }
        Arrays.sort(sorted, Collections.reverseOrder());

        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                map.put(sorted[i], "Gold Medal");
            } else if (i == 1) {
                map.put(sorted[i], "Silver Medal");
            } else if (i == 2) {
                map.put(sorted[i], "Bronze Medal");
            } else {
                map.put(sorted[i], String.valueOf(i + 1));
            }
        }

        for (int i = 0; i < n; i++) {
            result[i] = map.get(score[i]);
        }

        return result;
    }
}
