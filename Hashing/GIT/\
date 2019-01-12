import java.util.*;

public class LogReader {
    
    public static void main(String[] args) {

    Map<String,Integer> m=new HashMap<>();

    UpdateData u= new UpdateData(m);
    u.run();
    UpdateData u1= new UpdateData(m);
    u1.run();
    UpdateData u2= new UpdateData(m);
    u2.run();
    UpdateData u3= new UpdateData(m);
    u.run();
    UpdateData u4= new UpdateData(m);
    u.run();

    System.out.println(m.get("a")); 
    }
}  //always ans is 8

//iterable->iterator
public class TestIterable {   //standard way to access the ds.
    public static void main(String args[])
    {
        //Test<Integer> s=new HashSet();
        //MyLinkedList s=new MyLinkedList();
        List<Integer>s=new ArrayList<>();
        s.add(1);   
        s.add(2);
        s.add(3);
        s.add(4);
        //print(s);
  
        /*s.add(1000);
        s.add(2500);
        s.add(2500);
        s.add(3123);*/  //common method

        Iterator<Integer>ite=s.iterator();
        while(ite.hasNext()) {
            System.out.println(ite.next());
        }
        
        /*private static void print(Iterable<Integer> i) {
            Iterator<Integer> ite=i.iterator();   //each iterable function have iterator function.
             while(ite.hasNext()) {
            System.out.println(ite.next());
        }*/

    }
}

public class MyLinkedList<T> implements Iterable<T> {}
public Iterator<T> iterator() {}
public class CustomIterator implements Iterator<T>{}
public T next(){}

public class MyLinkedList implements Iterable<Integer> {

    private class Node {
        private int data;
        private Node next;

        public Node(int data)
        {
            this.data=data;
            this.next=null;
        }
   }
   
   public void add(int data)
   {
       if(head == null)
           head=new Node(data);
       else {
           Node t=head;
           while(t.next!=null)
           {
               t=t.next;
               t.next=new Node(data);
           }
      }
   }

   public Iterator<Integer> iterator() {
       return new CustomIterator();
   }

   private class CustomIterator implements Iterator<Integer> {
       private Node temp = head;
    
       public boolean hasNext() {
          return temp != null;
           // return false;
       }
     
       public Integer next() {
           return null;
       }
   }
}


  /*  Thread t1 = new Thread(new UpdateData(m));
    Thread t2 = new Thread(new UpdateData(m));
    Thread t3 = new Thread(new UpdateData(m));
    Thread t4 = new Thread(new UpdateData(m));
    Thread t5 = new Thread(new UpdateData(m));
    Thread t6 = new Thread(new UpdateData(m));
    Thread t7 = new Thread(new UpdateData(m));

    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t5.start();
    t6.start();
    t7.start();

    t1.join();
    t2.join();
    System.out.println(m.get("a"));

    Thread.currentThread().sleep(3000);


    for(int i=0;i<1000;i++) {
        t=new Thread(new Thread(new UpdateData(m));
        t.start();
    }

    t.join();
    Thread.currentThread().sleep(2000);
    System.out.println(m.get("a"));  */

