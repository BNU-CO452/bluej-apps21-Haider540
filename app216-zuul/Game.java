/**
 *  This class is of the "findJohn" application. 
 *  "findJohn" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery.
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  locations, creates the CommandReader and starts the game.  
 * 
 * @author  Haider Imam
 */

public class Game 
{
    private Parser parser;
    
    private Room currentRoom;
    
    private Map map;
    
    private Player player;
    
    private boolean gameLost = false;
    
    private boolean gameWon = false; 
    
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        parser = new Parser();
        map = new Map();
        currentRoom = map.getStartRoom();
        player = new Player("John");
    }


    /**
     *  Main play routine.  Loops until end of play.
     *  each time the user enter a command which is executed 
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        
        while (! finished) 
        {
            Command command = parser.getCommand();
            finished = processCommand(command);
            //finished = (gameWon | gameLost);
        }
        
        
        System.out.println("Leaving already? Could'nt do the challenge? ");
        System.out.println("Thanks for Playing!");
    }

    /**
     * Print out the opening message for the player as well as explaining the 
     * rules.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul - find John Edition!");
        System.out.println("World of Zuul is a incredibly adventure game full of new things to discover.");
        System.out.println("Ground Rules! No cheating, no children and definitly no BNU students!");
        System.out.println("First to hit 100 points before their health gets to 0 wins!");
        System.out.println("john himself is fullpoints so if you find him and you will win");
        System.out.println("however there are particular items you will find which are worth points");
        
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) 
        {
            case UNKNOWN:
                System.out.println("I don't understand...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case QUIT:
                wantToQuit = true;
                break;
                
            case DROP:
                dropItem(command);
                break;
               
            case PICKUP:
                pickupItem(command);
                break;
                
        }
        return wantToQuit;
    }

    // implementations of user commands:
    private void pickupItem(Command command)
    
    {
        if(!command.hasSecondWord()) 
        {
            // if there is no second word, we don't know where to go...
            System.out.println("Which Item?");
            return;
        }
        
         String word = command.getSecondWord();
        Items item = convertFromString(word);
        
        //TO DO OTHER ITEMS 
        
        player.pickUpItem(item);
        currentRoom.removeItem();
        
        if(item == Items.KEYS)
            player.increaseScore(20);
        if(item == Items.BOOK)
            player.increaseScore(15);   
        if(item == Items.DRINK)
            player.increaseScore(25);
        if(item == Items.VAPE)
            player.increaseScore(5);
        
        
        if(item == Items.JOHN)
        {
            System.out.println("winner");
            player.increaseScore(100);
            gameWon = true;
        }
            
        
        player.showStatus();
        
    }
    
    /**
     * this turns the items as a string to an Item
     */
    
    private Items convertFromString(String word)
    {
        Items item = Items.NONE;
         if(word.equals("drink"))
        {
            item = Items.DRINK;
        }
        
        else  if(word.equals("book"))
        {
            item = Items.BOOK;
        }
        else  if(word.equals("vape"))
        {
            item = Items.VAPE;
        }
        else  if(word.equals("john"))
        {
            item = Items.JOHN;
        }
        else if(word.equals("keys"))
        {
            item = Items.KEYS;
        }
        return item;
    }
    
    /**
     * The player drops the item that is being carried.
     */
    private void dropItem(Command command)
    {
        if(!command.hasSecondWord()) 
        {
            // if there is no second word, we don't know where to go...
            System.out.println("Which Item?");
            return;
        }
        
        String word = command.getSecondWord();
        Items item = convertFromString(word);
        player.dropItem(item);
    }
    
    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You're lost. You're alone. wandering");
        System.out.println("around the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) 
        {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("no door!");
        }
        else 
        {
            //moveBorris();
            player.decreaseHealth();
            player.showStatus();
            
            if(!checkGameEnd())
            {
               currentRoom = nextRoom;
               System.out.println(currentRoom.getLongDescription());
            }
            
            }
        
        
    }

    /**
     * if the players health falls to 0 or below the game is over.
     */
    private boolean checkGameEnd()
    {
        if(player.getHealth() <=0 )
        {
            System.out.println("You have failed you have 0 health");
            gameLost = true;
            return true;
            
        }
        return false;
    }
    
    /**
     * John is moved each time the player goes into a room.
     */
    
    private void moveJohn()
    {
        if (player. getMoves() == 1 )
        {
            map.kitchen.setItem(Items.JOHN);
        }
        else if( player. getMoves() == 2 )
        {
            map.gym.setItem(Items.JOHN);
        }
    }
    
    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit");
            return true;
        }
        else {
            return false;  // signal that we want to quit
        }
    }
}