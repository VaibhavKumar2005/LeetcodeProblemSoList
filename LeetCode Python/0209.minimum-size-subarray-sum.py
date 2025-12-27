class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        left = 0
        total = 0
        result = len(nums) + 1

        for i in range(len(nums)):
            total+= nums[i]

            while total >= target:
                result = min(result, i - left + 1)
                total-= nums[left]
                left+=1

        if result == len(nums) + 1:
            return 0
        return result

# Approach (Sliding Window)

# Use two pointers (left and right) to represent a window

# Keep a variable to store the sum of elements inside the window

# Initialize the answer with a large value

# Move the right pointer across the array

# Add the current element to the window sum

# While the window sum is greater than or equal to the target:

# Update the minimum length

# Remove the element at left from the sum

# Move the left pointer forward

# If no valid subarray is found, return 0

# Otherwise, return the minimum length found

# Complexity

# Time Complexity: O(n)

# Space Complexity: O(1)
