import java.util.*;

public class G3
{
    private LinkedList<Integer> arr[];  //an array of linked list.
    int v;

    G3(int v)
    {
        this.v=v;
        arr=new LinkedList[v];
        for(int i=0;i<v;i++)
        {
            arr[i]=new LinkedList<>();
        }
    }

    void insert(G3 g1,int x,int y)
    {
        g1.arr[x].add(y);
        //if the graph is usdirected then-> g1.arr[y].add(x)
    }

    /*void print(G g)
    {
        for(int i=0;i<v;i++)
        {
            System.out.println(i);
            for(int j=0;j<v;j++)
            {
                System.out.print(arr[j]);
            }
            System.out.println();
        }
    }*/
    public static void main(String args[])
    {
        int v=5;
        G3 g=new G3(v);
        g.insert(g,0,1);
        g.insert(g,0,4);
        g.insert(g,1,2);
        g.insert(g,1,3);
        g.insert(g,1,4);
        g.insert(g,2,3);
       // g.print(g);
    }
}

