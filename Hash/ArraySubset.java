import java.util.*;

public class ArraySubset
{
    static boolean fun(int[] arr1,int[] arr2)
    {
        HashSet<Integer> h=new HashSet<>();
        for(int i=0;i<arr1.length;i++)
        {
            if(!h.contains(arr1[i]))
                h.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++)
        {
            if(!h.contains(arr2[i]))
                return false;
        }
        return true;
    }  
    public static void main(String args[])
    {
        int arr1[] = {11, 1, 13, 21, 3, 7}; 
        int arr2[] = {11, 2, 7, 1}; 
        System.out.println(fun(arr1,arr2));
    }
}
