import java.util.*;
public class Player
{
    ArrayList<Integer> t = new ArrayList<Integer>(); 
    private String n; 
    private int sc;
    private boolean sp;
    private boolean st;
    
    public Player(String n, int s) {
        t.add(-1);
        t.add(-1);
        t.add(-1);
       
        this.n = n;
        this.sc = s;
    }
   
    public int getScore() {
        return sc;
    }
   
    public String getName() {
        return n;
    }
   
    public boolean extraRound(int f) { 
        if((sp && (f == 10)) || (st && (f >= 9))) {
            return true;
        }
        return false;
    }
    public void scoreFrame(int r1, int r2, int f) {
       
        if(sp) { 
            sc += (10 + r1);
            sp = false;
        }
       
        if(r1 == 10) { 
            t.remove(0);
            t.add(10);
        }
       
        if(t.get(0) == 10) { 
            sc += (10 + t.get(1) + t.get(2));
        }
       
        if ((r1 + r2 == 10) && (r1 != 10)) { 
            sp = true;
            t.remove(0);
            t.remove(0);
            t.add(r1);
            t.add(r2);
        }
       
        if(r1 + r2 != 10) {
            t.remove(0);
            t.remove(0);
            t.add(r1);
            t.add(r2);
           
            sc += (r1 + r2);
        }
       
        if(t.get(1) == 10 || t.get(2) == 10) { 
            st = true;
        } else {
            st = false;
        }
       
    }
}
