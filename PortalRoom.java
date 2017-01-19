import java.util.*;

public class PortalRoom extends Room
{
    public PortalRoom(String n, String d, World p)
    {
        super(n,d,p);
    }
    
    public boolean enterRoom() {
        super.enterRoom();
        System.out.println("Upon entering the room, reality and imagination seemed to blend, and you feel yourself\nmoving across space and time. It is both an exhilarating and terrifying experience");
        int limitNum = parent.getRooms().size();
        Random randGen = new Random();
        int randomValue = randGen.nextInt(limitNum);
        
        Room targetRoom = parent.getRooms().get(randomValue);
        
        System.out.println("You feel yourself moving closer to " + "'" + targetRoom.name + "'\n\n");
        
        if(targetRoom.enterRoom()) {
            
            parent.getPlayer().setCurrentRoom(targetRoom);
        }
        else {
            System.out.println("After a series of supernatural events, you find yourself located in the same room, ");
        }
        
        return true;
    }
}