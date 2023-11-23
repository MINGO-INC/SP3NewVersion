import java.util.ArrayList;
import java.util.List;

public class User {
private String name;

//  recentlyViewed laves senere
    ArrayList <Media> watchList;
    ArrayList <Media> saveMedia;
    ArrayList <Media> allMedia;

    public void addMedia(Media media){
    watchList.add(media);
    }

    public void saveMedia(Media media){
        saveMedia.add(media);

    }
    public void removeMedia(Media media){
    watchList.add(media);
    saveMedia.add(media);
    }

    public User(String name) {
        this.name = name;
        this.watchList = new ArrayList<>();
        this.saveMedia = new ArrayList<>();
        this.allMedia = new ArrayList<>();

    }

    public String getName(){
        return name;

    }
    public ArrayList<Media> getWatchList() {
        return watchList;
    }
    public ArrayList<Media> getSaveMedia() {
        return saveMedia;
    }

    public ArrayList<Media> getAllMedia() {
        return allMedia;
    }

    public void addMediaToWatchList(Media media) {
        watchList.add(media);
    }
    private List<Media> saveMediaList;

    public List<Media> getSaveMediaList() {
        return saveMediaList;
    }
}
