//Problem Statement: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/?envType=daily-question&envId=2023-10-09
// Topic: Binary Search 

class Solution {
    //flag == true      ====>   we are searching first occourance else otherwise
    public int[] searchRange(int[] nums, int target) {
        return new int[] {helper(nums, target, true), helper(nums, target, false)};       
    }
    private int helper(int[] nums, int target, boolean flag) {
        int start =0;
        int ans =-1;
        int end =nums.length -1;

        while(start<= end) {
            int mid = start + (end - start)/2;
            if(target < nums[mid]) {
                end = mid -1;
            }
            else if(target > nums[mid]){
                start = mid +1;
            }
            else {
                ans = mid;
                if(flag) {
                    end = mid -1;
                }
                else{
                    start = mid +1;
                }
            }
        }
        return ans;
    }
}
