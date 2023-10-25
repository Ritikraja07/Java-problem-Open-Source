import java.util.Arrays;

public class DijkstraShortestPath {
    public void dijkstra(int[][] graph, int src) {
        int V = graph.length;
        int[] dist = new int[V];
        boolean[] sptSet = new boolean[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        printSolution(dist);
    }

    private int minDistance(int[] dist, boolean[] sptSet) {
        int minDist = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < dist.length; v++) {
            if (!sptSet[v] && dist[v] <= minDist) {
                minDist = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    private void printSolution(int[] dist) {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < dist.length; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 9; // The number of vertices
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

        DijkstraShortestPath shortestPath = new DijkstraShortestPath();
        shortestPath.dijkstra(graph, 0);
    }
}
