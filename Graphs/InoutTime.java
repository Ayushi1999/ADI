import java.util.*;

public class InoutTime
{
    private LinkedList<Integer>arr[];
    int time;
    
    InoutTime(int v)
    {
        arr = new LinkedList[v];

        for(int i=0;i<v;i++)
        {
            arr[i] = new LinkedList();
        }
        time = -1;
    }
    
    void insert(InoutTime t,int x,int y)
    {
        t.arr[x].add(y);
  //      t.arr[y].add(x);
    }

    void fun(boolean[] visited,int[] intime,int[] outtime,int v)
    {
        intime[v] = ++time;
        visited[v] = true;
  
        for(int i=0;i<arr[v].size();i++)
        {
            int x=arr[v].get(i);
            if(visited[x] == false)
            {
                 fun(visited,intime,outtime,x);
            }
        }
        
        outtime[v] = ++time;
        //return time;
    }

    void getTime(int v)
    {
        boolean[] visited = new boolean[100];
        int[] intime = new int[100];
        int[] outtime = new int[100];
    //    int time = -1; 
     
        fun(visited,intime,outtime,v);
       
        for(int i=0;i<6;i++)
        {
            System.out.print(i+"--->"+intime[i]+" "+outtime[i]);
            System.out.println();
        }
    }

    public static void main(String args[])
    {
        InoutTime t=new InoutTime(6);
        t.insert(t,0,1);
        t.insert(t,0,2);
        t.insert(t,2,3);
        t.insert(t,2,4);
        t.insert(t,3,1);
        t.insert(t,3,5);
        t.insert(t,4,5);
     //   t.insert(t,6,7);
        t.getTime(0);
    }
}

