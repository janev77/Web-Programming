package mk.ukim.finki.wp.lab1.repository;

import mk.ukim.finki.wp.lab1.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab1.model.Artist;
import mk.ukim.finki.wp.lab1.model.Song;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SongRepository {

    public List<Song> findAll(){
        return DataHolder.songsList;
    }

    public Song findByTrackId(String trackId){
        return DataHolder.songsList.stream().filter(song -> song.getTrackId().equals(trackId)).findFirst().orElse(null);
    }

    public List<Song> findByTitle(String title){
        return DataHolder.songsList.stream().filter(i -> i.getTitle().toLowerCase().contains(title.toLowerCase())).collect(Collectors.toList());
    }


    public Artist addArtistToSong(Artist artist, Song song) {
        DataHolder.songsList.stream().filter(i-> i.getTrackId().equals(song.getTrackId())).findFirst().get().addPerformer(artist);
        return artist;
    }

}
