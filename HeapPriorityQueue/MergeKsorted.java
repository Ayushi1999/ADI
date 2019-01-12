import java.util.*;

    class Node
    {
        public int val;
        public Node next;

        Node()
        {
        }

        public Node newNode(int data)
        {
            Node nn = new Node();
            nn.val = data;
            nn.next = null;
            return nn;
        }
    
    Node mergeSortedLists(Node[] arr)
    {
        Node head = newNode(0);
        Node head1 = head;

        PriorityQueue<Node> min = new PriorityQueue<Node>(new Comparator<Node>(){
                                  public int compare(Node a,Node b)
                                  {
                                      return a.val-b.val;
                                  }}
                                  );

        for(int i=0;i<arr.length;i++)
        {
            min.add(arr[i]);
        }

        while(min.size()>0)
        {
            Node x = min.poll();

            head.next = x;
            head = head.next;
            if(x.next!=null)
            {
                min.add(x.next);
            }
        }
        return head1.next;
    }

    public void print(Node h)
    {
        while(h!=null)
        {
            System.out.println(h.val+" ");
            h = h.next;
        }
    }
}

public class MergeKsorted
{
    public static void main(String args[])
    {
        MergeKsorted m = new MergeKsorted();
        Node nn = new Node();
        Node[] arr = new Node[3];

        arr[0] = nn.newNode(1);  //     1-->3-->5-->7
        arr[0].next = nn.newNode(3);
        arr[0].next.next = nn.newNode(5);
        arr[0].next.next.next = nn.newNode(7);

        arr[1] = nn.newNode(2);  //2-->4-->6-->8
        arr[1].next = nn.newNode(4);
        arr[1].next.next = nn.newNode(6);
        arr[1].next.next.next = nn.newNode(8);

        arr[2] = nn.newNode(0); //0-->9-->10-->11
        arr[2].next = nn.newNode(9);
        arr[2].next.next = nn.newNode(10);
        arr[2].next.next.next = nn.newNode(11);

        Node h = nn.mergeSortedLists(arr);
        nn.print(h);
    }
}

