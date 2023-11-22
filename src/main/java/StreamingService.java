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
private List<Media> medias;
// Media media=new Media();
  private static ArrayList<Media> movieData = fileIO.readFile("/Users/mingo/Documents/GitHub/SP3/SP3NewVersion/src/main/java/100bedstefilm.txt");


    private static  String fileName = "/Users/mingo/Documents/GitHub/SP3/SP3NewVersion/src/main/java/user.txt";

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
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("1. see all movies");
            System.out.println("2. Pick a movie");
            System.out.println("3. Pick a series");
            System.out.println("4. Show watch list");
            System.out.println("5. Show saved media");
            System.out.println("6. logout");
            System.out.print("Choose an option: ");
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    for (Media movies: movieData) {
                        System.out.println(movies.toString());
                    }
                    break;
                case 2:
                    addMovieToList(scan,user);
                    break;
                case 3:

                    break;
                case 4:
                    System.out.println(user.watchList);

                    break;
                case 5:
                    System.out.println(user.saveMedia);
                    break;
                case 6:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. try again.");
            }
        }
    }
    public void playMovie(){
        System.out.println("current movie is playing "+ "");
    }

    public static String getInput(String msg) {
        Scanner scan = new Scanner(System.in);
        System.out.println(msg);
        String input = scan.nextLine();
        return input;
    }
    private static void addMovieToList(Scanner scanner, User user) {
        // Display available movies or get the selected movie from your data
        System.out.println("Select a movie to add to your list:");
        for (Media movie : movieData) {
            System.out.println(movie.getTitle()); // Assuming Media class has getTitle() method
        }

        System.out.print("Enter the title of the movie you want to add: ");
        String selectedMovieTitle = scanner.nextLine();

        // Find the selected movie from the data
        Media selectedMovie = findMovieByTitle(selectedMovieTitle);

        // Check if the movie is found
        if (selectedMovie != null) {
            // Prompt the user to choose which list to add the movie to
            System.out.println("Select a list to add the movie to:");
            System.out.println("1. Watch List");
            System.out.println("2. Saved Media List");
            System.out.print("Enter the number of the list: ");

            int listChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            // Add the movie to the selected list
            switch (listChoice) {
                case 1:
                    user.addMediaToWatchList(selectedMovie);
                    break;
                case 2:
                    user.saveMedia(selectedMovie);
                    System.out.println("Added '" + selectedMovie.getTitle() + "' to your saved media list.");
                    break;
                default:
                    System.out.println("Invalid choice. Movie not added to any list.");
            }
        } else {
            System.out.println("Movie not found.");
        }
    }


    private static Media findMovieByTitle(String title) {
        // Implement a method to find the movie by title in your movieData
        for (Media movie : movieData) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie;
            }
        }
        return null;
    }

}
