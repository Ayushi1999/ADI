import java.util.*;

public class TrieMap
{
    HashMap<Character,TrieMap> map;
    boolean EndOfWord;
    
    TrieMap()
    {
        map = new HashMap<>();
        EndOfWord = false;
    }

    TrieMap root;
    
    void insert(String str)
    {
        TrieMap curr = root;
        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            if(curr.map.get(ch) == null)
            {
                curr.map.put(ch,new TrieMap());
            }
            curr = curr.map.get(ch);
        }
        curr.EndOfWord = true;    
    }

    boolean search(String str)
    {
        TrieMap curr = root;
        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            if(curr.map.get(ch) == null)
            {
                return false;
            }
            curr = curr.map.get(ch);
        }
        return curr.EndOfWord;
    }

    boolean delete(TrieMap root,String str,int ind)
    {
        TrieMap curr = root;
        if(str.length() == ind)
        {
            if(curr.EndOfWord == true)
            {
                return false;
            }
            curr.EndOfWord = false;
            for(int i=0;i<26;i++)
            {
                char ch = str.charAt(i);
                if(curr.map.get(ch)!=null)
                {
                    return false;
                }
            }
            return true;
        }
        else
        {
            TrieMap temp = curr.map.get(ch);
            if(temp == null)
            {
                return false;
            }
            boolean x = delete(temp,str,ind+1);
            if(x)
            {
                map.put(str.charAt(ind),'\0');
                if(curr.EndOfWord == true)
                    return false;
                 for(int i=0;i<26;i++)
                 {
                     char ch = str.charAt(i);
                     if(curr.map.get(ch)!=null)
                     {
                         return false;
                     }
                 }
                 return true;
            }
        }
        return false;
    }

    public static void main(String args[])
    {
        TrieMap t = new TrieMap();
        t.root = new TrieMap();
        t.insert("hello");
        t.insert("hi");
        System.out.println(t.search("hitttt"));
        t.delete(t.root,"hi",ind);
    }
}
