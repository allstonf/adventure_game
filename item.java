public abstract class  item
{
    protected World parent;
    boolean used;
    
    public item(World p)
    {
        parent = p;  
    }
    
    public abstract void useItem();
    
    public abstract String description();
}