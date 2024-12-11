package mk.ukim.finki.wp.lab1.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Entity
@Data
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    int counter;
    String title;
    String genre;
    int releaseYear;
    @ManyToMany
    private List<Artist> performers = new ArrayList<>();
    @ManyToOne
    private Album album;

    @OneToMany(mappedBy = "song")
    List<Comment> comment = new ArrayList<>();

    public Song() {}

    public Song(String title, String genre, int releaseYear, Album album) {
        //this.trackId = String.valueOf((long) (Math.random()*1000));
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        performers = new ArrayList<>();
        this.album = album;
        this.counter = 0;
        comment = new ArrayList<>();
    }

    public void addPerformer(Artist performer) {
        performers.add(performer);
    }
}
