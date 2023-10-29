import java.util.*;

class DijkstraAlgorithm {
    private static final int INF = Integer.MAX_VALUE;

    public static void dijkstra(int[][] graph, int source) {
        int vertices = graph.length;
        int[] distance = new int[vertices];
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            distance[i] = INF;
            visited[i] = false;
        }

        distance[source] = 0;

        for (int i = 0; i < vertices - 1; i++) {
            int minDistance = findMinDistance(distance, visited);
            visited[minDistance] = true;

            for (int j = 0; j < vertices; j++) {
                if (!visited[j] && graph[minDistance][j] != 0 && distance[minDistance] != INF
                        && distance[minDistance] + graph[minDistance][j] < distance[j]) {
                    distance[j] = distance[minDistance] + graph[minDistance][j];
                }
            }
        }

        printShortestPaths(distance);
    }

    private static int findMinDistance(int[] distance, boolean[] visited) {
        int minDistance = INF;
        int minIndex = -1;
        int vertices = distance.length;

        for (int i = 0; i < vertices; i++) {
            if (!visited[i] && distance[i] < minDistance) {
                minDistance = distance[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static void printShortestPaths(int[] distance) {
        int vertices = distance.length;
        System.out.println("Vertex \t Shortest Distance from Source");
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + " \t " + distance[i]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        dijkstra(graph, 0);
    }
}
