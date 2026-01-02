class Solution {
    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();

        int[] result = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';

                int multiply = digit1 * digit2;

                int position = i + j + 1;

                int sum = multiply + result[position];

                result[position] = sum % 10;       
                result[position - 1] += sum / 10;  
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int num : result) {
            if (!(answer.length() == 0 && num == 0)) {
                answer.append(num);
            }
        }

        return answer.toString();
    }
}
