# Last updated: 9/23/2026, 2:52:56 PM
class Solution:
    def isPalindrome(self, s):
        new = ""
        for c in s:
            if c.isalnum():
                new += c.lower()
        return new == new[::-1]