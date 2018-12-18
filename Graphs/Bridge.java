import java.util.*;

class Bridge
{
    int time;
    int[] intime;
    boolean[] visited;
    int[] parent;
    int[] fuv;
    int size;
    LinkedList<Integer>arr[];
   
    Bridge(int v)
    {
        size = v;
        time = 0;
        intime = new int[size];
        visited = new boolean[size];
        parent = new int[size];
        fuv = new int[size];
        arr = new LinkedList[size];
        for(int i=0;i<size;i++)
        {
            arr[i] = new LinkedList();
        }
    }
  
    void add(int x,int y)
    {
        arr[x].add(y);
        arr[y].add(x);
    }
   
    int min(int a,int b)
    {
        return a>b?b:a;
    }

    boolean checkBridge(int u)
    {
        visited[u] = true;
        intime[u] = fuv[u] = time++;  //intime[0] = fuv[0] = 0; // intime[1] = fuv[1] = 1;
        for(int i=0;i<arr[u].size();i++)
        {
            int x = arr[u].get(i);

            if(visited[x] == false)
            {
                parent[x] = u;  //parent[1] = 0  //parent[2] = 1  //parent[3] = 0
                checkBridge(x); //checkBridge(1) //checkBridge(2)
                fuv[u] = min(fuv[x],fuv[u]);
                if(fuv[x]>intime[u])
                    return true;
            }
            else
            {
                if(x!=parent[u])  //1!=parent[2]  //0!=parent[2]
                {
                    fuv[u] = min(fuv[u],intime[x]);  //fuv[2] = 0
                }
            }
        }
        return false;
    }
    
    void set()
    {
        for(int i=0;i<size;i++)
            visited[i] = false;
    } 

    void bridge()
    {
        for(int i=0;i<size;i++)
        {
            set();
            if(checkBridge(i)) {
                System.out.println(i+" ");
            }
        }
    }
   
   public static void main(String args[])
   {
       Bridge b1 = new Bridge(5);
       b1.add(1,0);  //0-->1-->2-->3
       b1.add(0,2);  //1-->0-->2
       b1.add(2,1);  //2-->0-->1
       b1.add(0,3);  //3-->0-->4
       b1.add(3,4);  //4-->3
       b1.bridge();
   }
}
