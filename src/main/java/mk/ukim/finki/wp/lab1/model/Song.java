package mk.ukim.finki.wp.lab1.model;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Song {

    String trackId;
    String title;
    String genre;
    int releaseYear;
    @ManyToMany
    List<Artist> performers;
    @ManyToOne
    private Album album;
    public Song(String trackId, String title, String genre, int releaseYear, Album album) {
        this.trackId = String.valueOf((long) (Math.random()*1000));
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        performers = new ArrayList<>();
        this.album = album;
    }

    public void addPerformer(Artist performer) {
        performers.add(performer);
    }

}
