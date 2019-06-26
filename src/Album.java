import java.util.ArrayList;

public class Album {
    ArrayList<Music> musics;
    String name;
    Album currentAlbum ;
    public Album(String name,ArrayList<Music> musics,Album currentAlbum)
    {
        this.currentAlbum=currentAlbum;
        this.musics=musics;
        this.name=name;
    }
}
