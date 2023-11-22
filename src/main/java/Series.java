import java.util.ArrayList;
public class Series extends Media{

    private int totalSeasons;
    private int totalEpisodes;

    private Series(String title, String releaseDate, ArrayList<String> genres, String rating, int totalSeasons, int totalEpisodes) {
        super(title, releaseDate, genres, rating);
        this.totalSeasons = totalSeasons;
        this.totalEpisodes = totalEpisodes;
    }

    private int getTotalEpisodes(){
        return totalEpisodes;

    }

    private int getTotalSeasons() {
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
                 ", totalEpisodes=" + totalEpisodes +
                '}';
    }
}

