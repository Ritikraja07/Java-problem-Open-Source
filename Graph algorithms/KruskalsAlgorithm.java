import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

public class KruskalsAlgorithm {

    public static List<Edge> kruskalsMST(List<Edge> edges, int V) {
        Collections.sort(edges);

        List<Edge> mst = new ArrayList<>();
        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        for (Edge edge : edges) {
            int srcParent = find(parent, edge.src);
            int destParent = find(parent, edge.dest);

            if (srcParent != destParent) {
                mst.add(edge);
                union(parent, srcParent, destParent);
            }
        }

        return mst;
    }

    public static int find(int[] parent, int vertex) {
        if (parent[vertex] == -1) {
            return vertex;
        }
        return find(parent, parent[vertex]);
    }

    public static void union(int[] parent, int src, int dest) {
        int srcParent = find(parent, src);
        int destParent = find(parent, dest);
        parent[srcParent] = destParent;
    }

    public static void main(String[] args) {
        int V = 4;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        List<Edge> mst = kruskalsMST(edges, V);

        System.out.println("Minimum Spanning Tree Edges:");
        for (Edge edge : mst) {
            System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
        }
    }
}


/* The provided Java code implements Kruskal's algorithm, a greedy algorithm used to find the Minimum Spanning Tree (MST) of a connected, undirected graph. Here's a short description of the code:

1. `Edge` Class:
   - Represents an edge in the graph with attributes `src` (source vertex), `dest` (destination vertex), and `weight` (edge weight).
   - Implements the `Comparable` interface to enable sorting edges based on their weights.

2. `KruskalsAlgorithm` Class:
   - Contains the main Kruskal's algorithm implementation.

3. `kruskalsMST` Method:
   - Takes a list of edges (`edges`) and the number of vertices (`V`) as input.
   - Sorts the list of edges in ascending order based on their weights.
   - Initializes an empty list `mst` to store the MST and an array `parent` to keep track of disjoint sets (initialized with -1).
   - Iterates through the sorted edges:
     - For each edge, it finds the parents of the source and destination vertices using the `find` method.
     - If the source and destination vertices do not belong to the same set (i.e., their parents are different), the edge is added to the MST (`mst`), and the sets are merged using the `union` method.

4. `find` Method:
   - Takes an array `parent` and a vertex as input.
   - Recursively finds the representative (parent) of a set by following the parent pointers until it reaches a vertex with a parent of -1 (representative of the set).

5. `union` Method:
   - Takes an array `parent`, source vertex `src`, and destination vertex `dest`.
   - Finds the parents of both vertices using the `find` method and makes one vertex the parent of the other by updating the `parent` array.

6. `main` Method:
   - Initializes the number of vertices (`V`) and a list of edges (`edges`) representing the graph.
   - Calls the `kruskalsMST` method to find the MST.
   - Prints the edges of the Minimum Spanning Tree, along with their weights.

In summary, this code demonstrates the Kruskal's algorithm to find the Minimum Spanning Tree of a graph, and it prints the edges of the MST as the final output. The algorithm works by iteratively selecting edges with the smallest weights while avoiding cycles to construct a tree that spans all vertices with the minimum total weight. */
