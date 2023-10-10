// Java code to implement the approach

class LongestCommonSubsequenceWithSumK {

static int solve(int a[], int b[], int i, int j, int sum)
{
	if (sum == 0)
	return 0;
	if (sum < 0)
	return Integer.MIN_VALUE;

	if (i == 0 || j == 0) {
	if (sum == 0)
		return 0;
	else
		return Integer.MIN_VALUE;
	}

	// If values are same then we can include this
	// or also can't include this
	if (a[i - 1] == b[j - 1])
	return Math.max(
	1 + solve(a, b, i - 1, j - 1, sum - a[i - 1]),
	solve(a, b, i - 1, j - 1, sum));

	return Math.max(solve(a, b, i - 1, j, sum),
					solve(a, b, i, j - 1, sum));
}

// Driver code
public static void main (String[] args) {
	int a[] = { 9, 11, 2, 1, 6, 2, 7 };
	int b[] = { 1, 2, 6, 9, 2, 3, 11, 7 };
	int n = a.length;
	int m = b.length;
	int sum = 18;

	int ans = solve(a, b, n, m, sum);
	if (ans >= 0)
	System.out.print(ans);
	else
	System.out.print(-1);
}
}


