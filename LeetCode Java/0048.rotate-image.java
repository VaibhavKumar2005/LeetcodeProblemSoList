class Solution {

    /*
     * Problem: Rotate Image (90 degrees clockwise)
     *
     * Approach:
     * A 90-degree clockwise rotation can be done in-place using two steps:
     *
     * 1. Transpose the matrix:
     *    - Convert rows into columns by swapping matrix[i][j] with matrix[j][i]
     *    - Only swap elements in the upper triangle to avoid double swapping
     *
     * 2. Reverse each row:
     *    - This reorders elements horizontally to achieve the final rotation
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1) (in-place modification)
     */

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}
