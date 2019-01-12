import java.util.*;

class A
{
    void fun(int[] arr,int k)
    {
        HashMap<Integer,Integer>hash=new HashMap<Integer,Integer>();
        int max_count=0;
        for(int i=0;i<k;i++)
        {
            if(hash.get(arr[i])==null)  //h.get(object key)  //retrieves the value corresponding to the key.
            {
                hash.put(arr[i],1);//inserts the key and the value it is mapping to into the map.
                max_count++;
            }
            else
            {
                int count=hash.get(arr[i]);
                hash.put(arr[i],count+1);
            }
        }
        System.out.println(max_count);
  
        for(int i=k;i<arr.length;i++)
        {
            if(hash.get(arr[i-k]) == 1)
            {
                hash.remove(arr[i-k]);
                max_count--;
            }
            else
            {
                int count=hash.get(arr[i-k]);
                hash.put(arr[i-k],count--);
            }
            
            if(hash.get(arr[i])==null)
            {
                hash.put(arr[i],1);
                max_count++;
            }
            else
            {
                int count=hash.get(arr[i]);
                hash.put(arr[i],count+1);
            }
          System.out.println(max_count);  
        }
    }
}
public class Windowsize
{
    public static void main(String args[])
    {
        A a=new A();
        int arr[]=new int[]{1,2,1,3,4,2,3};
        a.fun(arr,4);
    }
}
