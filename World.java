import java.util.*;
import java.io.*;
import java.lang.RuntimeException;


// The world contains the rooms, the player, and where the player is
public class World {

    private ArrayList<Room> rooms;
    private Player thePlayer;
    
    private boolean isPlaying;

    
    public static void main(String[] args) {
        World theWorld = new World();
        theWorld.play();
    }
    
    
    public ArrayList<Room> getRooms() {
        return rooms;
        }
        
        public Player getPlayer() {
            return thePlayer;
        }
    
    //////
    ////// Setup (populate the world)
    //////
    
    public World() {
        rooms = new ArrayList<Room>();
        thePlayer = new Player(this);
        
        //create and set up rooms
        Room livingRoom = new Room(
          "The living room" ,
          "You are in a dilapidated living room.  In the living room, you see a \n" +
          "large, ripped couch in the corner.  The floor boards creaked like crazy, \n" +
          "and the dust had settled, as if no one has entered the room for a while. \n",
          this
        );
        addRoom(livingRoom);
        
        Room hallway = new Room(
          "The hallway", 
          "You are in a hallway that connects to the kitchen and the living room.  The carpets are \n" +
          "torn, the paintings on the wall are shredded, leaving only the picture frames intact, and there are several \n" +
          "locked doors along its length.", this);
        addRoom(hallway);
        
        Room kitchen = new Room(
            "The kitchen", 
            "You stand in what appears to be a large, well used kitchen.  At one of the ends of the room is a \n" +
            "massive refrigerator with, possibly, some food to satisfy your hunger. \n"  +
            "A fruit bowl sits atop the fridge. Unfortunately, the fruit has spoiled, so you cannot eat the fruit.", this);
        addRoom(kitchen);
        
        Library l = new Library(
            "The Library",
            "You stand in the middle of a decrepit and abandoned library. A steel safe stands in the corner of the room isolated from the dozens of dusty bookcases",
            this);
        addRoom(l);
        
        Room gameRoom = new Room(
            "The game room", 
            "You are standing in a torn down game room, with several TV's and monitors \n" +
            "scattered on tables and the floor, multiple game consoles and computers, and many, many empty pizza boxes. There must have been one heck of a LAN party here", this
        );
        addRoom(gameRoom);
        
        GameOverRoom go = new GameOverRoom(
        "The Game Over Room",
        "You have entered the GameOverRoom. The name of the room says it all.",
        this);
        addRoom(go);
        
        PasswordRoom pr = new PasswordRoom(
        "The Password Room",
        "You are at the password room. As the name suggests, you will need to enter the correct password to enter.",
        this);
        addRoom(pr);
        
        PortalRoom portr = new PortalRoom(
        "The Portal Room",
        "You have entered a dark room with the only light emanating from several different technological devices and trinkets. You see what appears to be a portal in the middle of the room",
        this);
        addRoom(portr);
        
        HexidecimatorRoom hm = new HexidecimatorRoom(
        "The Hexidecimator Room",
        "You have entered a room with a hulking, demonic creature in the darkness. You can hear its baited breath and thunderous footsteps",
        this);
        addRoom(hm);
        
        //connect the rooms
        livingRoom.addExit(hallway, "north");
        hallway.addExit(livingRoom, "south");
        hallway.addExit(kitchen, "north");
        hallway.addExit(pr, "east");
        hallway.addExit(portr, "west");
        portr.addExit(hallway, "east");

        kitchen.addExit(hallway, "south");
        kitchen.addExit(gameRoom, "east");
        kitchen.addExit(l, "west");
        l.addExit(kitchen, "east");
        gameRoom.addExit(kitchen, "kitchen");
        gameRoom.addExit(go, "north");
        gameRoom.addExit(hm, "east");
        
        
        pr.addExit(hallway, "west");

        // set current position
        setCurrentRoom(livingRoom);
        
    }

    
    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Room getCurrentRoom() {
        return thePlayer.getCurrentRoom();
    }
    
    public void setCurrentRoom(Room room) {
        thePlayer.setCurrentRoom(room);
    }
 

    //////
    ////// Gameplay
    //////
        
    public void play() {
        
        isPlaying = true;
        printWelcome();
        
        // ... and start playing!
        while (isPlaying) {
            
            Command turn = new Command();    // read user input
            dispatch(turn);
        }
        
        //stopped
        printGameOver();
    }
    

    
    
    private void printWelcome() {
        System.out.println("Welcome to Adventure Game. ");
        System.out.println("Your goal is to find a way to get back home.");
        System.out.println();
        
        System.out.println(
             "After a long night out hanging out with friends, \n" +
             "you wake up in a strange room.  Maybe this really is a room in your house, \n" +
             "and you are just suffering from a hangover from partying so hard...  but \n" +
             "no matter how hard you try to 'wake up', you cannot, so this must be real life..."
        );
        System.out.println();
        getCurrentRoom().printDescription();
    }
    
    private void printGameOver() {
        System.out.println("Game Over");
    }
 
    
    // called by other objects (rooms, player) when they've decided the game should end.
    public void gameOver() {
        isPlaying = false;
    }
    
    
    
    /////
    ///// Handle commands
    /////
    
    // handle administrative commands, or dispatch to player to handle gameplay commands
    private void dispatch(Command turn) {     
        if (turn.isHelp()) {
            actionHelp();
        } else if (turn.isQuit()) {
            actionQuit();
        } else {
            thePlayer.dispatch(turn);
        }
    }
    
    
    
    
    private void actionHelp() {
        System.out.println("Try using simple verbs in order to do things. Only one or");
        System.out.println("two words will be recognized.");
        System.out.println();
        System.out.println("For example, type 'look' to look around, or 'north' to move to");
        System.out.println("the north. ");
        System.out.println("Or type 'use' to use items, like 'use fork'");
    }
    
    private void actionQuit() {
        gameOver();
    }
    
    
    
}  // end World class

