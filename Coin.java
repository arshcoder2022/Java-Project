/*

   The Coin.java file defines the fields, as well as the constructor
   method that runs when an actual coin is created in a regular program (i.e. has a main method).
   
   Keep in mind that the Coin.java file never executes until a Coin object is created!
*/

import java.util.Random;  //We need to use a random number to decide if the coin is on heads or tails

public class Coin
{
   //The class name becomes the datatype to use in a program that creates Coin objects
   
   //Define the fields ("data") that represents a coin.
   private String sideUp;
   private double value;
   
   //Define methods that work on the data.  Start with the constructor method.
   //Remember!  Constructor methods have the same name as the Class and no return type!
   //It doesn't make sense to create a coin that has no value so we must take one in as a parameter.
   public Coin(double value_in)
   {
      value = value_in;
      
      //"Flip" the coin to set it to heads or tails
      flip();
   }
     
   public void flip()
   {
       //Generate a random number (0=heads, 1=tails) and set the sideUp field
       Random rand = new Random();
       if (rand.nextInt(2) == 0)
          sideUp = "heads";
       else
          sideUp = "tails";
   }
      
   public boolean headsUp()
   {
      boolean coinIsHeadsUp = false;
         
      if (sideUp.equals("heads"))
         coinIsHeadsUp = true;
            
      return coinIsHeadsUp;
   }
      
   public String getSideUp()
   {
      return sideUp;
   }
      
   //Normally there are get and set methods for all fields.
   //However, in this case we don't want the user to set 
   //the coin to heads or tails so this method isn't included.
   
   public double getValue()
   {
      return value;
   }
   
   public void setValue(double valueIn)
   {
      value = valueIn;
   }
}