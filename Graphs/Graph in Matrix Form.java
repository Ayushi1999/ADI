import java.util.Scanner;

public class G1
{
    private int v;
    private int[][] matrix;
    
    G1()
    {
 
    }
    
    G1(int v)
    {
        this.v=v;
        matrix=new int[v+1][v+1];
    }
    
    void Insert(int a,int b,int edge)
    {
        matrix[a][b]=edge;
        matrix[b][a]=edge;
    }
  
    void print()
    {
        System.out.print(" ");
        for(int i=0;i<v;i++)
        {
            System.out.print(i+" ");
        }
        System.out.println();

        for(int i=0;i<v;i++)
        {
            System.out.print(i+" ");
            for(int j=0;j<v;j++)
            {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    void Degree(int v1)
    {
        int incount = 0,outcount = 0;
        for(int i=0;i<v;i++)
        {
            for(int j=0;j<v;j++)
            {
                if(matrix[i][j*v] > 0)
                {
                    incount++;    //
                }
                if(matrix[i*v][j] > v1)
                {
                    outcount++;
                }
            }
        }
        System.out.println(incount+" "+outcount);
    }
    
    public static void main(String args[])
    {
        int x,y;
        Scanner scan=new Scanner(System.in);
        G1 g=new G1();
        int v=scan.nextInt();
        int e=scan.nextInt();
        g=new G1(v);
        
        for(int i=0;i<e;i++)
        {
            x=scan.nextInt();
            y=scan.nextInt();
            g.Insert(x,y,1);
        }
        g.Degree(2);
        g.print();
    }
}

