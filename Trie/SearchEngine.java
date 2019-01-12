import java.util.*;


public class SearchEngine
{
    SearchEngine[] arr = new SearchEngine[26];;
    boolean EndOfWord;
    int weight;
    
    SearchEngine()
    {
        for(int i=0;i<26;i++)
        {
            arr[i] = null;
        }
        EndOfWord = false;
        weight = -1;
    }
    
    SearchEngine root;
    void insert(SearchEngine root,String str,int weight)
    {
        SearchEngine curr = root;
        for(int i=0;i<str.length();i++)
        {
            int index = str.charAt(i)-'a';
            if(curr.arr[index] == null)
            {
                curr.arr[index] = new SearchEngine();
            }
            curr = curr.arr[index];
            if(curr.weight < weight)
            {
                curr.weight = weight;
            }
        }
        curr.EndOfWord = true;
    }
    
    int search(SearchEngine root,String str,int i1)
    {
        SearchEngine curr = root;
        for(int i=0;i<str.length();i++)
        {
            int index = str.charAt(i)-'a';
            if(curr.arr[index] ==  null)
            {
                return -1;
            }
            else
            {
                curr = curr.arr[index];
            }
        }
        return curr.weight;
    }
    
    public static void main(String[] args)
    {
        SearchEngine t = new SearchEngine();
        t.root = new SearchEngine();
        Scanner sc = new Scanner(System.in);
        
        int inp = sc.nextInt();
        int que = sc.nextInt();
            
            while(inp!=0)
            {
             String s = sc.next();
             int weight = sc.nextInt();
             
             t.insert(t.root, s, weight);
             inp--;
            }
            
          while(que!=0)
          {
              String s = sc.next();
              System.out.println(t.search(t.root, s, 0));
              que--;
          }
    }
}
