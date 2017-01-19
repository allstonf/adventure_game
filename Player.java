import java.util.ArrayList;


public class Player {

    private World myWorld;
    private Room currentRoom;
    private String myName = "";
    private item heldItem;
    
    public Player(World world) {
        myWorld = world;
    }
    
    public Player(String name, World world) {
        myName = name;
        myWorld = world;
    }

    public void setCurrentRoom(Room room) {
        currentRoom = room;
    }
    
    public Room getCurrentRoom() {
        return( currentRoom );
    }
    
    //////
    //////   Handle Commands
    //////
    
    public void dispatch(Command turn) {
        if (turn.isLookRoom()) {
            actionLookRoom();
            
        } else if (turn.isTravel(currentRoom)) {
            actionTravel(turn);

        } else if (turn.isUseItem())
        {
            useItem();
        }
        else if (turn.isInventory())
        {
            System.out.println(heldItem.description());   
        }
        
        else {
            System.out.println("Incorrect command. Please type another command.");
        }
    }


    
    public void actionTravel(Command turn) {
        String newDir = turn.getDirectionReference();
        Room newRoom = currentRoom.tryToExit(newDir);
        if (newRoom == null) {
            System.out.println("You can't go that direction from here.");
        } else {
            if (newRoom.enterRoom()) {
                setCurrentRoom(newRoom);
            } else {
                System.out.println("You can't go there.");
            }
        }
    }
    

    public void actionLookRoom() {
        currentRoom.printDescription();
    }
    
    public void pickUpItem(item i)
    {
        if(heldItem == null) {
        heldItem = i;
        System.out.println("You have picked up " + i.description());
    }
    else {
        heldItem = i;
        System.out.println("You have replaced your old item with " + i.description());
    }
    }
    
    public void useItem()
    {
        if(heldItem == null) {
            System.out.println("You are not holding an item");
            return;
        }
        heldItem.useItem();
        heldItem = null;
    }
    
    
    




}
