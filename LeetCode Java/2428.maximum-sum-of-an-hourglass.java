/*
2428. Maximum Sum of an Hourglass

Approach:
• An hourglass is a fixed shape consisting of 7 cells arranged across 3 rows.
• Since the shape is fixed and cannot be rotated, we scan all valid positions
  where an hourglass can fit inside the grid.

• For each valid top-left position (i, j), we compute the hourglass sum using
  exactly 7 fixed cell accesses.

• We track the maximum sum encountered during this scan.

Why this works:
• Every possible hourglass placement is evaluated.
• The grid size is small enough that checking all valid positions is efficient.
• There is no overlapping subproblem to optimize further.

Time Complexity: O(m × n)
Space Complexity: O(1)
*/

class Solution {
    public int maxSum(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int maxSum = 0;

        // Iterate over all valid top-left positions of an hourglass
        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {

                // Calculate the sum of the current hourglass
                int sum =
                        grid[i][j]     + grid[i][j + 1]     + grid[i][j + 2]
                                      + grid[i + 1][j + 1]
                      + grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2];

                // Update the maximum hourglass sum
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}
