import java.util.*;

public class NoOfIslands
{
    final static int[] offset = {-1,0,1};

    boolean check(int[][] arr,boolean[][] visited,int a,int b)
    {
        if(a>=0 && a<arr.length && b>=0 && b<arr[0].length)
        {
            if(arr[a][b] == 1 && visited[a][b] == false)
            return true;
        }
        return false;
    }    

    void dfs(int[][] arr,boolean[][] visited,int p,int m)
    {
        if(visited[p][m] == true)
            return;
        visited[p][m] = true;
        for(int i=0;i<offset.length;i++)
        {
            int x = offset[i];
            for(int j=0;j<offset.length;j++)
            {
                int y = offset[j];
                if(x == 0 && y == 0)
                    continue;
                if(check(arr,visited,x+p,y+m) == true)
                {
                    dfs(arr,visited,x+p,y-m);
                }
            }
        }
    }
    
    public void fun(int[][] arr)
    {
        int count = 0;
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                if(arr[i][j] == 1 && visited[i][j] == false)
                {
                    dfs(arr,visited,i,j);
                    count++;
                }
            }
        }
        System.out.println(count);
    } 

   // int[][] rows = {
  /*  void dfs(int[][] arr,int i,int j)
    {
        if(i<0 ||i>=arr.length)
            return;
        if(j<0 ||j>=arr[i].length)
            return;
        if(arr[i][j] != 1)
            return;
        arr[i][j] = -1;
        dfs(arr,i,j+1); //
        dfs(arr,i,j-1); //
        dfs(arr,i+1,j); //
        dfs(arr,i-1,j); //
        
        dfs(arr,i+1,j+1); //
        dfs(arr,i-1,j+1); //
        dfs(arr,i+1,j-1); //
        dfs(arr,i-1,j-1);  
    }
    
    void fun1(int[][] arr)
    {
        int count = 0;
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                if(arr[i][j] == 1)
                {
                    dfs(arr,i,j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }*/
    
    public static void main(String args[])
    {
    :NoOfIslands s = new NoOfIslands();
        int[][] arr = {{1,1,0,0,0},{0,1,0,0,1},{1,0,0,1,1},{0,0,0,0,0},{1,0,1,0,1}};
        s.fu
