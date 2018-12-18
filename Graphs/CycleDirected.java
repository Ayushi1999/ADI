import java.util.*;

public class CycleDirected
{
    LinkedList<Integer>arr[];
    int v;

    CycleDirected(int v)
    {
        this.v = v;
        arr = new LinkedList[v];
        for(int i=0;i<v;i++)
        {
            arr[i] = new LinkedList();
        }
    }

    void add(CycleDirected c,int x,int y)
    {
        c.arr[x].add(y);
     //   c.arr[y].add(x);
    }

    private boolean dfs(boolean[] visited,boolean[] stack,int v)  //the vertex must be visited and in the stack.
    {
        visited[v] = true;
        stack[v] = true;
        for(int i=0;i<arr[v].size();i++)
        {
            int x = arr[v].get(i);
//            parent[x] = v;
            if(visited[x] == false)
            {
                if(dfs(visited,stack,x)) 
                {
                    return true;
                }
            }
            else
            {
                if(stack[x] == true)
                    return true;
            }
        }
        stack[v] = false;
        return false;
    }

    public boolean check()
    {
        boolean[] visited = new boolean[v];
        boolean[] stack = new boolean[v]; //to check if that element is already in the stack or not.(means already directing some vertex or not).
        //int[] parent = new int[v];

        for(int i=0;i<v;i++)
        {
            visited[i] = false;
        }

        for(int i=0;i<v;i++)
        {
                if(dfs(visited,stack,i)) {return true;}
        
        }
        return false;
    }
    public static void main(String args[])
    {
        CycleDirected c = new CycleDirected(5);
        c.add(c,1,0);
        c.add(c,0,2);
//        c.add(c,2,0);
        c.add(c,0,3);
        c.add(c,3,4);
        System.out.println(c.check());
    }
}

