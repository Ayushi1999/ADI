import java.util.*;

public class ArraySumPresent
{
    static void fun(int[] arr,int sum)
    {
        HashSet<Integer>h = new HashSet<>();
        for(int i=0;i<arr.length;i++)
        {
            int x=sum-arr[i];
            if(h.contains(x))
            {
                System.out.println(arr[i]+" "+x);
            }
            h.add(arr[i]);
        }
    }
    public static void main(String args[])
    {
        int[] arr=new int[]{1,4,45,6,10,-8};
        int sum=16;
        fun(arr,sum);
    }
}

