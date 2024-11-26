package mk.ukim.finki.wp.lab1.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab1.model.Album;
import mk.ukim.finki.wp.lab1.model.Artist;
import mk.ukim.finki.wp.lab1.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Artist> artistList = null;
    public static List<Song> songsList = null;
    public static List<Album> albumList = null;


    @PostConstruct
    public void init() {
        artistList = new ArrayList<>();
        artistList.add(new Artist(1000000L, "Bruno", "Mars", "Producer and Song Writer born in USA"));
        artistList.add(new Artist(2000000L, "Teddy", "Swims", "Drummer Producer and Singer Bord in Canada"));
        artistList.add(new Artist(1000003L, "Zara", "Vale", "Drummer and Producer from the USA"));
        artistList.add(new Artist(1000004L, "Eli", "Grey", "Bassist and Composer from Canada"));
        artistList.add(new Artist(1000005L, "Rico", "Sun", "Rapper and Lyricist from Brazil"));


        albumList = new ArrayList<>();
        albumList.add(new Album("Thriller", "Pop", "1982"));
        albumList.add(new Album("Back in Black", "Rock", "1980"));
        albumList.add(new Album("The Dark Side of the Moon", "Progressive Rock", "1973"));
        albumList.add(new Album("Rumours", "Rock", "1977"));
        albumList.add(new Album("The Wall", "Rock", "1979"));


        songsList = new ArrayList<>();
        songsList.add(new Song("100001","Die with a smile", "HipHop", 2024,albumList.get(0)));
        songsList.add(new Song("100002","The Door", "HipHop", 2023,albumList.get(1)));
        songsList.add(new Song("200003", "Midnight Roads", "Rock", 2024,albumList.get(2)));
        songsList.add(new Song("200004", "Skyline Symphony", "HipHop", 2023,albumList.get(3)));
        songsList.add(new Song("200005", "Golden Horizon", "Alternative", 2024,albumList.get(4)));
    }
}
