//Problem Link: https://leetcode.com/problems/longest-palindromic-substring/
//Mancher's Algorithm - T.C-->O(n)

class Solution {
    private int maxLength = 0;
    private int start = 0;
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            extendPalindrome(s, i, i);     // Check for odd-length palindrome
            extendPalindrome(s, i, i + 1); // Check for even-length palindrome
            if(maxLength == s.length())return s.substring(start, start + maxLength);;
        }
        return s.substring(start, start + maxLength);
    }
    private void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Calculate length of palindrome and update start and maxLength
        int length = right - left - 1;
        if (length > maxLength) {
            maxLength = length;
            start = left + 1;
        }
    }

}
