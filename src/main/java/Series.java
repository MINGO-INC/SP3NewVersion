import java.util.ArrayList;
public class Series extends Media{

    private int totalSeasons;

    public Series(String title, String releaseDate, ArrayList<String> genres, String rating, int totalSeasons) {
        super(title, releaseDate, genres, rating);
        this.totalSeasons = totalSeasons;
    }

    public int getTotalSeasons() {
        return totalSeasons;
    }

    @Override
    public String toString() {
        return "Series{" +
                "title='" + getTitle() + '\'' +
                ", genres=" + showCategories() +
                ", releaseDate='" + getReleasDate() + '\'' +
                ", rating=" + getRating() +
                ", totalSeasons=" + totalSeasons +
                '}';
    }
}

