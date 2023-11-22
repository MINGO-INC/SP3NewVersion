import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        User user = new User("John Doe");
        FileIO fileIO = new FileIO();
        ArrayList<Media> movieData = fileIO.readFile("/Users/mingo/Documents/GitHub/SP3/SP3NewVersion/src/main/java/100bedstefilm.txt");
        // System.out.println(movieData);

        StreamingService streamingService=new StreamingService();
        streamingService.ConsoleLogin();
        System.out.println(user.watchList.get(0));

    }
}