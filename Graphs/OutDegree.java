import java.util.*;

public class OutDegree
{
    LinkedList<Integer>arr[];
    
    public OutDegree(int vertex)
    {
        arr = new LinkedList[vertex];
        for(int i=0;i<vertex;i++)
        {
            arr[i] = new LinkedList();
        }
    }
    
    void insert(int x,int y,OutDegree g)
    {
        g.arr[x].add(y);
//        g.arr[y].add(x);
    }

  /*  void print()
    {
        for(int i=0;i<v;i++)
        {
            System.out.print(i+" ");
                System.out.print(outdeg[i]);
        }
    }  */

    void out(OutDegree g,int[] visited,int[] indeg,int v)
    {
        visited[v] = 1;
        for(int i=0;i<arr[v].size();i++)
        {
            int x = arr[v].get(i);
            if(x == v)
                indeg[v]++;
         //   if(g.contains(x))
         //   {
                //outdeg[x]++;   //in case of undirected graph,in and outdegree will be same.
         //   }

            if(visited[x] == 0)
                out(g,visited,indeg,x);
        }
        visited[v]=2;
    }

    void outDegree(int v,OutDegree g)
    {
        int[] visited = new int[100];
        int[] outdeg = new int[100];
        out(g,visited,outdeg,0);
      //  System.out.println("ffghj");
        for(int i=0;i<4;i++)
        {
         //   System.out.print(i+" ");
            System.out.println(outdeg[i]);
        }  
    }
    
    private void outDeg(int v)
    {
        int[] outdegree = new int[100];
    
        outdegree[v] = arr[v].size();  //outdegree is equal to size of array list of that vertex.
        System.out.println(outdegree[v]);

        int count = 0;
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[i].size();j++)
            {
                if(arr[i].get(j) == v)
                {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
    
    public static void main(String args[])
    {
        OutDegree g = new OutDegree(5);
        g.insert(0,2,g);  //0-->1-->2-->3
        g.insert(0,1,g);  //1-->0-->3
    //    g.insert(0,3,g);  //2-->0-->3
        g.insert(1,2,g);  //3-->0-->1-->2
    //    g.insert(1,0,g);
        g.insert(2,3,g);
        g.insert(2,1,g);
        g.insert(2,3,g);
        g.insert(3,4,g);
        g.insert(4,0,g);
     //   g.insert(2,3,g);
    //    g.insert(3,0,g);
    //    g.insert(3,1,g);
    //    g.insert(3,2,g);
       // g.outDegree(0,g);
        g.outDeg(0);
    }
}
