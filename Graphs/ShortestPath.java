import java.util.*;

public class ShortestPath
{
    List<Integer>arr[];
    int v;

    ShortestPath(int v)
    {
        this.v = v;
        arr = new LinkedList[v];
        for(int i=0;i<v;i++)
        {
            arr[i] = new LinkedList();
        }
    }

    void add(ShortestPath s,int x,int y)
    {
        s.arr[x].add(y);
        s.arr[y].add(x);
    }
    
    void fun(int x,int y)
    {
        
    }    

    public static void main(String args[])
    {
        ShortestPath s = new ShortestPath(8);
        s.add(s,0,1);
        s.add(s,0,3);
        s.add(s,1,2);
        s.add(s,3,4);
        s.add(s,3,7);
        s.add(s,4,5);
        s.add(s,4,6);
        s.add(s,4,7);
        s.fun(0,6);
    }
}
