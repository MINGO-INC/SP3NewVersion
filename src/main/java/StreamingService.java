import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StreamingService {

    private static final String fileName = "/Users/mingo/Documents/GitHub/SP3/SP3NewVersion/src/main/java/user.txt";

    public void ConsoleLogin() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    register(scanner);
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (validateLogin(username, password)) {
            System.out.println("Login successful!");
            displayMenu();
        } else {
            System.out.println("Invalid username or password");
        }
    }
    private static void register(Scanner scanner) {
        System.out.print("Enter a new username: ");
        String username = scanner.nextLine();

        System.out.print("Enter a new password: ");
        String password = scanner.nextLine();

        // Save the registration information to a file (insecure for demo purposes)
        saveRegistration(username, password);

        System.out.println("Registration successful!");
    }

    private static boolean validateLogin(String username, String password) {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String storedUsername = parts[0];
                String storedPassword = parts[1];

                if (username.equals(storedUsername) && password.equals(storedPassword)) {
                    return true;
                }
            }
        } catch (IOException e) {
        }

        return false;
    }
    private static void saveRegistration(String username, String password) {
        // Save the registration information to a file (insecure for demo purposes)
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(username + "," + password + "\n");
        } catch (IOException e) {
        }
    }
    private static void displayMenu(){
        //todo lave de 3 options af alle film...
        Scanner scan=new Scanner(System.in);
        while (true) {
            System.out.println("1. watched List");
            System.out.println("2. Resume");
            System.out.println("3. Save move to list");
            System.out.print("Choose an option: ");
            int choice = scan.nextInt();


        }


}
