class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        seen = set()
        repeated = set()

        for i in range(len(s) - 9):
            substring = s[i:i+10]

            if substring in seen:
                repeated.add(substring)
            else:
                seen.add(substring)

        return list(repeated)


# Explanation

# Use a sliding window of length 10 to generate all possible DNA substrings.

# Iterate through the string and extract each substring s[i : i + 10].

# Store substrings seen for the first time in a set called seen.

# If a substring appears again, add it to a set called repeated.

# Sets provide constant-time lookups and prevent duplicate entries.

# Return all substrings stored in repeated.

# Complexity

# Time Complexity: O(n)

# Space Complexity: O(n)
