import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StreamingService {
 private static FileIO fileIO = new FileIO();
  private static ArrayList<Media> movieData = fileIO.readFile("/Users/mingo/Documents/GitHub/SP3/SP3NewVersion/src/main/java/100bedstefilm.txt");


    private static final String fileName = "/Users/mingo/Documents/GitHub/SP3/SP3NewVersion/src/main/java/user.txt";

    public void ConsoleLogin() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
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

    private static void displayMenu() {
        User user = new User("james");
        //todo lave de 3 options af alle film...
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("1. see all movies");
            System.out.println("2. Choose a Genre");
            System.out.println("3. Search for a movie");
            System.out.println("4. See personal list");
            System.out.println("5. see watched media");
            System.out.println("6. logout");
            System.out.print("Choose an option: ");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    for (Media movies: movieData) {
                        System.out.println(movies.toString());
                    }
                    break;
                case 2:
                    int addCategoryID = 1;
                    //Runs through our List of categories and gives them a number to choose from
                    for (Media s : movieData) {
                        System.out.println((addCategoryID + ": " + s));
                        addCategoryID++;
                    }
                    pickAmovie();
                    break;
                case 3:
                    System.exit(0);
                case 4:


                    break;
                case 5:

                    break;
                case 6:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }


        }
    }
    private static void pickAmovie() {
        String input;
        boolean input1 = false;
        while (!input1) {
            input = getInput("which movie would you like to Choose, use the numbers shown left of the move to pick.");
            if (input.equalsIgnoreCase("x")) {
                displayMenu();
                return;
            }
            try {
                int selectedId = Integer.parseInt(input);
                for (Media movie : movieData) {
                    if (movie.getNumber() == selectedId) {
                        System.out.println(("The following have been chosen: " + movie));
                       movieOption(movie);
                        input1 = true;
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("invalid input");
            }
        }
    }
    public static void movieOption(Media m){
        System.out.println("");
        getInput("you now have 3 options: \n1) Start movie \n2) Add movie to saved list\n3) Go back to main Menu.");
        boolean choice=true;
        while(choice){
            String input="";
            if(input.equals(1)){
                
            }
        }



    }

    public static String getInput(String msg) {
        Scanner scan = new Scanner(System.in);
        System.out.println(msg);
        String input = scan.nextLine();
        return input;
    }

}
