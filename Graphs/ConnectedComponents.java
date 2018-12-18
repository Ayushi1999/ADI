import java.util.*;

public class ConnectedComponents
{
    LinkedList<Integer>arr[];
    int v;
   
    ConnectedComponents(int v)
    {
        this.v = v;
        arr = new LinkedList[v];
        for(int i=0;i<v;i++)
        {
            arr[i] = new LinkedList();
        }
    }
    
    void add(ConnectedComponents g,int x,int y)
    {
        g.arr[x].add(y);
        g.arr[y].add(x);
    }
    
    void dfs(boolean[] visited,int v)
    {
        System.out.print(v+" ");
        visited[v] = true;
        for(int i=0;i<arr[v].size();i++)
        {
            int x = arr[v].get(i);
            if(visited[x] == true)
                continue;
            dfs(visited,x);
        }
    }
    
    void dfs(ConnectedComponents g)
    {
        boolean[] visited = new boolean[100];     
        for(int i=0;i<g.v;i++)
        {
            if(visited[i] == false) {
                dfs(visited,i);
                System.out.println();
            }
        }
    }

    public static void main(String args[])
    {
        ConnectedComponents g = new ConnectedComponents(5);
        g.add(g,1,0);
        g.add(g,1,2);
        g.add(g,3,4);
        g.dfs(g);
    }
}
