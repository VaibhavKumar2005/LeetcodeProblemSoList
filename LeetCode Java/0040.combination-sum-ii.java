import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);

        backtrack(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    void backtrack(int[] arr, int target, int start,
                   List<Integer> path,
                   List<List<Integer>> result) {

        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = start; i < arr.length; i++) {

            if(i > start && arr[i] == arr[i-1])
                continue;

            if(arr[i] > target)
                break;

            path.add(arr[i]);

            backtrack(arr, target - arr[i], i + 1, path, result);

            path.remove(path.size() - 1);
        }
    }
}
