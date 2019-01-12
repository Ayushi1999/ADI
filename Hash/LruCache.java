import java.util.*;  //set matrix 0

public class LruCache
{
    HashMap<Integer,Node>map = new HashMap<>(2);

    LruCache()
    {
       
    }

    public class Node
    {
        int val;
        int data;
        Node next;
        Node prev;
        Node head = NULL;
        Node(int data,int val,Node curr) 
        {
            curr.data = data;
            curr.val = val;
            curr.prev = NULL;
            curr.next = NULL;     
        }
    }

     /*   void set(int data,int val,Node prev_node)
        {
            Node curr1=new Node(data,val);
            curr1.next=prev_node.next;
            prev_node.next=curr1;
            curr1.prev=NULL;
            map.put(val,curr1);
        }  */
 
        void set(int data,int val)
        {
            Node node = new Node(data,val);
            node->next = head;
            node->prev = NULL;
            
            if(head!=NULL)
                head->prev = node;
           
            head = node;    
        }  
         
        void deleteAtPos(Node nn)
        {
            if(head == nn)    //if head node
                head = nn.next;
                   
            if(nn.next!=null)
                nn.next.prev = nn.prev;

            if(nn.prev
        }
        void get(int val)
        {
            if(!map.contains(val))
                System.out.println("-1");
            else
            {
               int x = map.get(val);
               System.out.println(x);
              
               deleteAtPos();
               //int y = map.remove(val);
               set(y,val,Node head);
            }
        }
    }
    public static void main(String args[])
    {
        LruCache l=new LruCache();
    //    HashMap<Node,val>map=new HashMap<>();   
        l.set(10,1);
        l.set(12,5);
        l.get(5);
        l.get(1);
        l.get(10);
        l.set(6,14);        
    }  
}
