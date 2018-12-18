import java.util.*;

public class Lca
{
    LinkedList<Integer>arr[];
    int v;
  
    Lca(int v)
    {
        this.v = v;
        arr = new LinkedList[v];
        for(int i=0;i<v;i++)
        {
            arr[i] = new LinkedList();
        }
    }

    public void insert(Lca g,int x,int y)
    {
        g.arr[x].add(y);
    }
  
    void dfs(Lca g,int v,boolean[] visited,int[] parent)
    {
        visited[v] = true;
        for(int i=0;i<g.arr[v].size();i++)
        {
            int x = g.arr[v].get(i);
            if(visited[x] == true) {
                continue; 
            }
            else
            {
                parent[x] = v;
                dfs(g,x,visited,parent);
            }
        }
    }
   
    int lca(int x,int y,int[] parent,int[] traversed)
    {
        int result = 0;
        while(true)
        {
            if(x == 0) {
                traversed[x] = 1;
                break; 
            }
            traversed[x] = 1;
            x = parent[x];
        }
        while(true)
        {
            if(traversed[y] == 1)
            {
                result = y;
                break;
            }
            y = parent[y];
        }
        return result;
    }
    
    /*Lca g;
    public void fun(int x,int y)
    {
        fun(g,x,y);
    }*/

    public void fun(Lca g,int x,int y)
    {
        int[] traversed = new int[v];
        int[] parent = new int[v];
        boolean[] visited = new boolean[v];
        dfs(g,0,visited,parent);
        System.out.println(lca(x,y,parent,traversed));
    }
   
    public static void main(String args[])
    {
        Lca g = new Lca(10);
        g.insert(g,0,1);
        g.insert(g,0,7);
        g.insert(g,1,2);
        g.insert(g,1,3);
        g.insert(g,1,6);
        g.insert(g,3,4);
        g.insert(g,3,5);
        g.insert(g,7,8);
        g.insert(g,7,9);
        g.fun(g,0,0);
    }
}
