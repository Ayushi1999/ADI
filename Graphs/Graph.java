import java.util.*;

public class Graph
{
        private Bag[] adj;
	private final int v; 
        int E;
	
        public Graph(int v)
	{
            this.v = v;
    	    adj = new Bag[v];
    	    for(int i=0;i<v;i++)
    	    {
    	        adj[i] = new Bag();
    	    }
	}

	void addEdge(int v,int w)
	{
	    //E++;
	    adj[v].enqueue(w);
	    if(v!=w)
	    {
	        adj[w].enqueue(v);   //self loops avoid.
	    }
            E++;
	}
/*	public Iterable<int> adj(v){
	    return adj[v];
	}*/
	

        public static int degree(Graph g,int v)
        {
            int d = 0;
            Iterator<Integer> ite = g.adj[v].iterator();
            while(ite.hasNext()) {
                d++;
                ite.next();
            }
            return d;
        }
        
        public int maxDegree()
        {
            int max = 0;
            for(int i=0;i<this.v;i++)
            {
                int d;
                max = Math.max(max, d = this.degree(i));
                System.out.println("degree of " + i + " is " + d);
            }
            return max;
        }
	
        /*public static void degree(Graph g,int v) {
	    
            int count = 0;
	    int count1 = 0;
	    
            for(int w:g.adj[v]) {
	        count++;  //e/v   //avg = count/v;
	      /*  if(v == w) {
	            count1++;
	        }  
	    }
	    
            System.out.println("degree="+count+" "+"no of self loops="+count1);
	}*/

        public int degree(int v) {

            Iterator<Integer> ite = adj[v].iterator();
            int count = 0;
            while(ite.hasNext()) {

                count++;
                ite.next();
            }
            return count;
        }
 
	
	//no of self loops-->if w == v {count++}
	public static void main(String args[])
	{
	    Graph g = new Graph(7);
	    g.addEdge(0,1);
	    g.addEdge(0,2);
	    g.addEdge(0,5);
	    g.addEdge(0,6);
	    g.addEdge(5,3);
	    g.addEdge(5,4);
	    g.addEdge(3,4);
	    g.addEdge(6,4);
//	    g.degree(g,0);

            System.out.println(g.maxDegree() + g.maxDegree());
            //System.out.println("Max Degree is " + g.degree(0));
	}
}
