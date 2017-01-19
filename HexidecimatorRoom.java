import java.io.*;
import java.util.Scanner;

public class HexidecimatorRoom extends Room
{
    public HexidecimatorRoom(String n, String d, World p)
    {
        super(n,d,p);
    }
    
    public boolean enterRoom()
    {
        super.enterRoom();
        System.out.println("You encounter a giant monster made out of hexidecimals." + 
        "\nIt's giant, ugly, and nasty, but fortunately it's stupid, confused, and even has letters attached to it" + 
        "\nOn the ground you find a sword tucked in the corner. On its hilt, the word 'binary' is inscribed with" +
        "\none's and zero's under it." +
        "\nOn the other side of the hilt, you could barely manage to notice a few more words inscribed" + 
        "\n'Bin***', 'Base *', 'Ze**', 'On*', 'Digit** Electro*** Circu****', 'Long Car** Meth**'" +
        "\nYou can't make out the rest of the letters. You don't know what these words mean, but you know they will be of use soon" +
        "\nAs the Hexidecimator charges toward you, you decide to attack using the sword screaming ________!");
        
        System.out.println("Enter what you want to scream: ");
        
        Scanner rawInput = new Scanner(System.in);
        String Word = rawInput.nextLine();
        switch(Word)
        {
            case "Binary":
            case "Base 2":
            case "Zero":
            case "One":
            case "Digital Electronic Circuitry":
            case "Long Carry Method":
            {
                System.out.println("You slayed the Hexidecimator by exploiting its weakness. You win!");
            }
            break;
            default:
                System.out.println("Your missed your attack and you are murdered by the Hexidecimator");
        }
        parent.gameOver();
        return true;
    }

}