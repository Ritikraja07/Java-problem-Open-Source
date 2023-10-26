public class LinearSearchRecursion {

	private static boolean LinerSearch(int[] arr, int index, int key) {
		
		// base case
		if(index == arr.length-1)
			return false;
		
		if(arr[index] == key)    
			return true;
		
		//processing
		
		//recursion
		boolean remainigPart = LinerSearch(arr,index+1,key); //tail recursion if fast
		return remainigPart;
		
	}

public static void main(args[] String){
  int arr[] = {1,3,2,5,9};
	//int size = arr.length;
	int key = 5;

	boolean ans = LinerSearch(arr,0,key);
  System.out.println(ans);
}
