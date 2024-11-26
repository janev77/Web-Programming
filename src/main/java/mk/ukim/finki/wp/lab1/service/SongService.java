package mk.ukim.finki.wp.lab1.service;

import mk.ukim.finki.wp.lab1.model.Album;
import mk.ukim.finki.wp.lab1.model.Artist;
import mk.ukim.finki.wp.lab1.model.Song;

import java.util.List;
import java.util.Optional;

public interface SongService {
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);

    List<Song> findByTitle(String title);

    Song findByTrackId(String trackId);

    public Optional<Song> save(String trackId, String title, String genre, Integer releaseYear, Album album);

    void deleteById(String id);
}
