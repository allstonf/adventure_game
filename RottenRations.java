public class RottenRations extends item
{
    public RottenRations(World p)
    {
        super(p);
    }
    
    public void useItem()
    {
        System.out.println("You opened the container and took a bite out of the rations. Unfortunately, the rations have been rotten and expired for a long time, so it is hard for you to swallow the rations. You die from choking");
        parent.gameOver();
    }
    
    public String description()
    {
        return "a plastic container filled with a strange food substance which you have never seen before. the food looks like rectangular wafers";
    }
}