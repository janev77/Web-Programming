package mk.ukim.finki.wp.lab1.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Song {

    String trackId;
    String title;
    String genre;
    int releaseYear;
    List<Artist> performers;

    public Song(String trackId, String title, String genre, int releaseYear) {
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        performers = new ArrayList<>();
    }

    public void addPerformer(Artist performer) {
        performers.add(performer);
    }

}
