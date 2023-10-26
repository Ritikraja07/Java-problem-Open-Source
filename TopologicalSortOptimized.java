import java.util.*;

public class TopologicalSortOptimized {
    static class Graph {
        private int V;
        private List<Integer> adj[];

        public Graph(int V) {
            this.V = V;
            adj = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new ArrayList<>();
            }
        }

        public void addEdge(int src, int dest) {
            adj[src].add(dest);
        }

        public List<Integer> topologicalSort() {
            Stack<Integer> stack = new Stack<>();
            boolean[] visited = new boolean[V];

            for (int i = 0; i < V; i++) {
                if (!visited[i]) {
                    topologicalSortUtil(i, visited, stack);
                }
            }

            List<Integer> result = new ArrayList<>();
            while (!stack.isEmpty()) {
                result.add(stack.pop());
            }

            return result;
        }

        private void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
            visited[v] = true;
            for (Integer neighbor : adj[v]) {
                if (!visited[neighbor]) {
                    topologicalSortUtil(neighbor, visited, stack);
                }
            }
            stack.push(v);
        }
    }

    public static void main(String[] args) {
        int V = 6;
        Graph graph = new Graph(V);

        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(1, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(5, 0);
        graph.addEdge(5, 2);

        List<Integer> result = graph.topologicalSort();
        for (Integer vertex : result) {
            System.out.print(vertex + " ");
        }
    }
}
