import java.util.LinkedList;
import java.util.Queue;

public class LeeAlgorithmOptimized {

    private static final int[] dx = {-1, 0, 1, 0}; // Array to represent movements in the x-axis
    private static final int[] dy = {0, 1, 0, -1}; // Array to represent movements in the y-axis

    private static boolean isValid(int[][] matrix, int row, int col, boolean[][] visited) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        // Check if the position is within the matrix bounds and not visited before
        return (row >= 0 && row < numRows && col >= 0 && col < numCols && matrix[row][col] == 0 && !visited[row][col]);
    }

    public static void leeAlgorithm(int[][] matrix, int startX, int startY) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        boolean[][] visited = new boolean[numRows][numCols];
        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();

        queueX.add(startX); // Initialize the queues with the start position
        queueY.add(startY);
        visited[startX][startY] = true;

        while (!queueX.isEmpty()) {
            int x = queueX.poll(); // Get the current position
            int y = queueY.poll();

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i]; // Calculate the new position
                int newY = y + dy[i];

                if (isValid(matrix, newX, newY, visited)) {
                    queueX.add(newX); // Add the new position to the queue
                    queueY.add(newY);
                    visited[newX][newY] = true;
                    matrix[newX][newY] = -1; // Mark the position as visited
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 1, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0}
        };

        int startX = 1;
        int startY = 1;

        leeAlgorithm(matrix, startX, startY);

        // Print the modified matrix after running the algorithm
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
