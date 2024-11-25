package mk.ukim.finki.wp.lab1.service;

import mk.ukim.finki.wp.lab1.model.Artist;
import mk.ukim.finki.wp.lab1.model.Song;

import java.util.List;
import java.util.Optional;

public interface SongService {
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);
    Song findByTrackId(String trackId);
}
