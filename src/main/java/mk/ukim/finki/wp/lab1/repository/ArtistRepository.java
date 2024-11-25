package mk.ukim.finki.wp.lab1.repository;

import mk.ukim.finki.wp.lab1.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab1.model.Artist;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ArtistRepository {

    public List<Artist> findAll(){
        return DataHolder.artistList;
    }
    public Optional<Artist> findById(Long id){
        return DataHolder.artistList.stream().filter(artist -> artist.getId().equals(id)).findFirst();
    }
}
