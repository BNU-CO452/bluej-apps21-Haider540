
/**
 * This class represents the code, title and credit value of a
 * given module.
 *
 * @author Haider Imam
 * @version 13/10/2021
 */
public class Module
{
    // instance variables - replace the example below with your own
    private String code;
    private String title;
    private int credit;

    /**
     * Module constructor assigns the code and title for a module
     * It also initialises the credit value to 0
     */
    public Module(String code, String title)
    {
       this.code = code;
       this.title = title;
       this.credit = 0;
    }

    /**
     * This method returns the code for the module
     *
     * @return code represent the module code
     */
    public String getCode()
    {
          return code;
    }

    public String getTitle()
    {
          return title;
    }
    
        public int getCredit()
    {
          return credit;
    }
    
    public void setCredit(int credit)
    {
        this.credit= credit;
    }
    
    /**
     * print the details of the module which includes
     * the code, titles and credits
     */
    public void print()
    {
        printHeading();
        
        System.out.println(" Module Code: " + code + ": " + title);
        system.out.println(" Credit: " + credit);
        System.out.println();
    }
    
   
