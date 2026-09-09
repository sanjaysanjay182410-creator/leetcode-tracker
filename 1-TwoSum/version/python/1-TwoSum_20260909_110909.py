# Last updated: 9/9/2026, 11:09:09 AM
1class Solution:
2    def twoSum(self, nums, target):
3        seen = {}
4        for i, num in enumerate(nums):
5            complement = target - num
6            if complement in seen:
7                return [seen[complement], i]
8            seen[num] = i