import java.util.*;  //Interfaces-it sets protocol for derived classes,,,,no need not to remember the names of all derived classes.

class TrieNode
{
    TrieNode[] arr = new TrieNode[26];
    boolean EndofWord;

    TrieNode()
    {
        for(int i=0;i<26;i++)
        {
             arr[i] = null;
        }

        EndofWord=false;
    }

    TrieNode root;
    void insert(String arr)
    {
        TrieNode curr=root;
        for(int i=0;i<arr.length();i++)
        {
            int index=arr.charAt(i)-'a';
            if(curr.arr[index] == null)
            {
                curr.arr[index]=new TrieNode();
            }
            curr=curr.arr[index];
        }
        curr.EndofWord=true;
    }

    boolean search(TrieNode root,String str,int index)
    {
        if(index == str.length())
        {
            if(root.EndofWord)
            {
                return true;
            }
           return false;
        }
            int i=str.charAt(index)-'a';
            
            if(root.arr[i] == null)
                return false;
            TrieNode nn1=root.arr[i];
            return search(nn1,str,index+1);    
    }

   /* class Sol implements Comparator<Sol>
    {
        public int key,count1;
        Sol(int a,int b)
        {
            key=a;
            count1=b; 
        }
        public int compare(Sol a,Sol b)
        {
            return ((Integer)(a.count1)).compareTo((Integer)(b.count1));
        }
    }
    public static final Comparator<Sol> c=new Sol();*/
    
}
public class HotelReviews
{
     public static class Sol implements Comparator<Sol>
     {
        int key,count1;
        Sol()
        {
                  
        }
        Sol(int a,int b)
        {
            key=a;
            count1=b;
        }
        public int compare(Sol a,Sol b)
        {
            return -1*((Integer)(a.count1)).compareTo((Integer)(b.count1));
        }
      }
        
    public static void main(String args[])
    {
        TrieNode nn = new TrieNode();
        nn.root = new TrieNode();

        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        scan.next();
        String[] arr1=s.split("_");
        for(int i=0;i<arr1.length;i++)
        {
            nn.insert(arr1[i]);
        }

        String[] ap = new String[3];
        Scanner ss1 = new Scanner(System.in);
        
        for(int i=0;i<3;i++)
        {
            String str=scan.nextLine();
            ap[i]=str;
            scan.next();
        } 
       
        int index=0;
        int count=0,t=0;

        ArrayList<Sol> al=new ArrayList<Sol>();																																																							
        int k;
        for(int i=0;i<ap.length;i++)
        {
             String[] arr2=ap[i].split("_");
             count=0;  
             for(int j=0;j<arr2.length;j++)
             {
                 boolean x=nn.search(nn.root,arr2[j],0);
                 if(x == true)
                 {
                     count++;
                 }
             }
            //Sol res=new Sol(i,count);
            al.add(new Sol(i,count));
        }  
        
        Comparator<Sol> c=new Sol();
        Collections.sort(al,c);
  
       // ArrayList<Integer> aa=new ArrayList<Integer>();
        /*for(int i:al)
        {
            System.out.println(i);
        }*/
        ArrayList<Integer>at = new ArrayList<>();
        for(int i=0;i<al.size();i++)
        {
            at.add(al.get(i).key);
        }
        for(int i=0;i<at.size();i++)
        {  
            System.out.println(at.get(i));
        }
    }
}

