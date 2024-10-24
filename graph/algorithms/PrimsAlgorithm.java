import java.util.*;

class PrimAlgorithm {

    // Helper class to represent an edge in the graph
    static class Edge {
        int vertex;
        int weight;

        Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    // Prim's Algorithm implementation using a priority queue (min-heap)
    public static List<int[]> primsAlgorithm(Map<Integer, List<Edge>> graph, int startVertex) {
        List<int[]> mst = new ArrayList<>(); // List to store the edges of the Minimum Spanning Tree
        Set<Integer> visited = new HashSet<>(); // Set to track visited vertices
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(edge -> edge[2])); // (parent, vertex, weight)

        minHeap.add(new int[]{-1, startVertex, 0}); // Add startVertex with a weight of 0 and no parent

        while (!minHeap.isEmpty()) {
            int[] currentEdge = minHeap.poll();
            int parent = currentEdge[0];
            int vertex = currentEdge[1];
            int weight = currentEdge[2];

            if (visited.contains(vertex)) continue;

            visited.add(vertex);
            if (parent != -1) {
                mst.add(new int[]{parent, vertex, weight}); // Add edge to MST
            }

            // Explore all neighbors of the current vertex
            for (Edge neighbor : graph.get(vertex)) {
                if (!visited.contains(neighbor.vertex)) {
                    minHeap.add(new int[]{vertex, neighbor.vertex, neighbor.weight});
                }
            }
        }

        return mst;
    }

    // Test cases
    public static void main(String[] args) {
        // Graph with 2 vertices
        Map<Integer, List<Edge>> smallGraph = new HashMap<>();
        smallGraph.put(0, Arrays.asList(new Edge(1, 10)));
        smallGraph.put(1, Arrays.asList(new Edge(0, 10)));

        // Graph with 3 vertices
        Map<Integer, List<Edge>> smallGraph2 = new HashMap<>();
        smallGraph2.put(0, Arrays.asList(new Edge(1, 10), new Edge(2, 5)));
        smallGraph2.put(1, Arrays.asList(new Edge(0, 10), new Edge(2, 15)));
        smallGraph2.put(2, Arrays.asList(new Edge(0, 5), new Edge(1, 15)));

        // Large dense graph with 6 vertices
        Map<Integer, List<Edge>> denseGraph = new HashMap<>();
        denseGraph.put(0, Arrays.asList(new Edge(1, 4), new Edge(2, 3), new Edge(3, 2)));
        denseGraph.put(1, Arrays.asList(new Edge(0, 4), new Edge(2, 5), new Edge(4, 8)));
        denseGraph.put(2, Arrays.asList(new Edge(0, 3), new Edge(1, 5), new Edge(4, 6)));
        denseGraph.put(3, Arrays.asList(new Edge(0, 2), new Edge(5, 7)));
        denseGraph.put(4, Arrays.asList(new Edge(1, 8), new Edge(2, 6), new Edge(5, 9)));
        denseGraph.put(5, Arrays.asList(new Edge(3, 7), new Edge(4, 9)));

        // Graph with duplicate edge weights
        Map<Integer, List<Edge>> duplicateWeightsGraph = new HashMap<>();
        duplicateWeightsGraph.put(0, Arrays.asList(new Edge(1, 10), new Edge(2, 10)));
        duplicateWeightsGraph.put(1, Arrays.asList(new Edge(0, 10), new Edge(2, 5)));
        duplicateWeightsGraph.put(2, Arrays.asList(new Edge(0, 10), new Edge(1, 5)));

        // Run the algorithm on different test cases
        List<int[]> mstSmallGraph = primsAlgorithm(smallGraph, 0);
        List<int[]> mstSmallGraph2 = primsAlgorithm(smallGraph2, 0);
        List<int[]> mstDenseGraph = primsAlgorithm(denseGraph, 0);
        List<int[]> mstDuplicateWeights = primsAlgorithm(duplicateWeightsGraph, 0);

        // Print results
        printMST(mstSmallGraph, "Small Graph (2 vertices)");
        printMST(mstSmallGraph2, "Small Graph (3 vertices)");
        printMST(mstDenseGraph, "Large Dense Graph (6 vertices)");
        printMST(mstDuplicateWeights, "Graph with Duplicate Edge Weights");
    }

    // Helper function to print the MST
    public static void printMST(List<int[]> mst, String graphName) {
        System.out.println("MST for " + graphName + ":");
        for (int[] edge : mst) {
            System.out.println("Edge from " + edge[0] + " to " + edge[1] + " with weight " + edge[2]);
        }
        System.out.println();
    }
}
