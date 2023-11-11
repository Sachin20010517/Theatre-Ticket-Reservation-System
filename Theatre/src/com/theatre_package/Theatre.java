package com.theatre_package;

import java.io.File;
import java.io.FileWriter;
import java.util.*;


public class Theatre {

    public static int global_row1_tickets_totalPrice=0;
    public static int global_row2_tickets_totalPrice=0;
    public static int global_row3_tickets_totalPrice=0;


    public static void main(String[] args) {

        //Initializes arrays to hold the number of seats in each row of a theatre.
        int[] row_1= new int[12];
        int[] row_2= new int[16];
        int[] row_3= new int[20];

        //This creates a new Scanner object to read user input and an array to store
        Scanner input=new Scanner(System.in);

        //create a new arraylist for task-12
        ArrayList ticket_array= new ArrayList<>();

        System.out.println("\n\n             Welcome to the New Theatre!!                 ");

        int option=1;
        while (option!=0){       // This sets up a loop that will continue until the user enters 0 as their option

            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("Please select an option");
            System.out.println("1) Buy a ticket");
            System.out.println("2) Print seating area");
            System.out.println("3) Cancel ticket");
            System.out.println("4) List available seats ");
            System.out.println("5) Save to file");
            System.out.println("6) Load from file");
            System.out.println("7) Print ticket information and total price");
            System.out.println("8) Sort tickets by price");
            System.out.println("    0) Quit");
            System.out.println("------------------------------------------------------------------------------------");


            System.out.print("\nPlease Enter Your Option : _ _ _ _ ");


            // This code uses a try-catch block to handle any exceptions that may occur when reading user input.
            try {
                option=input.nextInt();

                // If the user selects option 1, the program will call the buy_ticket() method to handle purchasing a ticket.
                if (option==1){
                    System.out.println("\n-----------------------------------------------------------------------------------");
                    System.out.println("                             BUY A TICKET                                        \n");

                    buy_ticket(row_1,row_2,row_3,ticket_array);
                }

                // If the user selects option 2, the program will call the print_seating_area() method to display the theatre's seating area.
                else if (option==2) {
                    System.out.println("\n-------------------------------------------------------------------------------------");
                    System.out.println("         PRINT SEATING AREA                                           ");

                    print_seating_area(row_1,row_2,row_3);
                }


                //If the user selects option 3, the program will call the cancel_ticket() method to handle cancelling a previously purchased ticket.
                else if (option==3) {
                    System.out.println("\n---------------------------------------------------------------------------------------");
                    System.out.println("                                CANCEL TICKET                              ");

                    cancel_ticket(row_1,row_2,row_3,ticket_array);
                }


                // If the user selects option 4, the program will call the show_available() method to display the available seats.
                else if (option==4) {
                    System.out.println("\n-------------------------------------------------------------------------");
                    System.out.println("                                AVAILABLE  SEATS                           ");

                    show_available(row_1,row_2,row_3);
                }


                // If the user selects option 4, the program will call the show_available() method to display the available seats.
                else if (option==5) {
                    System.out.println("\n-------------------------------------------------------------------------");
                    System.out.println("                              SAVE TO FILE                            ");

                    save(row_1,row_2,row_3);
                }


                // If the user selects option 6, the program will call the load() method to load a previous seating arrangement from a file.
                else if (option==6) {
                    System.out.println("\n-------------------------------------------------------------------------");
                    System.out.println("                         TO LOAD PREVIOUS PROGRAM                          ");

                    load(row_1,row_2,row_3);
                }


                // If the user selects option 7, the program will call the show_tickets_info() method to display information about the purchased tickets.
                else if (option==7) {
                    System.out.println("\n-------------------------------------------------------------------------");
                    System.out.println("                 SHOW TICKETS INFORMATION  & TOTAL PRICE                    ");

                    show_tickets_info(ticket_array);
                }


                // If the user selects option 8, the program will call the sort_tickets() method to sort the purchased tickets by price.
                else if (option==8) {
                    System.out.println("\n-------------------------------------------------------------------------");
                    System.out.println("                         SORT TICKETS BY PRICE                             ");

                    sort_tickets(ticket_array);
                }


                // If the user selects option 0, the program will exit the loop and display a message indicating that the program has been exited.(This option is used for only display a message indicating that the program has been exited)
                else if (option==0) {
                    System.out.println("\n    You exited from the program");
                }


                // If the user enters an invalid input, the program will display an error message indicating that the input is not valid.
                else {
                    System.out.println("Sorry!!, Unable to respond to your request.Please enter a number between  0-8 ");
                }


                // If the program encounters an exception, it will catch the exception and display an error message.
            }catch (Exception e){
                System.out.println("Please Enter Valid Integer Number");
                System.out.println("\nERROR name : "+e);
                String junk_1 =input.nextLine();    // If the program encounters an exception while using the Scanner object, it will consume and discard the invalid input to prevent an infinite loop.(junk_1 was set up to store invalid input.Otherwise,the expected result will not be given.)

            }                                                                //References = https://youtu.be/ceGnVDrMy1A
        }

    }


    // This method allows the user to buy a ticket by taking input from the user
    public static void buy_ticket (int[] row_1,int[] row_2,int[] row_3,ArrayList ticket_arraylist) {
        Scanner input = new Scanner(System.in);

        // Declare variables to store the row number, seat number, and ticket price.
        int row_nb;
        int seat_nb;
        int ticket_price = 0;  //This for ticket(task 10,11)

        String another_ticket = "yes";     // Declare a variable to determine if the user wants to buy another ticket.


        // Take input from the user to create a new Person object.
        System.out.print("Enter Your Name    : ");
        String name_ = input.next();
        System.out.print("Enter Your Surname : ");
        String surname_ = input.next();
        System.out.print("Enter Your Email   : ");
        String email_ = input.next();
        while (!email_.contains("@")) {      //This loop is used to ensure that the user inputs a valid email address.
            System.out.println("   --Please Enter Valid Email with @ symbol-- ");
            System.out.print("Enter Your Email   : ");
            email_ = input.next();
        }

        // Create a new Person object in relation to 'Person' class, using the input provided by the user.
        Person person_obj = new Person(name_, surname_, email_);           //making a new object for person class and proving data to input parameters

        do {            //This while loop is used to buy multiple tickets at once

            if (another_ticket.equals("yes")) {
                try {
                    System.out.println("     --There are 3 rows in the hall--\n");
                    System.out.print("Enter Row number :");
                    row_nb = input.nextInt();
                    if (row_nb >= 1 && row_nb <= 3) {     //checks if the row number entered by the user is between 1 and 3, which is the total number of rows in the hall
                        if (row_nb == 1) {    //when row number is 1

                            System.out.println("    --There are 12 seats in row " + row_nb + " . Please select any unreserved Seat--");
                            System.out.print("\nEnter Seat number :");
                            seat_nb = input.nextInt();

                            if (seat_nb >= 1 && seat_nb <= 12) {   //checks if the seat number entered by the user is between 1 and 12, which is the total number of seats in the  first row
                                if (row_1[(seat_nb) - 1] == 1) {       //If the seat number is valid, the code checks if the seat is already booked or not by checking the corresponding index of the seat in the row-1 array
                                    System.out.println("   Sorry!!. This seat already booked.Please select another seat.\n");

                                } else {
                                    row_1[(seat_nb) - 1] = 1;          //If the seat is available, the code sets the corresponding index of the seat in the row array to 1 to mark it as booked.
                                    System.out.print("   ** You booked seat number " + seat_nb + " of row 1  successfully!! **\n");
                                    global_row1_tickets_totalPrice+=10;   //I used this to count total price in task 13. Here every time a ticket is taken,the global_row1_tickets_totalPrice  is increase by ten


                                    //create a new object
                                    Ticket ticket_obj = new Ticket(row_nb, seat_nb, ticket_price, person_obj);
                                    ticket_obj.setPrice(10);    //set a price for row number 1 from calling setPrice.I used a first row ticket as £10
                                    ticket_obj.print();         //Accessing print() Method which made in Ticket class(task 10,11)

                                    //Adding data the Arraylist (ticket_arraylist)
                                    ticket_arraylist.add(ticket_obj.getRow());
                                    ticket_arraylist.add(person_obj.getName());
                                    ticket_arraylist.add(person_obj.getSurname());
                                    ticket_arraylist.add(person_obj.getEmail());
                                    ticket_arraylist.add(ticket_obj.getSeat());
                                    ticket_arraylist.add(ticket_obj.getPrice());
                                }

                            } else {
                                System.out.println("   --Invalid seat number.There aren't such kind of seat number in this row.Please try again!!\n");
                            }
                        }
                        // when row number is 2;

                        else if (row_nb == 2) {
                            System.out.println("    --There are 16 seats in row " + row_nb + "--");
                            System.out.print("\nEnter Seat number : ");
                            seat_nb = input.nextInt();

                            if (seat_nb >= 1 && seat_nb <= 16) {      //checks if the seat number entered by the user is between 1 and 16, which is the total number of seats in the  second row
                                if (row_2[(seat_nb) - 1] == 1) {      //If the seat number is valid, the code checks if the seat is already booked or not by checking the corresponding index of the seat in the row_2 array
                                    System.out.println("   Sorry!!. This seat already booked.Please select another seat.\n");

                                } else {
                                    row_2[(seat_nb) - 1] = 1;
                                    System.out.println("   ** You booked seat number " + seat_nb + " of row 2 successfully!!! ** ");

                                    global_row2_tickets_totalPrice+=20;    //I used this to count total price in task 13.Here every time a ticket is taken,the global_row2_tickets_totalPrice  is increase by twenty

                                    //create a new object
                                    Ticket ticket_obj = new Ticket(row_nb, seat_nb, ticket_price, person_obj);
                                    ticket_obj.setPrice(20);    //set a price for row number 1 from calling setPrice.I used a second row ticket as £20
                                    ticket_obj.print();      //Accessing print() Method which made in Ticket class(task 10,11)

                                    //Adding data the Arraylist (ticket_arraylist)
                                    ticket_arraylist.add(ticket_obj.getRow());
                                    ticket_arraylist.add(person_obj.getName());
                                    ticket_arraylist.add(person_obj.getSurname());
                                    ticket_arraylist.add(person_obj.getEmail());
                                    ticket_arraylist.add(ticket_obj.getSeat());
                                    ticket_arraylist.add(ticket_obj.getPrice());
                                }

                            } else {
                                System.out.println("   --Invalid seat number.There aren't such kind of seat number in this row.Please try again--\n");

                            }

                        }

                        else {      // User has entered a row number of 3
                            System.out.println("    -- There are 20 seats in row " + row_nb + "--\n");
                            System.out.print("Enter your Seat number :");
                            seat_nb = input.nextInt();

                            if (seat_nb >= 1 && seat_nb <= 20) {       //checks if the seat number entered by the user is between 1 and 20, which is the total number of seats in the  third row
                                if (row_3[(seat_nb) - 1] == 1) {     //If the seat number is valid, the code checks if the seat is already booked or not by checking the corresponding index of the seat in the row_3 array
                                    System.out.println("   Sorry!!. This seat already booked.Please select another seat.\n");

                                } else {
                                    row_3[(seat_nb) - 1] = 1;
                                    System.out.println("   ** You booked seat number " + seat_nb + " of row 3 successfully!!! **");

                                    global_row3_tickets_totalPrice+=40;  //I used this to count total price in task 13.Here every time a ticket is taken,the global_row3_tickets_totalPrice is increase by forty

                                    //create a new object
                                    Ticket ticket_obj = new Ticket(row_nb, seat_nb, ticket_price, person_obj);
                                    ticket_obj.setPrice(40);       //set a price for row number 1 from calling setPrice.I used a third row ticket as £40
                                    ticket_obj.print();         //Accessing print() Method which made in Ticket class(task 10,11)

                                    //Adding data the Arraylist (ticket_arraylist)
                                    ticket_arraylist.add(ticket_obj.getRow());
                                    ticket_arraylist.add(person_obj.getName());
                                    ticket_arraylist.add(person_obj.getSurname());
                                    ticket_arraylist.add(person_obj.getEmail());
                                    ticket_arraylist.add(ticket_obj.getSeat());
                                    ticket_arraylist.add(ticket_obj.getPrice());


                                }

                            } else {
                                System.out.println("   --Invalid seat number.There are not this such kind of seat number in this row.Please try again--\n");

                            }
                        }

                    } else {
                        System.out.println("   --Invalid row number.Please try again!! --\n ");
                    }


                } catch (InputMismatchException e) {    // If user enters invalid input,it will catch the exception and display prompt user to try again
                    System.out.println("\n                Please Enter valid Integer number\n ");
                    String junk_2 = input.next();          // junk_2 was set up to store invalid input.Otherwise,the expected result will not be given.If the program encounters an exception while using the Scanner object, it will consume and discard the invalid input to prevent an infinite loop.
                }

            }

            System.out.print("Do you want to buy another ticket?(yes/no) :");
            another_ticket = input.next();
            another_ticket = another_ticket.toLowerCase();   // I used toLowerCase method for convert upper case to the lower case,when user types in capital letters

            if (!(another_ticket.equals("yes") || another_ticket.equals("no"))) {
                System.out.println("    Please enter only 'yes' or 'no'\n ");
            }


        } while (!(another_ticket.equals("no")));     //The loop continues until the user enters "no" for the another_ticket variable

    }



    //A new method was built and named it 'print_seating_area'.The print_seating_area method is used to display the seating area of the hall
    public static void print_seating_area(int[] row1,int [] row2 , int[] row3){
        System.out.format("\n%24s","***********\n");           //System.out.format() is used to format and print text to the console
        System.out.format("%24s","*  STAGE  *\n");             // %24s - This means that the text will be padded with spaces on the left until it reaches a total width of 24 characters
        System.out.format("%25s","***********\n\n");           // %25s - This means that the text will be padded with spaces on the left until it reaches a total width of 25 characters

        System.out.format("%11s","");      // %11s - This means that the text will be padded with spaces on the left until it reaches a total width of 11 characters
        for (int i=0;i<row1.length;i++) {
            if (row1[i]==1){        // Check if the seat is booked
                System.out.print("X");     // Print X if the seat is booked
            }
            else {
                System.out.print("O");     // Print O if the seat is unbooked
            }
            if (i==(row1.length/2)-1){          //check if the seat is in the middle of the row
                System.out.print(" ");        // Add a space between the two halves of the row
            }
        }
        System.out.println();       // Add a new line after each row is printed


        System.out.format("%9s","");      // %11s - This means that the text will be padded with spaces on the left until it reaches a total width of 11 characters
        for (int j=0;j<row2.length;j++) {
            if (row2[j]==1){         // Check if the seat is booked
                System.out.print("X");    // Print X if the seat is booked
            }
            else {
                System.out.print("O");      // Print O if the seat is unbooked
            }
            if (j==(row2.length/2)-1){         //check if the seat is in the middle of the row
                System.out.print(" ");          // Add a space between the two halves of the row
            }
        }
        System.out.println();              // Add a new line after each row is printed


        System.out.format("%7s","");
        for (int z=0;z<row3.length;z++) {
            if (row3[z]==1){         //if anyone booked the seat
                System.out.print("X");     // Print X if the seat is booked
            }
            else {
                System.out.print("O");          // Print O if the seat is unbooked
            }
            if (z==(row3.length/2)-1){           //check if the seat is in the middle of the row
                System.out.print(" ");          // Add a space between the two halves of the row
            }
        }
        System.out.println();             //To break a line

                                                                   //References = https://www.javatpoint.com/java-string-format

    }



    //A new method was built and named it 'cancel_ticket'
    public static void cancel_ticket(int[] row1,int[] row2,int[] row3,ArrayList ticket_arraylist){
        int row__nb;     // Declare row_nb variable
        int seat__nb;  //Declare seat_nb variable
        String cancel_another="no";   // Declare and initialize variables
        String email=null;            // Declare and initialize variables


        // Enter a loop that allows the user to cancel multiple tickets
        while (true){
            Scanner input=new Scanner(System.in);
            if (cancel_another.equals("yes") || cancel_another.equals("no")){
                try {
                    if (cancel_another.equals("no")){
                        System.out.print("\nEnter the Email address you entered : ");        //to check if the entered email address matches the email address used to reserve the ticket.
                        email=input.nextLine();
                    }

                    System.out.print("\nEnter reserved row number : ");
                    row__nb= input.nextInt();
                    if (row__nb>=1&&row__nb<=3){        // If the row number is valid, ask user for the seat number to cancel
                        if (row__nb==1){
                            System.out.print("\nEnter reserved seat number :");
                            seat__nb= input.nextInt();

                            if (seat__nb>=0&&seat__nb<=12){
                                if (row1[(seat__nb)-1]==1){      //If the seat number is valid,check whether the seat related to the entered number is allotted or not


                                    //this for loop for remove details of cancel ticket ,when user enter correct email address
                                    for (int i=0;i<ticket_arraylist.size();i++){    //I used a for loop to iterate through the ArrayList of tickets and find the ticket associated with the user's input.

                                        if (Objects.equals(ticket_arraylist.get(i),row__nb) && Objects.equals(ticket_arraylist.get(i+4),seat__nb)){    //Checking that the user entered data(row nb,seat nb) matches the existing data in the arraylist
                                            if (Objects.equals(ticket_arraylist.get(i+3),email)){             //checking email address entered by the user,match the existing data in the arraylist
                                                row1[(seat__nb)-1]=0;     //This is for 1 convert to 0 (Because non-reserved seats are displayed by 0). Cancel the ticket by setting the corresponding element in the row array to 0
                                                System.out.println("   --You have cancelled seat number "+seat__nb+" of row "+row__nb+ " successfully!! --");

                                                global_row1_tickets_totalPrice-=10;       //I used this to count total price in task 13.Here every time a ticket is cancelled,the global_row1_tickets_totalPrice will decrease  by ten

                                                for (int j=0;j<6;j++){  //To remove the ticket details from arraylist associated with cancel seat
                                                    ticket_arraylist.remove(i);
                                                }
                                                break;    // Break out of the loop to return to the beginning of the while loop

                                            }else {      // If the email addresses do not match, display a warning message
                                                System.out.println("\n   WARNING!!!\nThat seat isn't reserved by the email address you entered.We can't cancel this seat!!!");
                                            }

                                        }
                                    }

                                }else {    // If the seat is not reserved, display a message indicating that the seat is invalid
                                    System.out.println("This seat is not reserved.Please Enter correct seat number & row number");
                                }
                            }else {       // If the seat number is invalid, display a message indicating that there is no seat related to that number
                                System.out.println("\nThere is no seat related to that number here ");
                            }


                        } else if (row__nb==2) {
                            System.out.print("\nEnter your reserved seat number :");
                            seat__nb= input.nextInt();
                            if (seat__nb>=0&&seat__nb<=16){
                                if (row2[(seat__nb)-1]==1){      //If the seat number is valid,check whether the seat related to the entered number is allotted or not

                                    //this for loop for remove details of cancel ticket ,when user enter correct email address
                                    for (int i=0;i<ticket_arraylist.size();i++){    //I used a for loop to iterate through the ArrayList of tickets and find the ticket associated with the user's input.

                                        if (Objects.equals(ticket_arraylist.get(i),row__nb) && Objects.equals(ticket_arraylist.get(i+4),seat__nb)){    //Checking that the user entered data(row nb,seat nb) matches the existing data in the arraylist
                                            if (Objects.equals(ticket_arraylist.get(i+3),email)){             //checking email address entered by the user,match the existing data in the arraylist
                                                row2[(seat__nb)-1]=0;    //This is for 1 convert to 0 (Because non-reserved seats are displayed by 0).Cancel the ticket by setting the corresponding element in the row array to 0
                                                System.out.println("   --You have cancelled seat number "+seat__nb+" of row "+row__nb+ " successfully !! --");

                                                global_row2_tickets_totalPrice-=20;     //I used this to count total price in task 13.Here every time a ticket is cancelled,the global_row1_tickets_totalPrice will decrease  by twenty

                                                for (int j=0;j<6;j++){     //To remove the ticket details from arraylist associated with cancel seat
                                                    ticket_arraylist.remove(i);
                                                }
                                                break;   // Break out of the loop to return to the beginning of the while loop

                                            }else {          // If the email addresses do not match, display a warning message
                                                System.out.println("\n   WARNING!!!\nThat seat isn't reserved by the email address you entered.We can't cancel this seat!!!");
                                            }
                                        }
                                    }

                                }else {          // If the seat is not reserved, display a message indicating that the seat is invalid
                                    System.out.println("\nThis seat is not reserved.Please Enter correct seat number & row number");
                                }

                            }else {          // If the seat number is invalid, display a message indicating that there is no seat related to that number
                                System.out.println("\nThere is no seat related to that number here ");
                            }

                        }

                        else {     // User has entered a row number of 3
                            System.out.print("\nEnter your reserved seat number :");
                            seat__nb= input.nextInt();
                            if (seat__nb>=0&&seat__nb<=20){     // Check if seat number is valid
                                if (row3[(seat__nb)-1]==1){      //If the seat number is valid,check whether the seat related to the entered number is allotted or not

                                    //this for loop for remove details of cancel ticket ,when user enter correct email address
                                    for (int i=0;i<ticket_arraylist.size();i++){        //I used a for loop to iterate through the ArrayList of tickets and find the ticket associated with the user's input.
                                        if (Objects.equals(ticket_arraylist.get(i),row__nb) && Objects.equals(ticket_arraylist.get(i+4),seat__nb)){    //Checking that the user entered data(row nb,seat nb) matches the existing data in the arraylist
                                            if (Objects.equals(ticket_arraylist.get(i+3),email)){             //checking email address entered by the user,match the existing data in the arraylist
                                                row3[(seat__nb)-1]=0;
                                                System.out.println("   --You have cancelled seat number "+seat__nb+" of row "+row__nb+ " successfully!! --");

                                                global_row3_tickets_totalPrice-=40;   //I used this to count total price in task 13.Here every time a ticket is cancelled,the global_row1_tickets_totalPrice will decrease  by forty

                                                for (int j=0;j<6;j++){         //To remove the ticket details from arraylist associated with cancel seat
                                                    ticket_arraylist.remove(i);
                                                }
                                                break;        //Exit the for loop to return to the beginning of the while loop

                                            }else {        // If the email addresses do not match, display a warning message
                                                System.out.println("\n   WARNING!!!\nThat seat isn't reserved by the email address you entered.We can't cancel this seat!!!");
                                            }


                                        }
                                    }

                                }else {        // If the seat is not allotted, display a message asking the user to enter the correct seat number and row number
                                    System.out.println("\nThis seat is not reserved.Please Enter correct seat number & row number");
                                }
                            }else {       // If the seat number is invalid, display a message indicating that there is no seat related to that number
                                System.out.println("\nThere is no seat related to that number here ");
                            }
                        }

                    }
                    else {              // If the row number entered by the user is invalid, display a message asking the user to enter a valid row number
                        System.out.println("\n--Please enter valid row number--");
                    }


                } catch (InputMismatchException e){
                    System.out.println("\n              Please Enter valid Integer number \n");
                    String junk_3= input.nextLine();   // junk_3 was set up to store invalid input.Otherwise,the expected result will not be given.
                }                                     //If the program encounters an exception while using the Scanner object, it will consume and discard the invalid input to prevent an infinite loop.

            }else {
                System.out.println("   ---Please enter only 'yes' or 'no'---");

            }
            System.out.print("\nDo you want cancel another ticket? (yes/no) :");
            cancel_another= input.next();
            cancel_another=cancel_another.toLowerCase();    // I used toLowerCase method for convert upper case to the lower case,when user types in capital letters
            if (cancel_another.equals("no")){
                break;   // Exit the loop if the user enters "no"
            }
        }
    }


    // A new method was built and named it "show_available".The purpose of this method is to display the available seats in rows
    public static void show_available(int[] row1,int[] row2,int[] row3){

        int comma_1=0;       //Initialize a variable to avoid a comma before the first item in an array.(This variable is used to avoid a comma before a row when printing show_available when allocated  the first item in an array)
        System.out.print("Seats available in row 1 : ");
        for (int i=0;i< row1.length;i++){       // Use a for loop to iterate through each element of the row1 array
            if (row1[i]==0){             // check if an element in the row1 array is equal to 0 (which means the seat is unreserved)
                if (i!=0 && comma_1==1){        // Check whether 'i' is not equal to 0 and comma_1 is equal to 1
                    System.out.print(", ");
                }
                System.out.print((i+1));    // Print the seat number (which is i+1 because the seat number starts from 1)
                comma_1=1;     // Set the comma_1 variable to 1 to indicate that a seat number has been printed
            }
        }
        System.out.println();             // Print a new line to move to the next line


        int comma_2=0;     //Initialize a variable to avoid a comma before the first item in an array.(This variable is used to avoid a comma before a row when printing show_available when allocated  the first item in an array)
        System.out.print("Seats available in row 2 : ");
        for (int j=0;j< row2.length;j++){          // Use a for loop to iterate through each element of the row2 array
            if (row2[j]==0){              // check if an element in the row2 array is equal to 0 (which means the seat is unreserved)
                if (j!=0 && comma_2==1){           // Check whether 'j' is not equal to 0 and comma_2 is equal to 1
                    System.out.print(", ");
                }
                System.out.print((j+1));            // Print the seat number (which is j+1 because the seat number starts from 1)
                comma_2=1;
            }
        }
        System.out.println();             // Print a new line to move to the next line


        int comma_3=0;    //This variable is used to avoid a comma before a row when printing show_available when allocated  the first item in an array
        System.out.print("Seats available in row 3 : ");
        for (int z=0;z<row3.length;z++){            // Use a for loop to iterate through each element of the row3 array
            if (row3[z]==0){                    // check if an element in the row3 array is equal to 0 (which means the seat is unreserved)
                if (z!=0 && comma_3==1){        // Check whether 'z' is not equal to 0 and comma_3 is equal to 1
                    System.out.print(", ");
                }
                System.out.print((z+1));       // Print the seat number (which is z+1 because the seat number starts from 1)
                comma_3=1;
            }
        }
        System.out.println();           // Print a new line to move to the next line

    }


    //A new method was built and named it "save"
    public static void save(int[] row1,int[] row2,int[] row3){
        try {
            FileWriter file_write=new FileWriter("new.txt");  //// Create a new FileWriter object and pass in the name of the file to be written to.

            for (int j : row1) {            //Loop through each seat in the first row
                if (j == 0) {             //If the seat is unreserved, write 0 to the file.
                    file_write.write("0");
                } else {                   //If the seat is reserved, write 1 to the file.
                    file_write.write("1");
                }
            }
            file_write.write("\n");      //After writing the first row to the file, write a newline character to the file.


            for (int j : row2) {            //Loop through each seat in the second row
                if (j == 0) {               //If the seat is unreserved, write 0 to the file.
                    file_write.write("0");
                } else {                   //If the seat is reserved, write 1 to the file
                    file_write.write("1");
                }
            }
            file_write.write("\n");         //After writing the first row to the file, write a newline character to the file


            for (int z : row3) {           //Loop through each seat in the third row
                if (z == 0) {               //If the seat is unreserved, write 0 to the file.
                    file_write.write("0");
                } else {                      //If the seat is reserved, write 1 to the file
                    file_write.write("1");
                }
            }
            file_write.write("\n");        //After writing the first row to the file, write a newline character to the file

            file_write.close();         // Close the FileWriter object to free up resources

        }catch (Exception e){         // Handle any IOException that may occur during the process of writing to the file.
            System.out.println(e);
        }

        System.out.println("\n    Successfully saved to the file");



    }


    //A new method was built and named  "load".The purpose of this method is to read data from a file named "new.txt" and load it into the three integer arrays.
    public static void load(int[] row1,int[] row2,int[] row3){

        System.out.println("\n  ---*** File is loading **---  ");
        try {
            int x=1;         // Initialize a counter variable x to 1
            File file_1=new File("new.txt");       //creates a new File object named file_1 that represents the file "new.txt" in the current working directory.
            Scanner reader=new Scanner(file_1);      //creates a new Scanner object named reader that reads data from the file represented by the file_1 object.

            while (reader.hasNextLine()){            // Loop through each line of the file
                String line=reader.nextLine();           // Read the next line of the file

                if (x==1){         // If x is equal to 1, load the data into the first row of the integer arrays
                    System.out.print("\nRow 1 : ");
                    for (int i=0;i<row1.length;i++){      // Loop through each element of the row1 array
                        row1[i]=Character.getNumericValue(line.charAt(i));        // Convert the character at index i of the line to an integer and store it in the row array
                        System.out.print(row1[i]+" ");     // Print the value of the element to the console
                    }
                    System.out.println();    // Print a new line character to separate the rows
                                                                                                           //References = https://www.tutorialspoint.com/java/lang/character_getnumericvalue.htm
                }

                if (x==2){            // If x is equal to 1, load the data into the second row of the integer arrays
                    System.out.print("Row 2 : ");
                    for (int i=0;i<row2.length;i++){         // Loop through each element of the row2 array
                        row2[i]=Character.getNumericValue(line.charAt(i));       // Convert the character at index i of the line to an integer and store it in the row array
                        System.out.print(row2[i]+" ");       // Print the value of the element to the console
                    }
                    System.out.println();        // Print a new line character to separate the rows
                }

                if (x==3){           // If x is equal to 1, load the data into the third row of the integer arrays
                    System.out.print("Row 3 : ");
                    for (int i=0;i<row3.length;i++){        // Loop through each element of the row3 array
                        row3[i]=Character.getNumericValue(line.charAt(i));    // Convert the character at index i of the line to an integer and store it in the row array
                        System.out.print(row3[i]+" ");        // Print the value of the element to the console
                    }
                    System.out.println();
                }
                x++;         // Increment the value of x for each line read from the file

            }
        }catch (Exception e){       // Catch any exceptions that might occur while reading the file
            System.out.println(e);
        }

    }



    //new method was build and named "show_tickets_info"
    public static void show_tickets_info(ArrayList ticket_arraylist){

        for (int i=0;i<ticket_arraylist.size();i+=6){
            System.out.println("\n*** Ticket ***");
            System.out.println("Name       : "+ticket_arraylist.get(i+1)+" "+ticket_arraylist.get(i+2));
            System.out.println("Email      : "+ticket_arraylist.get(i+3));
            System.out.println("row number : "+ticket_arraylist.get(i));
            System.out.println("Seat number: "+ticket_arraylist.get(i+4));
            System.out.println("Price      : £"+ticket_arraylist.get(i+5));
            System.out.println();

        }

        int total_prize=global_row1_tickets_totalPrice + global_row2_tickets_totalPrice + global_row3_tickets_totalPrice;
        System.out.println("Total Price :  £" + total_prize );
    }



    //New method was build and named "sort_tickets". This method sorts an ArrayList of tickets by price in ascending order.
    public static void sort_tickets(ArrayList ticket_arraylist){

        ArrayList tickets_sort = new ArrayList(ticket_arraylist);   // Create a copy of the input ArrayList and assign it to a new ArrayList(tickets_sort) variable.

        int lastIndex=tickets_sort.size()-2;       // Calculate the index of the second-to-last ticket in the ArrayList.

        boolean swap=true;    // Initialize the swap flag to true so the loop runs at least once

        while (swap){      //construct a while loop that executes when the swap is true
            swap=false;     // Set the swap flag to false before each pass through the loop

            for (int i=5;i<=lastIndex;i+=6){   // Enter a for loop that iterates over the ArrayList in increments of 6, starting at index 5.Because the getPrice is added to the arraylist at the fifth index
                ArrayList temp = new ArrayList();      // Create a temporary ArrayList to hold the six elements corresponding to one ticket.

                // Extract the ticket prices from the ArrayList and compare them.(Get the price of the current ticket and the price of the next ticket)
                int price_1= (int) tickets_sort.get(i);
                int price_2= (int) tickets_sort.get(i+6);

                // If the price of the current ticket is greater than the price of the next ticket, swap the six element
                if (price_1>price_2){

                    // Add the six elements of the current ticket being swapped to the temporary ArrayList
                    for (int j=(i-5);j<i+1;j++){
                        temp.add(tickets_sort.get(j));
                    }

                    // Shift the elements of next ticket to the left after the six being swapped to temp arraylist
                    for (int j=(i+1);j<=i+6;j++){
                        tickets_sort.set(j-6,tickets_sort.get(j));
                    }

                    // Replace the swapped elements of the current ticket with their new positions in the ticket_sort ArrayList from temp arraylist
                    int help=0;    //this variable is used to represent the index number of temp arraylist
                    for (int j=(i+1);j<=i+6;j++){
                        tickets_sort.set(j,temp.get(help));
                        help++;
                    }
                        swap=true;     // Indicate that a swap was made during this pass through the loop
                }
            }
            lastIndex-=6;      //Decrement the last index to avoid comparing elements that have already been swapped
        }

        for (int i=0;i<tickets_sort.size();i+=6) {
            System.out.println("\n*** Ticket ***");
            System.out.println("Name       : " + tickets_sort.get(i + 1) + " " + tickets_sort.get(i + 2));
            System.out.println("Email      : " + tickets_sort.get(i + 3));
            System.out.println("row number : " + tickets_sort.get(i));
            System.out.println("Seat number: " + tickets_sort.get(i + 4));
            System.out.println("Price      : £" + tickets_sort.get(i + 5));
            System.out.println();
        }
    }

}

