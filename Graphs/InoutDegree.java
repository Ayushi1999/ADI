import java.util.*;

@SuppressWarnings("unchecked")
public class InoutDegree
{
    //@SuppressWarnings("unchecked")
    int v;
    LinkedList<Integer>arr[];
    
    InoutDegree(int v)
    {
        this.v = v;
        arr = new LinkedList[v];
        for(int i=0;i<v;i++)
        {
            arr[i] = new LinkedList<>();
        }
    }
    
    void add(InoutDegree g,int x,int y)
    {
        g.arr[x].add(y);
    }

    void dfs1(boolean[] visited,int u,int[] indegree,int[] outdegree)
    {
        outdegree[u] = arr[u].size();
        visited[u] = true;
        for(int i=0;i<arr[u].size();i++)
        {
            int x = arr[u].get(i);
            if(!visited[x])
            {
                dfs1(visited,x,indegree,outdegree);
            }
            indegree[x]++;
        }
    }
    
    void InoutDegree1()
    {
         boolean[] visited = new boolean[v];
         int[] indegree = new int[v];
         int[] outdegree = new int[v];
         for(int i=0;i<v;i++)
         {
             if(!visited[i])
             {
                 dfs1(visited,i,indegree,outdegree);
             }
         }
         for(int i=0;i<v;i++)
         {
             System.out.println(i+" "+indegree[i]+" "+outdegree[i]);
         }
    }
    
    public static void main(String args[])
    {
        InoutDegree g = new InoutDegree(7);
        g.add(g,0,1);
        g.add(g,0,2);
        g.add(g,1,3);
        g.add(g,1,4);
        g.add(g,5,0);
        g.add(g,5,6);
        g.add(g,5,1);
        g.add(g,5,3);
        g.add(g,6,4);
        g.InoutDegree1();
    }
}
