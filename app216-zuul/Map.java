
/**
 * This class is reponsible for creating and
 * linking all the Locations in the game.
 *
 *  [gym]<---->[toilet]<---->[Theatre]
 *                 |
 *          [front desk]<---->[car park]
 *             
 * @Haider Imam
 * @version 2021-08-22
 */
public class Map
{
    public Room gym, frontdesk, theater, carpark, toilet, fireExit, prayerroom, kitchen, elevator, reception ;
    private Room startRoom;
    
    public Map()
    {
        createRooms();
    }
    
    /**
     * make all the rooms put their exits together.
     */
    private void createRooms()
    {
    
        // create the rooms
        gym = new Room("you are inside the university and at the gym, run on the treadmill!");
        frontdesk = new Room("you are at the front desk.");
        theater = new Room("in the theatre but the movie is finished");
        carpark = new Room("you are now at the carpark.");
        toilet = new Room("you are now in the toilet tubicle...");
        prayerroom= new Room("you are now in the prayerroom.");
        fireExit = new Room("you are now at the fire exit go back mate!");
        elevator = new Room("You are now in the elavator where you going? ");
        kitchen = new Room("You are now in the kitchen,Well done but not good enough");
        reception = new Room("You are at reception, they cannot answer any questions at this time...");
        
        
        setFrontdeskExits();
        
        reception.setExit("north", gym);
        reception.setExit("east", theater);
        reception.setExit("south", carpark);
        reception.setExit("west", toilet);
        
        kitchen.setExit("left", elevator);
        kitchen.setExit("right", gym);
        
        frontdesk.setExit("left", carpark);
        frontdesk.setExit("right", theater);
          
        gym.setExit("south", carpark);
        gym.setExit("fireExit", fireExit);
        
        fireExit.setExit("inside", gym);

        theater.setExit("west", reception);

        toilet.setExit("east", kitchen);

        prayerroom.setExit("north", theater);
        prayerroom.setExit("east", reception);
        
        frontdesk.setExit("left", gym);
        frontdesk.setExit("right", theater);
        
        carpark.setExit("outside", reception);
        carpark.setExit("press a button", elevator);
        
        

        elevator.setExit("west", reception);

        startRoom = frontdesk;  // start game outside
    }
    
    public void setFrontdeskExits()
    {  
        frontdesk.setExit("east", theater);
        frontdesk.setExit("south", frontdesk);
        frontdesk.setExit("west", carpark);
        frontdesk.setExit("north", gym);
        frontdesk.setExit("northEast", toilet);
        frontdesk.setExit("southEast", fireExit);
        frontdesk.setExit("southWest", kitchen);
        frontdesk.setExit("northWest", prayerroom);
       frontdesk.setExit("insideUni", reception);
    }
    
    public Room getStartRoom()
    {
        return startRoom;
    }
    
}