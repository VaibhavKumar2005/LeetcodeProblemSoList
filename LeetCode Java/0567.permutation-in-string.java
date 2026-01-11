class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char c : s1.toCharArray()) {
            freq1[c - 'a']++;
        }

        int windowSize = s1.length();

        for (int i = 0; i < windowSize; i++) {
            freq2[s2.charAt(i) - 'a']++;
        }

        boolean isMatch = true;
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) {
                isMatch = false;
                break;
            }
        }

        if (isMatch) return true;

        for (int i = windowSize; i < s2.length(); i++) {
            freq2[s2.charAt(i) - 'a']++;
            freq2[s2.charAt(i - windowSize) - 'a']--;

            isMatch = true;
            for (int j = 0; j < 26; j++) {
                if (freq1[j] != freq2[j]) {
                    isMatch = false;
                    break;
                }
            }

            if (isMatch) return true;
        }

        return false;
    }
}
