import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO implements Data {
    @Override
    public ArrayList<Media> readFile(String fileName) {
        ArrayList<Media> data = new ArrayList<>();
        File file = new File(fileName);

        try {
            Scanner scan = new Scanner(file);
            scan.nextLine(); // skip header
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                String[] parts = line.split(";");
                String title = parts[0];
                String releaseDate = parts[1];
                ArrayList <String> genres = new ArrayList<>();
                String[] genreParts = parts[2].split(",");
                for (String genre: genreParts){
                    genres.add(genre);
                }
                String rating = parts[3];

                Media media = new Media(title, releaseDate, genres, rating);
                data.add(media);
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }
        return data;
    }

    /*
    public void movieData(ArrayList<Media> media){
    try{
        File file = new File("/Users/jeppekoch/Desktop/GitHub/SP3/SP3_Domain/src/100bedstefilm.txt");

    } catch (Exception e) {
        System.out.println("file not found");
    }
*/
    }

