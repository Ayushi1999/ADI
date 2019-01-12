import java.util.*;

class A
{
    void fun(PriorityQueue<Integer>min,Integer[] a,Integer[] b)
    {
       // int i=0;
            /*for(int j=0;j<b.length;j++)
            {
                min.add(a[i]+b[j]);
            }*/
            for(int i=0;i<a.length;i++)
            {
                for(int j=0;j<b.length;j++)
                {
                    if(min.size()<a.length)
                    {
                        min.add(a[i]+b[j]);
                    }
                    else
                    {
                        if((a[i]+b[j])>=min.peek())
                        {
                            min.poll();
                            min.add(a[i]+a[j]);
                        }
                        else
                        {
                            break;
                        }
                    }
                }
            }
            ArrayList<Integer>al=new ArrayList<Integer>();

            for(int i=0;i<a.length;i++)
            {
                al.add(min.peek());
                min.poll();
            }
            for(int i:al)
            {
                System.out.println(i);
            }
    }
    void add (Integer[] a,Integer[] b)
    {
        PriorityQueue<Integer> min=new PriorityQueue<Integer>();
        fun(min,a,b);
    }
}

class MaxP
{
    public static void main(String args[])
    {
        A a1=new A();
        Integer[] a=new Integer[]{1,2,3,4};
        Integer[] b=new Integer[]{1,2,5,6};
        Arrays.sort(a,Collections.reverseOrder());
        Arrays.sort(b,Collections.reverseOrder());
        a1.add(a,b);
    }
}

