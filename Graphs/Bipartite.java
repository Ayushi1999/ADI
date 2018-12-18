import java.util.*;

@SuppressWarnings("unchecked")
public class Bipartite
{
    List<Integer>arr[];
    int v;
    boolean[] color;
    private final boolean BLACK = false;
    private final boolean RED = true;

    Bipartite(int v)
    {
        this.v = v;
        arr = new LinkedList[v];
        for(int i=0;i<v;i++)
        {
            arr[i] = new LinkedList();
        }
        color = new boolean[v];
   //     color[0] = false;
    }

    void add(Bipartite b,int x,int y)
    {
        b.arr[x].add(y);
        b.arr[y].add(x);
    }
    
    boolean dfs(int u,boolean[] visited)
    {
        visited[u] = true;
        color[u] = true;
        for(int i=0;i<arr[u].size();i++)
        {
            int x = arr[u].get(i);
            if(!visited[x])
            {
                color[x] = !color[u];
                dfs(x,visited);
            }
            else
            {
                if(color[x] == color[u]) {
                    return false;
                }
            }
        }
        return true;
    }                   
    
    void fun()
    {
        boolean[] visited = new boolean[v];
        boolean c = dfs(1,visited);
        System.out.println(c);
    }

    boolean dfs1(int[][]arr,int[] color,int u)
    {
        LinkedList<Integer> q = new LinkedList();
        q.add(u);
        while(q.size()!=0)
        {
            int x = q.poll();
            for(int i=0;i<v;i++)
            {
                if(arr[u][i] == 1 && color[i] == -1)
                {
                    color[i] = 1-color[u];
                    q.push(x);
                }
                else if(arr[u][i] == 1 && color[i] == color[u])
                    return false;
            }
        }
        return true;
    }
    
    void fun1(int[][] arr)
    {
        int[] colored = new int[v];

        for(int i=0;i<v;i++)
        {
            colored[i] = -1;
        }

        int p = 0;

        for(int i=0;i<v;i++)
        {
            if(colored[i] == -1)
            {
                if(!dfs1(arr,colored,i)) {
                    System.out.println("false");
                    p = 1;
                    break;
                }
            } 
        }

        if(p == 0)
            System.out.println("true");
    }
    
    public static void main(String args[])
    {
        Bipartite b = new Bipartite(4);
        int arr[][] = {{0,1,0,1},{1,0,1,0},{0,1,0,1},{1,0,1,0}};
      /*  b.add(b,1,2);
        b.add(b,2,3);
        b.add(b,3,4);
        b.add(b,4,5);
        b.add(b,5,6);
        b.add(b,6,1);*/
        b.fun1(arr);
    }
}
