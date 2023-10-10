package graph.algorithms;

public class FloydWarshallAlgorithm {

    public static void floydWarshall(int[][] graph) {
        int V = graph.length;
        int[][] dist = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE
                            && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        System.out.println("Shortest Distances between all pairs of nodes:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == Integer.MAX_VALUE) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(dist[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int V = 4;
        int[][] graph = {
            {0, 5, Integer.MAX_VALUE, 10},
            {Integer.MAX_VALUE, 0, 3, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 1},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0}
        };

        floydWarshall(graph);
    }
}
/*This Java program implements the Floyd-Warshall algorithm to find the shortest distances between all pairs of nodes in a weighted directed graph. Here's a concise description of its key components and functionality:

floydWarshall method:

Computes the shortest distances between all pairs of nodes in a given graph.
Initializes a 2D array dist to store the shortest distances between nodes.
Iterates through all pairs of nodes and initializes dist with the initial edge weights from the graph.
Performs the Floyd-Warshall algorithm by considering each intermediate vertex and updating the shortest distances as needed.
Prints the shortest distances between all pairs of nodes.
main method:

Specifies the number of vertices V and initializes a 2D array graph representing the weighted directed graph.
Calls the floydWarshall method to compute and print the shortest distances between all pairs of nodes in the graph.
The Floyd-Warshall algorithm is used to find the shortest paths between all pairs of vertices in a weighted graph, including both positive and negative edge weights. It is suitable for finding the shortest paths in dense graphs or when the graph's structure changes over time.*/






Regenerate

