import java.util.*;

class Edge implements Comparable<Edge> {
    int source;
    int destination;
    int weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
    }
}

class DisjointSet {
    int[] parent;
    int[] rank;

    public DisjointSet(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int i) {
        if (i != parent[i]) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }
}

public class KruskalsAlgorithmOptimized {
    public static List<Edge> kruskalsAlgorithm(List<Edge> edges, int numVertices) {
        List<Edge> minimumSpanningTree = new ArrayList<>();

        // Sort the edges in non-decreasing order of their weights
        Collections.sort(edges);

        DisjointSet disjointSet = new DisjointSet(numVertices);

        for (Edge edge : edges) {
            int sourceRoot = disjointSet.find(edge.source);
            int destinationRoot = disjointSet.find(edge.destination);

            if (sourceRoot != destinationRoot) {
                minimumSpanningTree.add(edge);
                disjointSet.union(sourceRoot, destinationRoot);
            }
        }

        return minimumSpanningTree;
    }

    public static void main(String[] args) {
        int numVertices = 4;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        List<Edge> minimumSpanningTree = kruskalsAlgorithm(edges, numVertices);

        System.out.println("Minimum Spanning Tree:");
        for (Edge edge : minimumSpanningTree) {
            System.out.println(edge.source + " - " + edge.destination + ", Weight: " + edge.weight);
        }
    }
}
