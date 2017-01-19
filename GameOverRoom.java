

public class GameOverRoom extends Room
{
     public GameOverRoom(String name, String desc, World p) {
         super(name,desc,p);
        }
    public boolean enterRoom()
    {
        super.enterRoom();
        parent.gameOver();
        System.out.println("The room has filled with spikes and you got stabbed by the spikes.\nThanks for playing. Please try again to beat the game.");
        return true;
    }
    
}
