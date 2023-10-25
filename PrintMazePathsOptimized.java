import java.util.ArrayList;

public class PrintMazePathsOptimized {
    static void generatePaths(int n, int m) {
        ArrayList<String>[][] dp = new ArrayList[n][m];

        // Initialize the last row and last column
        for (int i = 0; i < n; i++) {
            dp[i][m - 1] = new ArrayList<>();
            dp[i][m - 1].add("h".repeat(n - i));
        }
        for (int j = 0; j < m; j++) {
            dp[n - 1][j] = new ArrayList<>();
            dp[n - 1][j].add("v".repeat(m - j));
        }

        // Fill in the DP table
        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                dp[i][j] = new ArrayList<>();
                dp[i][j].addAll(appendChar("h", dp[i][j + 1]));
                dp[i][j].addAll(appendChar("v", dp[i + 1][j]));
            }
        }

        // The result is in dp[0][0]
        System.out.println(dp[0][0]);
    }

    static ArrayList<String> appendChar(String ch, ArrayList<String> list) {
        ArrayList<String> result = new ArrayList<>();
        for (String str : list) {
            result.add(ch + str);
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        generatePaths(n, m);
    }
}
