package mk.ukim.finki.wp.lab1.model;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class Artist {

    Long id;
    String firstName;
    String lastName;
    String bio;

    public Artist(Long id, String firstName, String lastName, String bio) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
    }

}
