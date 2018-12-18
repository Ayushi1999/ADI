import java.util.*;

public class DiGraph
{
    private final int V;
    private Bag[]  adj;
    private int E;

    public DiGraph()
    {
        adj = new bag[V];
        for(int i=0;i<V;i++) {
            adj[i] = new Bag();
        }
    }

    public void addEdge(int v,int w) {
        adj[v].enqueue(w);
        E++;
    }

    public Iterable<Integer>adj(int v) {
        return adj[v];
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }
}
