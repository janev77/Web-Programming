package mk.ukim.finki.wp.lab1.service;

import mk.ukim.finki.wp.lab1.model.Album;
import mk.ukim.finki.wp.lab1.model.Artist;
import mk.ukim.finki.wp.lab1.model.Song;

import java.util.List;

public interface SongService {
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);

    List<Song> findByTitle(String title);

    Song findByTrackId(String trackId);

    public void save(String title, String genre, Integer releaseYear, Album album);

    void deleteById(String id);
}
