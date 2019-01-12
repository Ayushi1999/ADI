
import java.util.*;

public class UpdateData implements Runnable {

    private Map<String,Integer> m=new HashMap<>();

    public UpdateData (Map<String,Integer> m) {   //object is runnable
        this.m = m;
    }

    public void run()
    {
     synchronized(m) {
        if(m.get("a") == null) {
            m.put("a",1);     //both threads if null will gets inserted and count musst be two.
        }
        else
        {
            int t=m.get("a");
            m.put("a",t++);
           // m.put("a",t+1);
        }
     }
    }
}
