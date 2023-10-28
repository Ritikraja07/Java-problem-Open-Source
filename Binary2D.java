public class Binary2D {
	public int[] minNumber(int[][] nums,int target) {
		int rows=nums.length;
		int cols=nums[0].length;
		if(cols==0) {
			return new int[]{-1,-1};
		}
		if(rows==1) {
			return binarySearch(nums,target,0,0,cols-1);
		}
		int rStart=0;
		int rEnd=rows-1;
		int cMid=cols/2;
		while(rStart<(rEnd-1)) {
			int mid=rStart+(rEnd-rStart)/2;
			if(nums[mid][cMid]==target) {
				return new int[]{mid,cMid};
			}
			else if(nums[mid][cMid]>target) {
				rEnd=mid;
			}
			else {
				rStart=mid;
			}
		}
		if(target==nums[rStart][cMid]) {
			return new int[]{rStart, cMid};
		}
		if(target==nums[rStart+1][cMid]) {
			return new int[]{rStart+1, cMid};
		}
		if(target<=nums[rStart][cMid-1]) {
			return binarySearch(nums,target,rStart,0,cMid-1);
		}
		if(target<=nums[rStart+1][cMid-1]) {
			return binarySearch(nums,target,rStart+1,0,cMid-1);
		}
		if(target>=nums[rStart][cMid+1]) {
			return binarySearch(nums,target,rStart,cMid+1,cols-1);
		}
		else{
			return binarySearch(nums,target,rStart+1,cMid+1,cols-1);
		}
	}
	public int[] binarySearch(int[][] nums,int target,int rows,int start,int end) {
		while(start<end) {
			int cMid=start+(end-start)/2;
			if(nums[rows][cMid]>target) {
				end=cMid-1;
			}
			else if(nums[rows][cMid]<target) {
				start=cMid+1;
			}
			else {
				return new int[]{rows,cMid};
			}
		}
		return new int[]{-1,-1};
	}
	public static void main(String args[]) {
		Binary b=new Binary();
		int nums[][]= {{1,2,3,4},
				       {5,6,7,8},
				       {9,10,11,12},
				       {13,14,15,16}};
		int target=3;
		int a[]=b.minNumber(nums,target);
		for(int i=0;i<2;i++) {
			System.out.println(a[i]);
	}
  }
}
