import java.util.*;

public class ShortestUniquePrefix
{
    static class TrieNode
    {
        TrieNode[] arr = new TrieNode[26];
        boolean EndofWord;
        int freq;

        TrieNode()
        {
            for(int i=0;i<26;i++)
            {
                arr[i] = null;
            }
            EndofWord = false;
            freq = 1;
        }
    }
  
    TrieNode root;
  
    void insert(String str)
    {
        TrieNode curr = root;
        for(int i=0;i<str.length();i++)
        {
            int index = str.charAt(i)-'a';
            if(curr.arr[index] == null)
            {
                curr.arr[index] = new TrieNode();
            }
            else
            {
                curr.arr[index].freq++;
                curr = curr.arr[index];
            }
        }
    }
    
    private void check(TrieNode root,char[] prefix,int ind)
    {
        if(root == null)
            return;
        if(root.freq == 1)
        {
            prefix[ind] = '\0';
            int i = 0;
            while(prefix[i]!='\0')
            {
                System.out.print(prefix[i++]);
                System.out.print(" ");
                return;
            }
        }
            for(int i=0;i<26;i++)
            {
                if(root.arr[i]!=null)
                {
                    prefix[ind] = (char)i;
                    check(root.arr[i],prefix,ind+1);
                }
            }
    }
    
    public void check(String[] arr1)
    {
        root = new TrieNode();
        root.freq = 0;
        
        for(int i=0;i<arr1.length;i++)
        {
            insert(arr1[i]);  
        }
        
        int ind = 0;
        char[] prefix = new char[26];  //an array to store prefixes for each word.
        check(root,prefix,ind); 
    }
    
    public static void main(String args[])
    {
        ShortestUniquePrefix s = new ShortestUniquePrefix();
     /*   TrieNode t = new TrieNode();
        s.root = new TrieNode();
        s.root.freq = 0;
        s.insert("zebra");
        s.insert("dog");
        s.insert("duck");
        s.insert("dove");*/
        String[] arr1 = new String[]{"zebra","dog","duck","dove"};
        s.check(arr1);
    }
}

