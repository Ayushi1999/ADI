import java.util.*;

@SuppressWarnings("unchecked")
public class TwoVerticesConnected
{
    LinkedList<Integer>arr[];
    int v;

    TwoVerticesConnected(int v)
    {
        this.v = v;
        arr = new LinkedList[v];
        for(int i=0;i<v;i++)
        {
           arr[i] = new LinkedList();
        }
    }

    void addEdge(TwoVerticesConnected g,int x,int y)
    {
        g.arr[x].add(y);
    }
    
    boolean dfs(boolean[] visited,int u,int y)
    {
        visited[u] = true;
        for(int i=0;i<arr[u].size();i++)
        {
            int p = arr[u].get(i);
            if(p == y)
                return true;
            if(visited[p] == true)
            {
                continue;
            }
            else
                dfs(visited,p,y);
        }
        return false;
    }

    boolean fun(int x,int y)
    {
        boolean[] visited = new boolean[v];
        for(int i=0;i<v;i++)
        {
            visited[i] = false;
        }
        if(dfs(visited,x,y)) return true;
        return false;
    }
   
    public static void main(String args[])
    {
        TwoVerticesConnected g = new TwoVerticesConnected(4);
        g.addEdge(g,0,1); 
        g.addEdge(g,0,2); 
        g.addEdge(g,1,2); 
        g.addEdge(g,2,0); 
        g.addEdge(g,2,3); 
        g.addEdge(g,3,3);
        System.out.println(g.fun(3,1)); 
    }
}
