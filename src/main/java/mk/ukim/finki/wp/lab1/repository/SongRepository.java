package mk.ukim.finki.wp.lab1.repository;

import mk.ukim.finki.wp.lab1.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab1.model.Artist;
import mk.ukim.finki.wp.lab1.model.Song;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SongRepository {

    public List<Song> findAll(){
        return DataHolder.songsList;
    }

    public Song findByTrackId(String trackId){
        return DataHolder.songsList.stream().filter(song -> song.getTrackId().equals(trackId)).findFirst().orElse(null);
    }

    public Artist addArtistToSong(Artist artist, Song song) {

        return DataHolder.songsList.stream()
                .filter(s -> s.getTrackId().equals(song.getTrackId()))
                .findFirst()
                .map(s -> {
                    s.addPerformer(artist);
                    return artist;
                })
                .orElse(null);
    }

}
