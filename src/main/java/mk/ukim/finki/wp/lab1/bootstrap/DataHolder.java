package mk.ukim.finki.wp.lab1.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab1.model.Album;
import mk.ukim.finki.wp.lab1.model.Artist;
import mk.ukim.finki.wp.lab1.model.Song;
import mk.ukim.finki.wp.lab1.repository.jpa.AlbumRepository;
import mk.ukim.finki.wp.lab1.repository.jpa.ArtistRepository;
import mk.ukim.finki.wp.lab1.repository.jpa.SongRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Artist> artistList = null;
    public static List<Song> songsList = null;
    public static List<Album> albumList = null;

    private final AlbumRepository albumRepository;
    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;

    public DataHolder(AlbumRepository albumRepository, SongRepository songRepository, ArtistRepository artistRepository) {
        this.albumRepository = albumRepository;
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
    }

    @PostConstruct
    public void init() {
        artistList = new ArrayList<>();
        if (artistRepository.count() == 0) {
            artistList.add(new Artist("Bruno", "Mars", "Producer and Song Writer born in USA"));
            artistList.add(new Artist("Teddy", "Swims", "Drummer Producer and Singer Bord in Canada"));
            artistList.add(new Artist("Zara", "Vale", "Drummer and Producer from the USA"));
            artistList.add(new Artist("Eli", "Grey", "Bassist and Composer from Canada"));
            artistList.add(new Artist("Rico", "Sun", "Rapper and Lyricist from Brazil"));
            this.artistRepository.saveAll(artistList);
        }


        albumList = new ArrayList<>();
        if (this.albumRepository.count() == 0){
            albumList.add(new Album("Thriller", "Pop", "1982"));
            albumList.add(new Album("Back in Black", "Rock", "1980"));
            albumList.add(new Album("The Dark Side of the Moon", "Progressive Rock", "1973"));
            albumList.add(new Album("Rumours", "Rock", "1977"));
            albumList.add(new Album("The Wall", "Rock", "1979"));
            this.albumRepository.saveAll(albumList);
        }


        songsList = new ArrayList<>();
        if (this.songRepository.count() == 0){
            songsList.add(new Song("Die with a smile", "HipHop", 2024,albumList.get(0)));
            songsList.add(new Song("The Door", "HipHop", 2023,albumList.get(1)));
            songsList.add(new Song("Midnight Roads", "Rock", 2024,albumList.get(2)));
            songsList.add(new Song("Skyline Symphony", "HipHop", 2023,albumList.get(3)));
            songsList.add(new Song("Golden Horizon", "Alternative", 2024,albumList.get(4)));
            this.songRepository.saveAll(songsList);
        }
    }
}
