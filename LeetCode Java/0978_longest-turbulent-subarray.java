class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        if (n == 1) return 1;

        int prevCmp = 0;
        int currLen = 1;
        int maxLen = 1;

        for (int i = 1; i < n; i++) {
            int cmp = Integer.compare(arr[i - 1], arr[i]);

            if (cmp == 0) {
                currLen = 1;
            } 
            else if (prevCmp * cmp == -1) {
                currLen++;
            } 
            else {
                currLen = 2;
            }

            maxLen = Math.max(maxLen, currLen);
            prevCmp = cmp;
        }

        return maxLen;
    }
}
