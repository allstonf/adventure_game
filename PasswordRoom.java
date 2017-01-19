public class PasswordRoom extends Room
{
        boolean hasItem = true;
         public PasswordRoom(String name, String desc, World p) {
                super(name,desc,p);
            }
            
            
            
            public boolean enterRoom()
            {
                super.enterRoom();
                System.out.println("Please enter the password to enter this room\nHint: What is the name of the tech company that is named after a fruit?");
                Command c = new Command();
                if(c.getFirstWord().equals("Apple") || c.getFirstWord().equals("apple"))
                {
                    System.out.println("Correct!\nYou have entered the room");
                    
                    pickUpItemAction();

                    return true;
                }
                else
                {
                    System.out.println("Wrong!");
                    return false;
                 }
            }
            
            public void pickUpItemAction()
            {
                if(!hasItem) return;
                System.out.println("There is an item on the ground. Do you wish to pick it up? (Y or N)");
                    Command c = new Command();
                    if(c.getFirstWord().equals("Y") || c.getFirstWord().equals("y"))
                    {
                        parent.getPlayer().pickUpItem(new TimeChanger(parent));
                        hasItem = false;
                    }
                    else
                    {
                        System.out.println("You abandoned the item");
                    }
            }
}