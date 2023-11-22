import java.util.ArrayList;
public class Series extends Media{

    private String totalSeasons;
    private String totalEpisodes;

    public Series(String title, String releaseDate, ArrayList<String> genres, String rating, String totalSeasons) {
        super(title, releaseDate, genres, rating);
        this.totalSeasons = totalSeasons;
        this.totalEpisodes = totalEpisodes;
    }

    private String getTotalEpisodes(){
        return totalEpisodes;

    }

    private String getTotalSeasons() {
        return totalSeasons;
    }

    @Override
    public String toString() {
        return getTitle() + ", " + getReleasDate() + ", " + "categories: " + showCategories() +", Rating.  " + getRating()+totalSeasons+totalEpisodes;

    }
}

