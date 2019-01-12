import java.util.*;

public class DeleteArr
{
    static void fun(int[] arr)
    {
        HashMap<Integer,Integer>h = new HashMap<>();
        
        for(int i=0;i<arr.length;i++)
        {
            if(h.get(arr[i])==null)
            {
                h.put(arr[i],1);
                //count++;
            }
            else
            {
                int x=h.get(arr[i]);
                h.put(arr[i],x+1);
            }
        }
 
        int max=0;

        for(int i=0;i<arr.length;i++)
        {
            if(max<h.get(arr[i]))
            {
                max=h.get(arr[i]);
            }
        }
       // System.out.println(max);

        System.out.println(arr.length-max);
    }
    public static void main(String args[])
    {
        int[] arr=new int[]{4,4,3,4,4,2};
        fun(arr);
    }
}

