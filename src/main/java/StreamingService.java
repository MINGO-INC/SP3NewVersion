import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StreamingService {
 private static FileIO fileIO = new FileIO();
// Media media=new Media();
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
                    displayAddToListMenu(scan);
                    break;
                case 3:
                    int addCategoryID = 1;
                    //Runs through our List of categories and gives them a number to choose from
                    for (Media s : movieData) {
                        System.out.println((addCategoryID + ": " + s));
                        addCategoryID++;
                    }
                    pickAMovie();
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
    private static void pickAMovie() {
        String input;
        boolean input1 = true;
        while (input1) {
            input = getInput("which movie would you like to Choose, use the numbers shown left of the move to pick.");
            if (input.equalsIgnoreCase("x")) {
                displayMenu();
                input1=false;
                return;
            }
            try {
                int selectedmovie = Integer.parseInt(input);
                if(selectedmovie >= 1 && selectedmovie <=1){

                }
               /* for (Media movie : movieData) {
                    if (movie.getNumber() == selectedmovie) {
                        System.out.println(("The following have been chosen: " + movie));
                       movieOption(movie);
                        input1 = true;
                        break;
                    }
                }*/
            } catch (NumberFormatException e) {
                System.out.println("invalid input");
            }
        }
    }
    public static void movieOption(Media m){
        System.out.println("");
        getInput("you now have 3 options: \n" +
                "1) Start movie \n" +
                "2) Add movie to saved list\n" +
                "3) Go back to main Menu.");
        boolean choice=true;
        while(choice){
            String input="";
            if(input.equals(1)){


            }
        }
    }
    public void playMovie(){
        System.out.println("current move is playing "+ "");
    }

    public static String getInput(String msg) {
        Scanner scan = new Scanner(System.in);
        System.out.println(msg);
        String input = scan.nextLine();
        return input;
    }
    private static User currentUser;

    private static void addToUserList(Media media, List<Media> list) {
        if (currentUser != null) {
            list.add(media);
            System.out.println("Added '" + media.getTitle() + "' to the list.");
        } else {
            System.out.println("User not logged in. Please log in to perform this action.");
        }
    }

    private static List<Media> loadAvailableMovies(String fileName) {
        FileIO fileIO = new FileIO();
        return fileIO.readFile(fileName);
    }

    private static void displayAddToListMenu(Scanner scanner) {
        System.out.println("Select a list to add the movie:");
        System.out.println("1. Watched List");
        System.out.println("2. Saved List");

        int choice = getIntegerInput(scanner, "Choose an option:");

        switch (choice) {
            case 1:
                addToUserList(getUserChoice(scanner, loadAvailableMovies(fileName)), currentUser.getWatchList());
                break;
            case 2:
                addToUserList(getUserChoice(scanner, loadAvailableMovies(fileName)), currentUser.getSaveMedia());
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static int getIntegerInput(Scanner scanner, String prompt) {
        System.out.print(prompt + " ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // Consume the invalid input
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        return input;
    }

    private static Media getUserChoice(Scanner scanner, List<Media> availableMovies) {
        System.out.println("Available movies: ");
        for (int i = 0; i < availableMovies.size(); i++) {
            System.out.println((i + 1) + ". " + availableMovies.get(i).getTitle());
        }

        System.out.print("Enter the number of the movie you want to add: ");
        int userChoiceIndex;

        try {
            userChoiceIndex = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // Consume the invalid input
            return getUserChoice(scanner, availableMovies);
        }

        int adjustedIndex = userChoiceIndex - 1;

        if (adjustedIndex >= 0 && adjustedIndex < availableMovies.size()) {
            return availableMovies.get(adjustedIndex);
        } else {
            System.out.println("Invalid choice. Please try again.");
            return getUserChoice(scanner, availableMovies);
        }
    }


}
