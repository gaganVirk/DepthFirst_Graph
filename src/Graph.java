import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.LinkedList;
import java.util.List;

public class Graph {
    private final int V;           // number of vertices
    private int E = 0;             // number of edges
    private List<Integer>[] adj;  // adjacency lists

    public Graph(int V) {
        this.V = V;
        adj = (List<Integer>[]) new List[V];
        for(int v = 0; v < V; v++)
            adj[v] = new LinkedList<Integer>();
    }

    public Graph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for(int i = 0; i < E; i++) {
            // Add an edge
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v,w);
        }
    }

    public int V() { return V; }
    public int E() { return E; }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
