public class KadaneAlgorithm {
    public static int maxSubarraySum(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int maxEndingHere = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Calculate the maximum sum ending at the current element
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);

            // Update the maximum sum if the current subarray is greater
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = maxSubarraySum(nums);
        System.out.println("Maximum Subarray Sum: " + maxSum);
    }
}
