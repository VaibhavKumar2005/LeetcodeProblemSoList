class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
       HashSet<String> seen = new HashSet<>();
       HashSet<String> repeated = new HashSet<>();

       for(int i = 0; i <= s.length()- 10; i++){
        String sub = s.substring(i, i + 10);

        if(seen.contains(sub)){
            repeated.add(sub);
        }
        else{
            seen.add(sub);
        }

        
       }
       return new ArrayList<>(repeated);
    }
}

/*Explanation

Use a sliding window of size 10 to examine all possible DNA substrings.

Iterate through the string from index 0 to s.length() - 10.

At each step, extract a substring using substring(i, i + 10).

Use a HashSet named seen to store substrings encountered for the first time.

If a substring already exists in seen, add it to another HashSet named repeated.

Using HashSet allows constant-time lookup and prevents duplicate results.

Convert repeated to a List and return it as the final answer.

Complexity

Time Complexity: O(n)

Space Complexity: O(n)*/
