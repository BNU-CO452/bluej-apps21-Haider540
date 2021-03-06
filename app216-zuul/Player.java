
import java.util.ArrayList;

/**
 * Write a description of class player here.
 *
 * @author (Haider Imam)
 */
public class Player
{
    private String name; 
    private int score;
    private int health; 
    private ArrayList <Items> items; 
    private int moves;
    
    public Player(String name)
    {
        this.name = name; 
        score = 0;
        health = 100;
        items = new ArrayList <Items> ();
        
    }
    
    public void showStatus()
    {
        System.out.println("Player Status for " + name);
        System.out.println("health =  " + health);
        System.out.println("score =  " + score );
        System.out.println("move number = " + moves );
        System.out.println("");
        
    }
    
    public void pickUpItem(Items item)
    {
        items.add(item);
    }
    
    public int getMoves()
    {
        return moves;
    }
    
    public void dropItem(Items item)
    {
        items.remove(item);
    }
    
    public void decreaseHealth()
    {
        health = health -7;
        moves ++;
        score ++;
        }
    
    public int getHealth()
    {
        return health;
    }
      
    public void increaseScore(int amount)
    {
        score = score + amount;
    }
    
}