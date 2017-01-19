public class Library extends Room
{
            boolean hasItem = true;

    public Library(String n, String d, World p)
    {
       super(n,d,p);
    }
    
    public boolean enterRoom()
    {
        super.enterRoom();
        System.out.println("There is a dusty safe containing what looks like a container of some brittle food. Break the lock? ( Y or N )");
        Command c = new Command();
                    if(c.getFirstWord().equals("Y") || c.getFirstWord().equals("y"))
                    {
                        System.out.println("You broke the rusty lock with your foot");
                                pickUpItemAction();
                    }
                    else
                    {
                        System.out.println("You left the vault alone");
                    }

        return true;
    }
        
    
     public void pickUpItemAction()
            {
                if(!hasItem) return;
                System.out.println("There is an item in there. Do you wish to pick it up? (Y or N)");
                    Command c = new Command();
                    if(c.getFirstWord().equals("Y") || c.getFirstWord().equals("y"))
                    {
                        parent.getPlayer().pickUpItem(new RottenRations(parent));
                        hasItem = false;
                    }
                    else
                    {
                        System.out.println("You abandoned the item");
                    }
            }
}