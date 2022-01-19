
/**
 * Write a description of class items here.
 *
 * @author (Haider Imam)
 */
public enum Items
{
   NONE("none"), DRINK("drink"), KEYS("keys") , BOOK("book") , VAPE("vape") , 
        JOHN("john");
    
    private String item;
    
      Items(String item)
    {
        this.item = item;
    }
    
    public String toString()
    {
        return item;
    }
}
