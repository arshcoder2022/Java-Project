/*This program demostrates a Travel Helper app. It helps users decide where they would
 like to travel. They will have the option to search based on location, region, and price.

Name: Arshiya Dharwadkar
Course: CMP 128
Project: Final Project
Date: 12/18/2022
*/


//Importing libraries to read user input and generate random numbers
import java.util.Scanner;
import java.util.Random;

public class TravelHelper  //Class header

{

   public static void main(String [] args) //Method header
   
   {
                
         String[] city = {"New York", "Miami", "LA", "Kansas", "Chicago", "San Fran", "DC"}; //Declare String array city and assign values
         String[] region  = {"Northeast", "Southeast", "West", "Midwest", "Midwest", "West", "Northeast"};//Declare String array region and assign values
         double[] price  = {1500, 750, 1600, 600, 900, 1500, 1350}; //Declare Double array price and assign values
         
                 
         Scanner keyboard = new Scanner(System.in); //Scanner object to read input.

         int choice = 1; //Declare variables

         // Loop to test user choice       
         while (choice!= 5)
         
         {
         
            choice = displayMenu(); //call to displayMenu()

                                 
            if (choice == 1) // if user chose 1 
    
                 addLocation(city, region, price); //call addLocation method
         
            else if (choice == 2) // if user chose 2
        
                  searchRegion(city, region, price);//call searchRegion method
                 
            else if (choice == 3)// if user chose 3
         
                  searchPrice(city, region, price);//call searchPrice method
                      
            else if (choice == 4) // if user chose 4        
                 supriseChoice(city, region, price);//call searchRegion method
  
            
            else if (choice == 5 )// if user chose 4
            {
                  System.out.print("You chose to end the program. Thank you for using the Travel Helper App!");
                  break; //end program
            } 
      }   

   }//end of main
   
     public static int displayMenu() //Method to display the main menu
     {
      
         Scanner keyboard = new Scanner(System.in);//Scanner object to read input.

         int choice; //declare variable
         
         //Display menu to user
         System.out.println("Welcome to the Travel Helper App!");
         System.out.println("Choose an option from the below menu: ");
         System.out.println("1. Add Travel Locations (Administrator Only)");
         System.out.println("2. Search by: Region");
         System.out.println("3. Search by: Price");
         System.out.println("4. Suprise Me!");
         System.out.println("5. Exit");

         //read user input
         choice = keyboard.nextInt();
         return choice;  
      
      }
      
      public static void addLocation(String[] city, String[] region, double[] price)// addLocation method to add user input to the arrays
      {
         String code = "Plans@2022"; //Set unique password
         String password; //Declare variables
         int numOfLocations;
         
         Scanner keyboard = new Scanner(System.in); //Scanner object to read input.
         
         System.out.println("Enter the Administrator Password: "); //Prompt user to enter password
         password = keyboard.nextLine(); //Read password
         
         if (password.equals(code)) //Test password
         {
               System.out.println("How many locations do you want to store in the application: ");//Prompt to user to enter number of locations
               numOfLocations = keyboard.nextInt();//Read input
               keyboard.nextLine();//clear buffer
               
                //System.out.println("You entered: " + numOfLocations);
               
               for ( int index = 0; index < numOfLocations; index++)//Loop to read user input
               {
                        System.out.println("Enter the name of a city " + (index + 1) +  ": ");//Prompt to user to enter city
                        city[index] = keyboard.nextLine(); //read input
                       // keyboard.nextLine();//clear buffer 
                        
                        System.out.println("Enter the name of a region " + (index + 1) +  ": ");//Prompt to user to enter region
                        region[index] = keyboard.nextLine();//read input
  
                        System.out.println("Enter the price " + (index + 1) +  ": ");//Prompt to user to enter region

                        price[index] = keyboard.nextDouble();//read input
                        keyboard.nextLine();
                        
                        System.out.println("You added the below location: " + city[index] + " " +  region[index] + " $" + price[index]); //Print the entered city, region and price from the arrays
               }
                                   
         }    
                  
              else 
              {
                       System.out.println("You cannot add a Location since you are not an Administrator! "); //Prompt to user that they cannot add a location is password is incorrect
              } 
             
           //  displayMenu();//Call to display menu 
     }


      
         
     public static void searchRegion(String[] city, String[] region, double[] price)// searchRegion method to let user search the array by entering a region name 
      
      {
      
         boolean matchFound = false; //set boolean flag to false
         String choice; //declare variable
                  
         Scanner keyboard = new Scanner(System.in);//Scanner object to read input.
         
         System.out.println("Enter the region you would like to choose: ");//prompt to user to enter region name
         choice = keyboard.nextLine(); //read input
         
         System.out.println("You searched for " + choice + ": " );
         
         for (int index = 0; index < region.length; index++) //looping through the region array          
         {             
            if((region[index].equalsIgnoreCase(choice))) //test to search if user entered value is found in the array region  
            {    
                 
                 System.out.printf(city[index] + " " + region[index]  +  " "  + "$" + "%.2f\n\n", price[index]);//if found print the values from the arrays
                 matchFound = true;      //boolean flag is now set to true    
            }                     
        }
       
       if ((!matchFound))     //if matchFound = false  
         {
            System.out.printf("You searched for " + choice + ": " );

            System.out.println("No match for " + choice); //prompt user that choice not found
         }   
       
      // displayMenu();//call to displayMenu method
               
    }

   public static void searchPrice(String[] city, String[] region, double[] price)// searchPrice method to let user search the array by entering a region name 
   
   {
         Scanner keyboard = new Scanner(System.in);//Scanner object to read input.
         
         boolean matchFound = false;//set boolean flag to false
         double myPrice;//declare variable

         System.out.println("Enter the price you would like to choose:  ");//prompt to user to enter price value
         myPrice = keyboard.nextDouble();//read input
         keyboard.nextLine();
         
         System.out.println("You searched for locations under " + myPrice + ": " );

         for (int index = 0; index < price.length; index++)//looping through the price array 
         {             
            if((price[index] <= myPrice))   //test to search if user entered value is found in the price array     
            
             {

                 System.out.printf(city[index] + " " + region[index]  +  " "  + "$" + "%.2f\n", price[index]);//if found print the values from the arrays
                 matchFound = true;  //boolean flag is now set to true               
             }
                            
        }
       
       if ((!matchFound)) //if matchFound = false
        
       {       
         System.out.println("No match for " + myPrice);//prompt user that choice not found 
       }  
       
     // displayMenu();//call to displayMenu method
 
        
   }
      
      public static void supriseChoice(String[] city, String[] region, double[] price) //supriseChoice method with the city, region and price arrays passed to it
      {
            //Declare variables
            int newCity, newValue;
            int heads = 0;
            int tails = 0;
            int index = 0;
            
            //Generate random number
            Random rand = new Random();

            //Declare coin value 
            Coin quarter = new Coin(.25);
                  
            quarter.flip();  //Call flip method from blueprint file  
             
             //Now find out if its heads up or not           
              System.out.println(quarter.getSideUp());
               
              if (quarter.headsUp())//.equals("Heads")) //If Heads
              {                     
                 // newCity = rand.nextInt(6)+ 1; //Generate random number 
                  
                  newValue = rand.nextInt(city.length);
                  
                 // String supriseCity = String.valueOf(newCity); //convert int newCity value to String supriseCity
                          
                 // city[index] =   supriseCity; //Assign value to city array index
                  
                 System.out.printf("Suprises Choices: " + city[newValue] + " " + region[newValue]  +  " "  + "$" + "%.2f\n", price[newValue]);//Print values from the arrays
 
               }
               
              //if Tails  
                  
              else
              {    
                                               
                  for(index = 0; index < 3; index++) //Loops 3 times to print 3 suprise choices
                  {
                    // newCity = rand.nextInt(6)+ 1; //generate a random number
                     
                    // String supriseCity = String.valueOf(newCity);//convert int newCity value to String supriseCity
 
                     //city[index] = supriseCity; //Assign value to city array index
                     
                     newValue = rand.nextInt(city.length);

                                     
                     System.out.printf("Suprises Choices: " + city[newValue] + " " + region[newValue]  +  " "  + "$" + "%.2f\n", price[newValue]);//Print values from the arrays
                   }
                     
                   //  displayMenu();//Call to display menu
              }
  
      } 


}