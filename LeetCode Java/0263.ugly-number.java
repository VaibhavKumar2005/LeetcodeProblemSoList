class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) return false;

        while (n % 2 == 0) n= n/2;
        while (n % 3 == 0) n= n/3;
        while (n % 5 == 0) n= n/5;

        return n == 1;
    }
}
/*Check edge case: If n <= 0, return false (ugly numbers must be positive)
Remove all factors of 2: Divide n by 2 repeatedly while n % 2 == 0
Remove all factors of 3: Divide n by 3 repeatedly while n % 3 == 0
Remove all factors of 5: Divide n by 5 repeatedly while n % 5 == 0
Check result: If n == 1, return true (all prime factors were 2, 3, or 5); otherwise return false
*/
