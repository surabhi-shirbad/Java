import java.util.*;

public class BellmanFord {

    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // Create Graph
    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        graph[2].add(new Edge(2, 4, 3));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

        graph[3].add(new Edge(3, 5, 1));
    }

    // Bellman Ford Algorithm
    public static void bellmanFord(ArrayList<Edge> graph[], int src, int V) {

        int dist[] = new int[V];

        for (int i = 0; i < V; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        // Relax all edges V-1 times
        for (int k = 0; k < V - 1; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < graph[i].size(); j++) {

                    Edge e = graph[i].get(j);
                    int u = e.src;
                    int v = e.dest;

                    if (dist[u] != Integer.MAX_VALUE &&
                            dist[u] + e.wt < dist[v]) {
                        dist[v] = dist[u] + e.wt;
                    }
                }
            }
        }


        for (int i = 0; i < V; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int V = 6;   // Vertices are 0 to 5

        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        bellmanFord(graph, 0, V);
    }
}