import java.util.*;

public class CycleUndirected
{
    LinkedList<Integer>arr[];
    int v;

    CycleUndirected(int v)
    {
        this.v = v;
        arr = new LinkedList[v];
        for(int i=0;i<v;i++)
        {
            arr[i] = new LinkedList();
        }
    }

    void add(CycleUndirected c,int x,int y)
    {
        c.arr[x].add(y);
        c.arr[y].add(x);
    }

    private boolean dfs(boolean[] visited,int parent,int v1)
    {
        visited[v1] = true;
        for(int i=0;i<arr[v1].size();i++)
        {
            int x = arr[v1].get(i);
//            parent[x] = v;
            if(visited[x] == true) {
            if(x!=parent)
            {
                return true;
            }
            }
            else
            {
                if(dfs(visited,v1,x)) {return true;}
            }
        }
        return false;
    }
    
    public boolean check()
    {
        boolean[] visited = new boolean[v];
        //int[] parent = new int[v];
        for(int i=0;i<v;i++)
        {
            visited[i] = false;
        }
        for(int i=0;i<v;i++)
        {
            if(!visited[i]) {
               if(dfs(visited,-1,i)) return true;
            }
        }
        return false;
    }
    
    public static void main(String args[])
    {
        CycleUndirected c = new CycleUndirected(5);
        c.add(c,1,0);
        c.add(c,0,2);
        c.add(c,2,0);
        c.add(c,0,3);
        c.add(c,3,4);
        System.out.println(c.check()); 
    }
}
