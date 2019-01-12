import java.util.*;

public class Prog
{
    static boolean fun(int[] arr)
    {
        HashMap<Integer,Integer>h = new HashMap<>();

        int max_dist=0; 
        for(int i=0;i<arr.length;i++)
        {
            if(h.get(arr[i])==null)
                h.put(arr[i],i);
            else
            {
                if(i-h.get(arr[i])>3)
                   return false;
            }    
        }
       return  true;
       // System.out.println(max_dist);
    }
    public static void main(String args[])
    {
        int[] arr=new int[]{1,2,3,1,4,5};
        System.out.println(fun(arr));
    }
}
