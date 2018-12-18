import java.util.*;

public class G2
{
    LinkedList<Integer>arr[];  //an array of linked list.
    int v;
    
   // @SuppressWarnings("fallthrough");
    G2(int v)
    {
        this.v = v;
        arr = new LinkedList[v];
    
        for(int i=0;i<v;i++)
        {
            arr[i] = new LinkedList<>();
        }
    }
 
//    @SuppressWarnings("unchecked")
    void insert(G2 g1,int x,int y)
    {
        g1.arr[x].add(y);
        //if the graph is usdirected then-> g1.arr[y].add(x)
    }

    void print(G2 g)
    {
        for(int i=0;i<v;i++)
        {
            System.out.print(i+" ");
            for(int j=0;j<arr[i].size();j++)
            {
                System.out.print(g.arr[i].get(j)+" ");
            }
            System.out.println();
        }
    }
    
    public static void main(String args[])
    {
        int v=5;
        G2 g=new G2(v);
        g.insert(g,0,1);
        g.insert(g,0,4);
        g.insert(g,1,2);
        g.insert(g,1,3);
        g.insert(g,1,4);
        g.insert(g,2,3);
        g.print(g);
    }
}

