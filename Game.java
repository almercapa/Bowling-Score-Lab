import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private ArrayList<Player> ps = new ArrayList<Player>();
    private int f;
   
    public Game() { 
        Scanner input = new Scanner(System.in);
        f = 0;
        while(true) { 
            System.out.print("Please enter a player name (exit when done): ");
            String n = input.next();
           
            if(n.toLowerCase().equals("exit")) {
                break;
            } else {
                Player p = new Player(n, 0);
                ps.add(p);
            }
        }
    }
   
    public void playGame() { 
        f = 0;
        while(f <= 10) { 
            f++; 
            for(int i = 0; i < ps.size(); i++) { 
                playFrame(i);
                System.out.print("\n\nCurrent Frame: " + f + "\n" + ps.get(i).getName() + ": " + ps.get(i).getScore() + "\n");
            }
        }
       
        for(int i = 0; i < 2; i++) { 
            for(int j = 0; j < ps.size(); j++) {
                if(ps.get(j).extraRound(f)) {
                    playFrame(j);
                }
            }
        }
    }
   
    public void playFrame(int pos) {
       
        Scanner input = new Scanner(System.in);
        System.out.print("Next Player: " + ps.get(pos).getName());
        System.out.print("\nPlease enter the first ball score: ");
        int r1 = input.nextInt();
        int r2 = 0; 
        if(r1 != 10) {
            System.out.print("Please enter the second ball score: ");
            r2 = input.nextInt();
        }
       
        ps.get(pos).scoreFrame(r1, r2, f);
       
    }
}
