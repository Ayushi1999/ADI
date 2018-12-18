import java.util.*;

public class Bfs
{
    List<Integer>arr[];  //linked list is a implementation of list only.
    
    Bfs(int v)
    {
        arr = new LinkedList[v];
        
        for(int i=0;i<v;i++)
        {
            arr[i] = new LinkedList();
        }
    }
    
    void insert(Bfs b,int x,int y)
    {
        b.arr[x].add(y);
    }

    void bfs(int v)
    {
        boolean[] visited = new boolean[100];   //int[]-uses 12 bytes,so use it instead of Integer[]
        LinkedList<Integer>queue = new LinkedList();
        
        visited[v] = true;
        queue.add(v);
        
        while(queue.size()!=0)
        {
            v = queue.poll();
            System.out.print(v+" ");
            for(int i=0;i<arr[v].size();i++)
            {
                int x = arr[v].get(i);
                if(visited[x] == false)
                {
                    visited[x] = true;
                    queue.add(x);
                }
            }
        } 
    }
    
    public static void main(String args[])
    {
        Bfs b = new Bfs(5);
        b.insert(b,0,1);
        b.insert(b,0,2);
        b.insert(b,1,0);
        b.insert(b,2,0);
        b.insert(b,2,3);
        b.insert(b,3,3);
        b.bfs(2);
    }
}
