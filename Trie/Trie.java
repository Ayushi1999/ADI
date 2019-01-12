import java.util.*;   //hashmap is an array of nodes

class Trienode {
    
    private boolean EndofWord;
    private Trienode[] arr = new Trienode[26];   //array of pointers for children nodes.
    Trienode()
    {
	for(int i=0;i<26;i++)
	{
	    arr[i] = null;
        }
	EndofWord = false;
    }

   Trienode root;
   
   void insert(String key) {
       Trienode curr = root;
       int len = key.length();
       int index;
       for(int i=0;i<len;i++) {
           
           index=key.charAt(i)-'a';
           
           if(curr.arr[index] == null) {
               curr.arr[index] = new Trienode();
           }
           curr=curr.arr[index];
       }
       curr.EndofWord = true;       
   }
  
   boolean search(String key) {
       
       int len = key.length();
       Trienode curr = root;
       int index;
  
       for(int i=0;i<len;i++) {
           index = key.charAt(i)-'a';
           if(curr.arr[index] == null) {
               return false;
           }
           curr = curr.arr[index];
       }
       return curr.EndofWord;
   }
   
   boolean delete(Trienode curr,String key,int index) {
     
     if(key.length() == index) 
     {
         if(curr.EndofWord == false)
         {
             return false;   //if word is not present
         }
         curr.EndofWord = false;  //if word is found then make its endofword = false.
         
         for(int i=0;i<26;i++)  //in case of "the" and "there"
         {
             if(curr.arr[i]!=null)
             {
                 return false;
             }
         }
         return true;
     } 
     else
     {
         int i = key.charAt(index)-'a';
         
         if(curr.arr[i] == null)
         {
             return false;
         }
         
         Trienode curr1 = curr.arr[i];
         boolean b = delete(curr1,key,index+1);
         
        //deletion of character begins. 
         if(b)
         {
             Trienode temp = curr.arr[i];  //picks the last char of there,removes it.
             curr.arr[i] = null;
             //free(temp);
             if(curr.EndofWord)   //curr points to what?
                 return false;
             else
             {
                 for(int p=0;p<26;p++)
                 {
                     if(curr.arr[p]!=null)
                         return false;
                 }
                 return true;
             }
         }
     }
     return false;
   }
  
       void display(Trienode root,char[] arr1,int level) {
       
       Trienode curr = root;
       if(curr.EndofWord == true)
       {
           arr1[level] = '\0';
           System.out.println(arr1);
       }
       for(int i=0;i<26;i++) {
           if(curr.arr[i]!=null) 
           {
               arr1[level] = (char)(i+'a');
               display(curr.arr[i],arr1,level+1);
           }
       }
   }
}

public class Trie
{ 
   // Trienode root;
    public static void main(String args[]) {
        
        String[] keys={"hello","hi","the","there"};
        Trienode t=new Trienode();
        t.root = new Trienode();
        for(int i=0;i<4;i++) {
            t.insert(keys[i]);
        }

       /* for(int i=0;i<4;i++) {
            t.display(keys[i]);
        }*/  

        if(t.search("the") == true)
            System.out.println("found");
        else
            System.out.println("not found");

        int index=0;
        t.delete(t.root,"ss",index);
 
        if(t.search("hello") == true)
            System.out.println("found");
        else
            System.out.println("not found");
        
        char str[] = new char[100];
        int l = 0;
        t.display(t.root,str,l);
    }
}
        
           
