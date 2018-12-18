import java.util.*;

public class Dfs
{
    private LinkedList<Integer>arr[];
    
    Dfs(int v)
    {
        arr = new LinkedList[v];
        for(int i=0;i<v;i++)
        {
            arr[i] = new LinkedList();
        }
    }

    void insert(int x,int y,Dfs d)
    {
        arr[x].add(y);
    }
 
    //in dfs each edge is traversed twice.
    void dfs1(int v,boolean[] visited)
    {
        visited[v] = true;  //the vertex is discovered.
        System.out.print(v+" ");
        for(int i=0;i<arr[v].size();i++)
        {
            int x = arr[v].get(i);
            if(visited[x] == true)
                continue;
            dfs1(x,visited);
        }
        visited[v] = true;  //processed.
    }
    
    void dfs(int v)
    {
        boolean[] discovered = new boolean[100];  //by default array elements are initialized with 0.
        dfs1(v,discovered);
    }

    public static void main(String args[])
    {
        Dfs d=new Dfs(5);
        d.insert(0,1,d);   //0--->1---->2
        d.insert(0,2,d);   //1--->0---->2
        d.insert(1,2,d);   //2--->0---->3
        d.insert(2,0,d);   //3--->3
        d.insert(2,3,d);
        d.insert(3,3,d);
        d.dfs(2);
    }
}
