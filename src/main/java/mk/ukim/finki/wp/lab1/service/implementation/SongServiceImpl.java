package mk.ukim.finki.wp.lab1.service.implementation;

import mk.ukim.finki.wp.lab1.model.Album;
import mk.ukim.finki.wp.lab1.model.Artist;
import mk.ukim.finki.wp.lab1.model.Song;
import mk.ukim.finki.wp.lab1.repository.SongRepository;
import mk.ukim.finki.wp.lab1.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        return songRepository.addArtistToSong(artist, song);
    }


    @Override
    public List<Song> findByTitle(String title) {
        return songRepository.findByTitle(title);
    }

    @Override
    public Song findByTrackId(String trackId) {
        return songRepository.findByTrackId(trackId);
    }
    @Override
    public void save(String title, String genre, Integer releaseYear, Album album) {
        songRepository.save(title, genre, releaseYear, album);
    }

    @Override
    public void deleteById(String id) {
        this.songRepository.deleteById(id);
    }

    public int counter(String id) {
        return songRepository.counter(id);
    }

}
