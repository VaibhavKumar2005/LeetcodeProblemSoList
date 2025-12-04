class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
            int i = a.length() - 1, j = b.length() - 1, carry = 0;

            while (i >= 0 || j >= 0 || carry == 1) {

    int bitA = 0;
    if (i >= 0) {
        bitA = a.charAt(i) - '0';
        i--;
    }

    int bitB = 0;
    if (j >= 0) {
        bitB = b.charAt(j) - '0';
        j--;
    }

    int sum = bitA + bitB + carry;
    sb.append(sum % 2);
    carry = sum / 2;
}

return sb.reverse().toString();

    }
}
