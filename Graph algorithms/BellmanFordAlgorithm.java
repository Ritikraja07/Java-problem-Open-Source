import java.util.*;

public class BellmanFordAlgorithm {

    static class Edge {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void bellmanFord(List<Edge> edges, int V, int start) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (Edge edge : edges) {
                int u = edge.src;
                int v = edge.dest;
                int w = edge.weight;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        // Check for negative-weight cycles
        for (Edge edge : edges) {
            int u = edge.src;
            int v = edge.dest;
            int w = edge.weight;

            if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                System.out.println("Graph contains a negative-weight cycle.");
                return;
            }
        }

        System.out.println("Shortest Distances from Node " + start + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Node " + i + ": " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 4));
        edges.add(new Edge(0, 2, 3));
        edges.add(new Edge(1, 2, -2));
        edges.add(new Edge(1, 3, 2));
        edges.add(new Edge(1, 4, 3));
        edges.add(new Edge(3, 2, 5));
        edges.add(new Edge(3, 1, 1));
        edges.add(new Edge(4, 3, -4));

        int startNode = 0;

        bellmanFord(edges, V, startNode);
    }
}

/*
The provided Java program implements the Bellman-Ford algorithm to find the shortest distances from a given starting node to all other nodes in a directed graph. Here's a description of the program:

BellmanFordAlgorithm Class:

This is the main class that contains the bellmanFord method for performing the Bellman-Ford algorithm and the main method to demonstrate its usage.
Edge Class:

The Edge class is a nested class used to represent edges in the graph. Each edge has a source node (src), a destination node (dest), and a weight (weight) associated with it.
bellmanFord Method:

The bellmanFord method takes three parameters: a list of Edge objects representing the graph's edges (edges), the number of vertices (V), and the starting node (start) from which the shortest distances are to be calculated.
It initializes an array dist to store the shortest distances from the starting node to all other nodes. Initially, all distances are set to Integer.MAX_VALUE except for the starting node, which is set to 0.
The method then performs the Bellman-Ford algorithm by iterating over the vertices V - 1 times (where V is the number of vertices). In each iteration, it relaxes the edges by checking if there is a shorter path to a vertex through the current vertex. If a shorter path is found, it updates the distance.
After the main loop, the method checks for the presence of negative-weight cycles by iterating over the edges again. If a shorter path is found, it indicates the existence of a negative-weight cycle in the graph.
Finally, it prints the shortest distances from the starting node to all other nodes.
main Method:

The main method is the entry point of the program.
It creates a graph with 5 vertices and initializes a list of Edge objects (edges) to represent the graph's edges.
Each Edge object in the edges list represents a directed edge with its source, destination, and weight.
It specifies the starting node (startNode) from which to find the shortest distances.
It calls the bellmanFord method with the graph's edges, the number of vertices, and the starting node as arguments to calculate and display the shortest distances.
Overall, this program demonstrates the Bellman-Ford algorithm for finding the shortest distances in a weighted directed graph. It also checks for the presence of negative-weight cycles, which can affect the correctness of the shortest path calculations.
    */
