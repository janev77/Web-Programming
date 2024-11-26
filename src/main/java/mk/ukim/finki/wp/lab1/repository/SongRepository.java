package mk.ukim.finki.wp.lab1.repository;

import mk.ukim.finki.wp.lab1.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab1.model.Album;
import mk.ukim.finki.wp.lab1.model.Artist;
import mk.ukim.finki.wp.lab1.model.Song;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
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

    public Optional<Song> save(String trackId, String title, String genre, int releaseYear, Album album){
        Song song = new Song(trackId, title, genre, releaseYear, album);
        DataHolder.songsList.removeIf(s -> Objects.equals(s.getTitle(), title));
        DataHolder.songsList.add(song);
        return Optional.of(song);
    }

    public void deleteById(String id) {
        DataHolder.songsList.removeIf(s -> s.getTrackId().equals(id));
    }


}
