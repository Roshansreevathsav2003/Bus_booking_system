import java.util.*;

class Bus {
    private int busNo;
    private String route;
    private int totalSeats = 40;
    private int bookedSeats = 0;

    public Bus(int busNo, String route) {
        this.busNo = busNo;
        this.route = route;
    }

    public int getBusNo() {
        return busNo;
    }

    public boolean bookSeat() {
        if (bookedSeats < totalSeats) {
            bookedSeats++;
            return true;
        }
        return false;
    }

    public void displayInfo() {
        System.out.println("Bus No: " + busNo + ", Route: " + route + ", Seats Available: " + (totalSeats - bookedSeats));
    }
}

class Ticket {
    private String passengerName;
    private int busNo;

    public Ticket(String passengerName, int busNo) {
        this.passengerName = passengerName;
        this.busNo = busNo;
    }

    public void showTicket() {
        System.out.println("Ticket Booked Successfully!");
        System.out.println("Passenger: " + passengerName + ", Bus No: " + busNo);
    }
}

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static List<Bus> buses = new ArrayList<>();
    private static List<Ticket> tickets = new ArrayList<>();

    public static void main(String[] args) {
        // Add sample buses
        buses.add(new Bus(101, "Tirupathi to kalluru,Price per person:150"));
        buses.add(new Bus(102, "Tirupathi to vijayawada,Price per person:500"));
        buses.add(new Bus(103, "Tirupathi to punganur,Price per person:100"));

        // Menu loop
        while (true) {
            System.out.println("\n--- Bus Ticket Booking ---");
            System.out.println("1. Show Available Buses");
            System.out.println("2. Book Ticket");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    showBuses();
                    break;
                case 2:
                    bookTicket();
                    break;
                case 3:
                    System.out.println("Thank you for using the Bus Booking System.");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void showBuses() {
        System.out.println("\nAvailable Buses:");
        for (Bus b : buses) {
            b.displayInfo();
        }
    }

    private static void bookTicket() {
        System.out.print("Enter Passenger Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Bus Number to Book: ");
        int busNumber = sc.nextInt();
        sc.nextLine(); // consume newline

        for (Bus b : buses) {
            if (b.getBusNo() == busNumber) {
                if (b.bookSeat()) {
                    Ticket t = new Ticket(name, busNumber);
                    tickets.add(t);
                    t.showTicket();
                } else {
                    System.out.println("Sorry, no seats available on this bus.");
                }
                return;
            }
        }
        System.out.println("Bus not found with number: " + busNumber);
    }
}