import java.util.*;

public class MotherVertex  //from which every other vertex can be traversed......//in case of undirected graph,all will be mother vertices.
{
    LinkedList<Integer>arr[];
    int v;

    MotherVertex(int v)
    {
        this.v = v;
        arr = new LinkedList[v];
        for(int i=0;i<v;i++)
        {
            arr[i] = new LinkedList();
        }
    }

    void add(MotherVertex g,int x,int y)
    {
        g.arr[x].add(y);
    }
    
    void dfs(int u,boolean[] visited,int[] count)
    {
        visited[u] = true;
        count[0]+=1;
        
        for(int i=0;i<arr[u].size();i++)
        {
            int x = arr[u].get(i);
            if(visited[x] == true)
                continue;
            else
                dfs(x,visited,count);  
        }
    }
   
    void fun()
    {
        boolean[] visited = new boolean[v];
        int[] count = new int[1];
        for(int i=0;i<v;i++)
        {
            count[0] = 0;
            for(int j=0;j<v;j++)
                visited[j] = false;
            dfs(i,visited,count);
            if(count[0] == v) {
                System.out.println(i);
                break;
            }
        }        
    }
    
    int fun1()
    {
        boolean[] visited = new boolean[100];
        int[] count = new int[1];
        int v1 = 0;
   
        for(int i=0;i<v;i++)
        {
            if(!visited[i]) {
                dfs(i,visited,count);
                v1 = i;
            }
        }

        for(int i=0;i<v;i++)
        {
            visited[i] = false;
        }
        
        dfs(v1,visited,count);
        
        for(int i=0;i<v;i++)
        {
            if(!visited[i])
                return -1;
        }
        return v1;
    }
 
    public static void main(String args[])
    {
        MotherVertex g = new MotherVertex(7);
        g.add(g,0,1);
        g.add(g,0,2);
        g.add(g,1,3);
        g.add(g,4,1);
        g.add(g,6,4);
        g.add(g,5,6);
        g.add(g,5,2);
        g.add(g,6,0);
        System.out.println(g.fun1());
    }
}
