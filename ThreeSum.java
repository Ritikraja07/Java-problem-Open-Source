import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); 
	    List<List<Integer>> triplets = new ArrayList<>();
	    
	    for (int i = 0; i < nums.length - 2; i++) {
	        if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
	            int start = i + 1;
	            int end = nums.length - 1;
	            int target = -nums[i];

	            while (start < end) {
	                if (nums[start] + nums[end] == target) {
	                    triplets.add(Arrays.asList(nums[i], nums[start], nums[end]));

	                    while (start < end && nums[start] == nums[start + 1]) start++;
	                    while (start < end && nums[end] == nums[end - 1]) end--;

	                    start++;
	                    end--;
	                } else if (nums[start] + nums[end] < target) {
	                    start++;
	                } else {
	                    end--;
	                }
	            }
	        }
	    }
		return triplets;
    }
	public static void main(String[] args) {
		int nums[]= {-1,0,1,2,-1,-4};
		System.out.println(threeSum(nums));
	}
}
