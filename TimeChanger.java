import java.util.*;

public class TimeChanger extends item
{
    public TimeChanger(World p)
    {
        super(p);
    }
    
    public void useItem()
    {
        int limitNum = parent.getRooms().size();
        Random randGen = new Random();
        int randomValue = randGen.nextInt(limitNum);
        
        Room targetRoom = parent.getRooms().get(randomValue);
        
        System.out.println("The time changer is teleporting you to " + "'" + targetRoom.name + "'\n\n");
        if(targetRoom.enterRoom()) {
            
            parent.getPlayer().setCurrentRoom(targetRoom);
        }
        else {
            System.out.println("The time changer has failed due to an attempt to transport to an unaccessible room");
        }
        
    }
    
    public String description()
    {
        return "a man-made, lit-up trinket with a set of instructions: Use this device to transport to a different time and place";
    }
}