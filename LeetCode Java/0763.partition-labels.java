/*
763. Partition Labels

Approach (Greedy + Last Occurrence Tracking):

• The goal is to partition the string into as many parts as possible such that
  each character appears in at most one part.

• To decide where a partition can end, we must know the LAST index at which
  each character appears in the string.

• First, we scan the string once and store the last occurrence index of every
  character (using an int[26] since the string contains only lowercase letters).

• Then, we traverse the string from left to right and maintain two pointers:
  - 'start' → beginning of the current partition
  - 'end'   → furthest index the current partition must reach

• While scanning, we keep extending 'end' to the maximum last occurrence of
  all characters seen so far.

• When the current index equals 'end', it means all characters in the current
  partition are fully contained and will not appear later.

• At that point, we close the partition, record its size, and start a new one.

• This greedy approach ensures:
  - All partitions are valid
  - The number of partitions is maximized

Time Complexity: O(n)
Space Complexity: O(1)  (fixed-size array for character tracking)
*/

class Solution {
    public List<Integer> partitionLabels(String s) {

        // This list will store the sizes of each valid partition
        List<Integer> result = new ArrayList<>();

        // 'start' marks the beginning of the current partition
        // 'end' marks the furthest index the current partition must reach
        int start = 0;
        int end = 0;

        // Step 1: Store the last occurrence index of each character
        // This helps us know how far a partition must extend
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        // Step 2: Traverse the string and greedily form partitions
        for (int i = 0; i < s.length(); i++) {

            // Extend the current partition boundary if needed
            end = Math.max(end, last[s.charAt(i) - 'a']);

            // If the current index reaches the boundary,
            // all characters in this partition are fully contained
            if (i == end) {
                // Record the size of the partition
                result.add(end - start + 1);

                // Start a new partition from the next index
                start = i + 1;
            }
        }

        // Return the sizes of all partitions
        return result;
    }
}
p
