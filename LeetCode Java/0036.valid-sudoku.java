import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Create arrays of HashSets for rows, columns, and boxes
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        // Initialize each HashSet in the arrays
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];

                // Skip empty cells denoted by '.'
                if (val == '.') {
                    continue;
                }

                // Determine the 3x3 box index
                int boxIdx = (r / 3) * 3 + (c / 3);

                // If the value already exists in the row, column, or box, it's invalid
                if (rows[r].contains(val) || 
                    cols[c].contains(val) || 
                    boxes[boxIdx].contains(val)) {
                    return false;
                }

                // Add the value to the corresponding sets
                rows[r].add(val);
                cols[c].add(val);
                boxes[boxIdx].add(val);
            }
        }

        return true;
    }
}
