import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        User user = new User("John Doe");
        FileIO fileIO = new FileIO();
        ArrayList<Media> movieData = fileIO.readFile("src/100bedstefilm.txt");
        System.out.println(movieData);

    }