package LAQ5;

import java.util.*;

public class AirplaneBoarding {
    private Queue<Passenger> boardingQueue;
    private Stack<Passenger> disembark;
    private Set<String> occupiedSeats;
    public AirplaneBoarding() {
        boardingQueue = new LinkedList<>();
        disembark = new Stack<>();
        occupiedSeats = new HashSet<>();
    }
    public void boardPassenger(String name, String seatNumber) {
        if (occupiedSeats.contains(seatNumber)) {
            System.out.println("Error: Seat " + seatNumber + " is already occupied. Please choose another seat.");
        } else {
            Passenger passenger = new Passenger(name, seatNumber);
            boardingQueue.add(passenger);
            occupiedSeats.add(seatNumber);
            System.out.println(passenger + "has been added to boarding queue");
        }
    }

    public void boardingQueue() {
        System.out.println("Boarding Passenger List: ");
        while (!boardingQueue.isEmpty()) {
            Passenger passenger = boardingQueue.poll();
            disembark.push(passenger);
            System.out.println(passenger + " has boarded the plane");
        }
    }
    public void disembark() {
        while (!disembark.isEmpty()) {
            Passenger passenger = disembark.pop();
            System.out.println(passenger + " has been disembarked");
        }
    }

    public static void main(String[] args) {
        AirplaneBoarding app = new AirplaneBoarding();
        Scanner scanner = new Scanner(System.in);
        boolean continueApp = true;

        System.out.println("Welcome to Airplane Boarding");

        while (continueApp) {
            System.out.println("\nOptions");
            System.out.println("1. Add a passenger to the boarding queue");
            System.out.println("2. Board all passengers");
            System.out.println("3. Disembark all passengers");
            System.out.println("4. Exit");

            System.out.println("Choose an option 1 to 4: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.next();
            }
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter passenger name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter seat number: ");
                    String seatNumber = scanner.nextLine();
                    app.boardPassenger(name, seatNumber);
                    break;
                case 2:
                    app.boardingQueue();
                    break;
                case 3:
                    app.disembark();
                    break;
                case 4:
                    continueApp = false;
                    System.out.println("Thank you for Boarding with us today");
                    break;
                default:
                    System.out.println("Invalid input. Please try again");
            }
        }
    }

}
