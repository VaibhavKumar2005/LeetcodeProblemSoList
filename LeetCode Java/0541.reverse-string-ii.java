class Solution {
    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        int n = a.length;
        
        // Loop through the string, jumping 2k characters each time
        for (int start = 0; start < n; start += 2 * k) {
            int i = start;
            // The end of the segment to reverse is either i + k - 1 
            // or the end of the string, whichever comes first.
            int j = Math.min(start + k - 1, n - 1);
            
            // Standard two-pointer reversal
            while (i < j) {
                char temp = a[i];
                a[i++] = a[j];
                a[j--] = temp;
            }
        }
        
        return new String(a);
    }
}
