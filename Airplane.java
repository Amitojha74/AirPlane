import java.util.Scanner;

public class Airplane {
    static int seatFilled = 0;

    public static void main(String[] args) {
        // 2D array with 4 rows and 4 columns
        char[][] seats = new char[4][4];
        for (int i = 0; i < 4; i++) {
            seats[i][0] = 'A';
            seats[i][1] = 'B';
            seats[i][2] = 'C';
            seats[i][3] = 'D';
        }

        String seatNumber = " ";
        String q = " ";
        System.out.println("Welcome to the Airplane Seating Reservation System.");
        System.out.println("Please enter the seat (e.g.- 1A) you wish to reserve.");
        System.out.println("Enter q to exit.");
        Scanner userInput = new Scanner(System.in);
        seatNumber = userInput.nextLine();
        if (seatNumber.equals("q")) {
            System.out.println("Program ended.");
            System.exit(0);
        }
        while (seatFilled < 16 && seatNumber.length() > 0) {
            int row = seatNumber.charAt(0) - '1';
            int col = seatNumber.charAt(1) - 'A';
            if (row < 0 || row > 4 || col < 0 || col > 4) {
                System.out.println("Input error. Enter seat to assign (e.g., '1A')," + "or q to quit.");
                seatNumber = userInput.nextLine();
                if (seatNumber.equals("q")) {
                    System.out.println("Program ended.");
                    System.exit(0);
                }
            } else {
                if (seats[row][col] != 'X') {
                    seats[row][col] = 'X';
                    seatFilled++;
                    System.out.println(" ");
                    printSeats(seats);
                }
                if (seatFilled < 16) {
                    System.out.println("Enter seat to assign (e.g., '1A')," + "or q to quit.");
                    seatNumber = userInput.nextLine();
                    if (seatNumber.equals("q")) {
                        System.out.println("Program ended.");
                        System.exit(0);
                    }
                }
            }
        }
    }

    private static void printSeats(char[][] seats) {
        System.out.println("Row");
        for (int i = 0; i < seats.length; i++) {
            System.out
                    .println((i + 1) + "  " + seats[i][0] + " " + seats[i][1] +
                            "  " + seats[i][2] + " " + seats[i][3]);

        }
        int numberOfSeatsAvailable = (16 - seatFilled);
        System.out.println("There are " + numberOfSeatsAvailable + " seats available.");
    }
}
