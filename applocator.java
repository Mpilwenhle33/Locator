import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Phone {
    private double latitude;
    private double longitude;

    public Phone(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}

public class PhoneTracker {
    private static Map<String, Phone> phoneMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Phone Tracker Menu:");
            System.out.println("1. Add Phone Location");
            System.out.println("2. Track Phone Location");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.next();
                    System.out.print("Enter latitude: ");
                    double latitude = scanner.nextDouble();
                    System.out.print("Enter longitude: ");
                    double longitude = scanner.nextDouble();
                    phoneMap.put(phoneNumber, new Phone(latitude, longitude));
                    System.out.println("Location added successfully!");
                    break;
                case 2:
                    System.out.print("Enter phone number to track: ");
                    String number = scanner.next();
                    Phone phone = phoneMap.get(number);
                    if (phone != null) {
                        System.out.println("Phone location - Latitude: " + phone.getLatitude() +
                                ", Longitude: " + phone.getLongitude());
                    } else {
                        System.out.println("Phone number not found!");
                    }
                    break;
                case 3:
                    System.out.println("Exiting Phone Tracker. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
