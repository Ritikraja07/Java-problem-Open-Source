import java.util.*;

public class Solution {
    public static int nCr(int n, int r) {
        long res = 1;
        // calculating nCr:
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return (int) res;
    }

    public static int[][] pascalTriangle(int N) {
        int[][] ans = new int[N][];
        for (int row = 0; row < N; row++) {
            ans[row] = new int[row + 1];
            for (int col = 0; col <= row; col++) {
                ans[row][col] = nCr(row, col);
            }
        }
        return ans;
    }
}
