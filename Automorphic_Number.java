// Java program to check if a number is Automorphic
import java.io.*;
class Test {
	// Function to check Automorphic number
	static boolean isAutomorphic(int N)
	{
		// Store the square
		if(N < 0) N = -N;
		int sq = N * N;

		// Start Comparing digits
		while (N > 0) {
			// Return false, if any digit of N doesn't
			// match with its square's digits from last
			if (N % 10 != sq % 10)
				return false;

			// Reduce N and square
			N /= 10;
			sq /= 10;
		}

		return true;
	}

	// Driver method
	public static void main(String[] args)
	{
		int N = 5;

		System.out.println(isAutomorphic(N) ? "Automorphic" : "Not Automorphic");
	}
}
