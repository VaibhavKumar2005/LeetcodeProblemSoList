class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--; // adjust because Excel columns are 1-based
            char c = (char) ('A' + (columnNumber % 26));
            sb.append(c);
            columnNumber /= 26;
        }

        return sb.reverse().toString();
    }
}
