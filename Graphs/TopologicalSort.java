import java.util.*;

@SuppressWarnings("unchecked")
public class TopologicalSort
{
    LinkedList<Integer>arr[];
    int v;

    TopologicalSort(int v)
    {
        this.v = v;
        arr = new LinkedList[v];
        for(int i=0;i<v;i++)
        {
            arr[i] = new LinkedList();
        }
    }

    void addEdge(TopologicalSort g,int x,int y)
    {
        g.arr[x].add(y);
    }

    void dfs(int u,boolean[] visited,Stack s)
    {
        visited[u] = true;
        for(int i=0;i<arr[u].size();i++)
        {
            int x = arr[u].get(i);
            if(!visited[x])
                dfs(x,visited,s);
        }
        s.push(new Integer(u));
    }

    void fun()
    {
        boolean[] visited = new boolean[v];
        Stack s = new Stack();
        for(int i=0;i<v;i++)
        {
            if(!visited[i])
            {
                dfs(i,visited,s);
            }
        }
        while(s.empty() == false)
        {
            System.out.print(s.pop()+" ");
        }
    }
 
    public static void main(String args[])
    {
        TopologicalSort g = new TopologicalSort(6);
        g.addEdge(g,5, 2); 
        g.addEdge(g,5, 0); 
        g.addEdge(g,4, 0); 
        g.addEdge(g,4, 1); 
        g.addEdge(g,2, 3); 
        g.addEdge(g,3, 1);
        g.fun(); 
    }
}
