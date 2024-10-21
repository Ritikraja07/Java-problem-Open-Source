import java.util.ArrayList;
import java.util.PriorityQueue;

class Pair {
    int node;
    int distance;

    Pair(int distance, int node) {
        this.node = node;
        this.distance = distance;
    }
}

class PrimsAlgorithm {
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);

        int[] vis = new int[V];

        pq.add(new Pair(0, 0));

        int sum = 0;

        while (pq.size() > 0) {
            int wt = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            if (vis[node] == 1)
                continue;
            vis[node] = 1;
            sum = sum + wt;

            for (int i = 0; i < adj.get(node).size(); i++) {
                int edw = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);

                // if(edw == 0) continue;
                if (vis[adjNode] == 0) {
                    pq.add(new Pair(edw, adjNode));
                }
            }
        }
        return sum;
    }
}
