import java.util.*;

public class HeapSort {
    private int[] a;
    private int size;
    
    public HeapSort(int[] a) {
        this.a=a;
        this.size=a.length-1;
        //sort();
    }
    
    public void sort() {
       for(int i=size/2;i>=0;i--) {
            sink(i);
         }
        while(size>0) {
            swap(0,size);
            size--;
            sink(size);
        }
    }

    private void sink(int i) {
        int max=i;
        int left=2*i;
        int right=2*i+1;
        if(left<=size&&a[left]>a[max]) {
            max=left;
        }
        if(right<=size&&a[right]>a[max]) {
            max=right;
        }
        if(max!=i) {
            swap(i,max);
        }
        sink(max);
    }

    private void swap(int i,int j) {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    public static void print(int[] a) {
        for(int i:a) {
            System.out.println(a+",");
        }
    }
    public static void main(String args[])
    {
        //int s=8000;
        //int[] a=new int[s];
        //Random r=new Random();
        
        int []a={5,2,0,1,2,9};
        HeapSort h=new HeapSort(a);
        h.sort();
        print(a);
    }
   /* public static void print(int[] a) {
        for(int i:a) {
            System.out.println(a+",");
        }   
    }*/
}
