/**
 * Created by misae on 1/25/2017.
 */
import java.util.Scanner;
import java.util.Date;

public class SeatReservations {

    // array of 10 seats, 5 aisle and 5 window.
    private static int[] seats = new int[10];

    public static void main(String args[]) {
        System.out.println("Hello! Welcome to the SeatReserve system.");
        System.out.println();


        // Sets all seats to 0.
        for (int i = 0; i < 10; i++) {
            seats[i] = 0;
        }

        // Scanner Setup and choice input.
        Scanner keyboard = new Scanner(System.in);
        int choices;

        // User input of seat choice.
        System.out.print("Please enter 1 for window, 2 for aisle, or 0 to exit: ");
        choices = keyboard.nextInt();


        // Executes only if beginning input isn't 0(exit).
        while (choices != 0) {
            int seatnumber = 0;


            // choice = window seat. try to reserve it.
            if (choices == 1) {
                seatnumber = windowReserve();


                // No window seats available. will ask if user wants aisle instead or to exit.
                if (seatnumber == -1) {
                    seatnumber = aisleReserve();

                    if (seatnumber != -1) {
                        System.out.println("Sorry, but there are not any window seats available. However, there are Aisle seats available would you like to reserve one?");
                        System.out.println("Yes or No?");

                        Scanner response = new Scanner(System.in);
                        String answerchoice = response.nextLine();
                        if(answerchoice.equalsIgnoreCase("Yes") || answerchoice.equalsIgnoreCase("Y")){
                            reserveTicket(seatnumber);
                        }
                        else if(answerchoice.equalsIgnoreCase("No") || answerchoice.equalsIgnoreCase("N")) {
                            System.out.println("Sorry for the inconvenience. Thank you for using the SeatReserve system. Now exiting...");
                            choices=0;

                        }
                    }
                }
                else {
                    // Reserves Window seat with no problems.
                    System.out.println("\n\n You have successfully reserved an window seat.");
                    reserveTicket(seatnumber);
                }
            }
            else if (choices == 2) {

                // choices == aisle. Reserve it.
                seatnumber = aisleReserve();

                // no Aisle seats available. try window seats.
                if (seatnumber == -1) {
                    seatnumber = windowReserve();

                    if (seatnumber != -1) {
                        System.out.println("Sorry, but there are not any Aisle seats available. However, there are Window seats available would you like to reserve one?");
                        System.out.println("Yes or No?");

                        Scanner response = new Scanner(System.in);
                        String answerchoice = response.nextLine();
                        if(answerchoice.equalsIgnoreCase("Yes") || answerchoice.equalsIgnoreCase("Y")){
                            reserveTicket(seatnumber);
                        }
                        else if(answerchoice.equalsIgnoreCase("No") || answerchoice.equalsIgnoreCase("N")) {
                            System.out.println("Sorry for the inconvenience. Thank you for using the SeatReserve system. Now exiting...");
                            choices=0;
                        }
                    }
                }
                else {
                    // books aisle seats with no problems.
                    System.out.println("\n\n you have successfully reserved an aisle seat.");
                    reserveTicket(seatnumber);
                }
            }
            else {
                // user made a number error when inputting choices.
                System.out.println("Invalid choice made. Please try again!");
                choices = 123;
            }


            // No Seats left.
            if (seatnumber == -1) {
                System.out.println("\n\n Apologies, no more seats are available.");
                System.out.println();
            }


            // will loop back to beginning if user decides to do so.
            if(choices == 0) {
                break;
            }
            else{
                System.out.print("Please enter 1 for window, 2 for aisle, or 0 to exit: ");
                choices = keyboard.nextInt();
            }

        }


    }


    // creates window seat number and checks if its full.
    private static int windowReserve() {
        for (int i = 0; i < 5; i++) {
            if (seats[i] == 0) {
                seats[i] = 1;
                return i + 1;
            }
        }
        return -1;
    }


    // creates aisle seat number and checks if its full.
    private static int aisleReserve() {
        for (int i = 5; i < 10; i++) {
            if (seats[i] == 0) {
                seats[i] = 1;
                return i + 1;
            }
        }
        return -1;

    }


    // useful information when reserving a seat. prints out when user reserves a seat.
    private static void reserveTicket(int seatnumber) {
        Date currenttime = new Date();
        System.out.println("\n");
        System.out.println("Date: " + currenttime.toString());
        System.out.println("Boarding pass for seat number: " + seatnumber);
        System.out.println("\n \n");
    }
}
