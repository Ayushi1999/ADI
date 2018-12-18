import java.util.*;

public class SizeOfGraph
{
    private LinkedList<Integer> arr[];
    int v;
    
    SizeOfGraph(int v)
    {
        this.v = v;
        arr = new LinkedList[v];
        for(int i=0;i<v;i++)
        {
            arr[i] = new LinkedList<>();
        }
    }

    void insert(SizeOfGraph g,int x,int y)
    {
        g.arr[x].add(y);
    }
    
/*    void dfs(boolean[] visited,int v,int[] si)
    {
        visited[v] = true;
        for(int i=0;i<arr[v].size();i++)
        {
            int x = arr[v].get(i);

            if(visited[x] == false)
            {
                si[v] = si[v]+si[x];
                dfs(visited,x,si);
            }
        }
        System.out.println(si[v]);    
    }  */
    
 /*   void size(int v)  //size of parent and its consequent childs.
    {
        int[] si = new int[100];
        for(int i=0;i<100;i++)
        {
            si[i] = 1;
        }
        boolean[] visited = new boolean[100];
        dfs(visited,0,si);
    }  */ 
    
    void depth(int v1,int[] dep,boolean[] visited)
    {
        visited[v] = true;
        for(int i=0;i<arr[v1].size();i++)
        {
            int x = arr[v1].get(i);
            if(visited[x] == true)
                continue;
            else
            {
                dep[x] = dep[v1]+1;
                depth(x,dep,visited);
            }
        }
    }
    
    void depth(int v1)
    {
        int[] dep = new int[100];
        boolean[] visited  = new boolean[100];
        depth(v1,dep,visited);
        for(int i=0;i<=2;i++)
        {
            System.out.println(dep[i]+" ");
        }
    }
    
    public static void main(String args[])
    {
        SizeOfGraph g = new SizeOfGraph(5);
        g.insert(g,0,1);
        g.insert(g,0,4);
        g.insert(g,1,2);
        g.insert(g,1,3);
        g.insert(g,2,1);
        g.insert(g,2,4);
        g.insert(g,2,5);
        g.insert(g,3,4);
        g.depth(2);
        //g.size(0);
    }
}
