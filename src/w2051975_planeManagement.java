import java.util.Scanner;

public class w2051975_planeManagement {

    public static void main(String[] args) {
        System.out.println("Welcome to Plane Management");
        boolean terminate = false;
        Scanner scanner = new Scanner(System.in);

        do {
            int choice = menu(scanner);
            switch (choice) {
                case 0:
                    terminate = true;
                    break;
                case 1:
                    buy_seat(scanner);
                    break;
                case 2:
                    cancel_seat(scanner);
                    break;
                case 3:
                    find_first_available();
                default:
                    System.out.println("Invalid option. Please select again.");
            }
        } while (!terminate);

        scanner.close();
    }

    static int menu(Scanner scanner) {
        System.out.println(
                "**************************************** \n" +
                        "*             MENU OPTIONS             * \n" +
                        "**************************************** \n" +
                        "\t 1) Buy a Seat\n" +
                        "\t 2) Cancel a Seat\n" +
                        "\t 3) Find first available\n" +
                        "\t 4) Show seating plan\n" +
                        "\t 5) Print tickets information and total sales\n" +
                        "\t 6) Search ticket\n" +
                        "\t 0) Quit\n" +
                        "**************************************** \n" +
                        "Please select an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if(choice <=6){
            return choice;
        }
        else{
            System.out.println("Enter a valid number...");
            return -1;
        }

    }

    static void buy_seat(Scanner scanner) {
        do {
            System.out.println("Enter the letter of row (A-D):");
            char rowNum = scanner.next().toUpperCase().charAt(0);
            int rowIndex = rowNum - 'A';

            if (rowIndex >= 0 && rowIndex < planeSeats.length) {
                System.out.println("Enter seat number : ");
                int seatNum = scanner.nextInt();

                if (seatNum >= 1 && seatNum <= planeSeats[rowIndex].length) { // Check if the seat number is valid
                    if (planeSeats[rowIndex][seatNum - 1] == 0) { // Check if the seat is available
                        planeSeats[rowIndex][seatNum - 1] = 1; // Mark the seat as booked
                        System.out.println("Seat " + rowNum + seatNum + " booked successfully.");
                    }

                    else {
                        System.out.println("Seat " + rowNum + seatNum + " is already booked.");
                    }
                }

                else {
                    System.out.println("Invalid seat number. Please enter a valid seat number.");
                }
            }

            else {
                System.out.println("Invalid row. Please enter a valid row letter...");
            }

            System.out.println("Do you want to book another seat? (Y/N):");
            char choice = scanner.next().charAt(0);
            if (choice != 'Y' && choice != 'y') {
                break;
            }
        } while (true);
    }

    public static int[][] planeSeats = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // Row A
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // Row B
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // Row C
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 , 0}};  // Row D

    static void cancel_seat (Scanner scanner){
        do{
            System.out.println("Enter the letter of row :");
            char rowNum = scanner.next().toUpperCase().charAt(0);
            int rowIndex = rowNum - 'A';
            if(rowIndex>=0 && rowIndex<=planeSeats.length){
                System.out.println("Enter the seat number :");
                int seatNum=scanner.nextInt();

                if(seatNum>0 && seatNum<=planeSeats.length){
                   if(planeSeats[rowIndex][seatNum-1]==1){
                       planeSeats[rowIndex][seatNum-1]=0;
                       System.out.println("Seat " + rowNum + seatNum + "canceled successfully.");
                   }
                   else {
                       System.out.println("Seat " + rowNum + seatNum + " is already available.");
                   }
                }
                else {
                    System.out.println("Invalid seat number. Enter a valid seat number...");
                }
            }
            else {
                System.out.println("Invalid row letter. Enter a valid row letter...");
            }
            System.out.println("Do you want to cancel another seat? (Y/N):");
            char choice = scanner.next().charAt(0);
            if (choice != 'Y' && choice != 'y') {
                break;
            }
        }while (true);
    }
    static void find_first_available() {
        boolean found = false;
        for (int i = 0; i < planeSeats.length; i++) {
            for (int j = 0; j < planeSeats[i].length; j++) {
                if (planeSeats[i][j] == 0) {
                    char rowLetter = (char) ('A' + i);
                    int seatNumber = j + 1;
                    System.out.println("First available seat: " + rowLetter + seatNumber);
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        if (!found) {
            System.out.println("No available seats.");
        }
    }

}


