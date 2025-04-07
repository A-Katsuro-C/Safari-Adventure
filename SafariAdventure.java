import java.util.Scanner;
import java.util.Random;

public class SafariAdventure{
    public static void main(String[] args){
        //Variables
        Scanner input = new Scanner(System.in);
        Random event = new Random();
        int day = 0;
        int eventCounter;
        int eventId; 
        int points = 0;
        int pointsToday;
        String choice;
        String escapeInput;

        System.out.println("Welcome to the Safari Adevnture!\nPlease type out exactly how it is shown when prompted");

        //For Loop, Counts the current day of adventure
        for (int i = 0; i < 5; i++){
            pointsToday = 0;
            day = i + 1;
            eventCounter = 0;
            System.out.println("Day: " + day);

            //Do...While Loop, allows user to input which area to explore
            do {
                System.out.println("Which area would you like to explore: Jungle, River, Desert, Mountains");
                choice = input.nextLine();

                if (!(choice.equals("River") || choice.equals("Jungle") || choice.equals("Desert") || choice.equals("Mountains"))) {
                    System.out.print("This is an invalid area, Please choose again: ");
                }
            } while (!(choice.equals("River") || choice.equals("Jungle") || choice.equals("Desert") || choice.equals("Mountains")));
            
            System.out.println();

           //While Loop, Triggers the 3 events that happen during exploration
            while(eventCounter < 3){
                eventId = event.nextInt(5);
                System.out.print("Event:" + (eventCounter + 1) + " ");
                //Switch statement for specific events
                switch (eventId) {
                    case 0:
                        System.out.println("You discovered a hidden treasure!");
                        points += 20;
                        pointsToday += 20;
                        break;
                    case 1:
                        System.out.print("You found a wild animal! \nType RUN to escape: ");
                        escapeInput = input.nextLine();

                        if (escapeInput.equals("RUN")){
                            System.out.println("You've sucessfully escaped the animal, ending your day early.");
                        } else {
                            points -= 10;
                            pointsToday -= 10;
                            System.out.println("You got attacked, and lost " + pointsToday + " today.");
                        }
                        eventCounter = 3; //ends the day
                        break; 
                    case 2:
                        System.out.println("It started to rain heavily, you wait for it to clear.");
                        continue; //continue statement to allow another event
                    case 3:
                        System.out.println("You found an abandoned campsite!");
                        points += 10;
                        pointsToday += 10;
                        break; //break statements to end the event
                    default:
                        System.out.println("You got raided!");
                        points -= 5;
                        pointsToday -= 5;
                }
                eventCounter++;
            }

            //Points for the day
            System.out.println("You have: " + pointsToday + " points for today ");
            System.out.println();
        }

        
        //Ending Summary
        System.out.println("Safari Complete! You collected " + points + " points!");
        if (points >= 100){
            System.out.println("You survived and completed the adventure!");
        } else {
            System.out.println("You did not complete the adventure, game over!");
        }

        
        input.close();
    }
}
