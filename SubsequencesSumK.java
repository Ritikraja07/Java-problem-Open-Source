//Question : Find all subsequences with sum equals to K

import java.util.*;
public class SubsequencesSumK
{

	// Function to find the subsequences
	// with given sum
	public static void subSequenceSum(
		ArrayList<ArrayList<Integer>> ans,
		int a[], ArrayList<Integer> temp,
						int k, int start)
	{
		// Here we have used ArrayList
		// of ArrayList in Java for
		// implementation of Jagged Array

		// if k < 0 then the sum of
		// the current subsequence
		// in temp is greater than K
		if(start > a.length || k < 0)
			return ;

		// if(k==0) means that the sum
		// of this subsequence
		// is equal to K
		if(k == 0)
		{
			ans.add(
			new ArrayList<Integer>(temp)
			);
			return ;
		}
		else {
			for (int i = start;
				i < a.length; i++) {

				// Adding a new
				// element into temp
				temp.add(a[i]);

				// After selecting an
				// element from the
				// array we subtract K
				// by that value
				subSequenceSum(ans, a,
				temp, k - a[i],i+1);

				// Remove the lastly
				// added element
				temp.remove(temp.size() - 1);
			}
		}
	}

	// Driver Code
	public static void main(String args[])
	{
		int arr[] = {5, 12, 3, 17, 1,
					18, 15, 3, 17};
		int k = 6;
		ArrayList<ArrayList<Integer>> ans;
		ans= new ArrayList<
				ArrayList<Integer>>();
		subSequenceSum(ans, arr,
			new ArrayList<Integer>(), k, 0);
			
		// Loop to print the subsequences
		for(int i = 0; i < ans.size();
		i++){
			for(int j = 0;
			j < ans.get(i).size(); j++){
				System.out.print(
					ans.get(i).get(j));
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
