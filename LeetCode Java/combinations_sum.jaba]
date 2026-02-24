import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        
        backtrack(candidates, target, 0, current, result);
        return result;
    }
    
    private void backtrack(int[] candidates, int target, int start,
                           List<Integer> current,
                           List<List<Integer>> result) {
        
        // Base case: valid combination
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // Base case: invalid path
        if (target < 0) {
            return;
        }
        
        // Try all candidates starting from 'start'
        for (int i = start; i < candidates.length; i++) {
            
            // Choose
            current.add(candidates[i]);
            
            // Recurse (i not i+1 because reuse allowed)
            backtrack(candidates, target - candidates[i], i, current, result);
            
            // Backtrack (undo choice)
            current.remove(current.size() - 1);
        }
    }
}
