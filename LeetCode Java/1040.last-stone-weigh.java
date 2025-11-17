import java.util.Arrays;

class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;

        while (n > 1) {
            // Sort only the first n elements (the active stones)
            Arrays.sort(stones, 0, n);

            int a = stones[n - 1]; // largest
            int b = stones[n - 2]; // second largest

            if (a == b) {
                // both destroyed -> remove both by shrinking n by 1 (we'll treat one slot as removed)
                stones[n - 1] = 0;     // optional, keeps array values tidy
                stones[n - 2] = 0;     // optional
            } else {
                // put the leftover (a - b) into the second-last slot,
                // mark the last as removed, and shrink n
                stones[n - 2] = a - b;
                stones[n - 1] = 0;     // optional
            }

            n--; // one stone removed each round
        }

        return stones[0]; // when n == 1, the remaining stone is at index 0
    }
}
