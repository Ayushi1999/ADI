import java.util.*;

class Bag implements Iterable<Integer>
{
    private class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node first;
    Node last;
 
    void enqueue(int data)
    {
        if(first == null)
        {
            first = new Node(data);
            last = first;
            return;
        }
        Node nn = new Node(data);
        nn.next = first;
        first = nn;
    }

    public Iterator<Integer> iterator() 
    {
        return new customIterator();
    }

    class customIterator implements Iterator<Integer>
    {
        Node curr = first;
        public boolean hasNext()
        {
            return curr == null?false:true;
        }
        public Integer next()
        {
            int data = curr.data;
            curr = curr.next;
            return (Integer)data;
        }
    }
}
