package mk.ukim.finki.wp.lab1.web.controller;

import mk.ukim.finki.wp.lab1.model.Album;
import mk.ukim.finki.wp.lab1.model.Artist;
import mk.ukim.finki.wp.lab1.model.Song;
import mk.ukim.finki.wp.lab1.service.implementation.AlbumServiceImpl;
import mk.ukim.finki.wp.lab1.service.implementation.ArtistServiceImpl;
import mk.ukim.finki.wp.lab1.service.implementation.SongServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SongController {

    private final SongServiceImpl songService;
    private final AlbumServiceImpl albumService;
    private final ArtistServiceImpl artistService;

    public SongController(SongServiceImpl songService, AlbumServiceImpl albumService, ArtistServiceImpl artistService) {
        this.songService = songService;
        this.albumService = albumService;
        this.artistService = artistService;
    }

    @GetMapping("/songs")
    public String getSongsPage(@RequestParam(value = "search", required = false) String search, Model model) {

        List<Song> songList;

        if (search!=null && !search.isEmpty()) {
            //songList = songList.stream().filter(i -> i.getTitle().toLowerCase().contains(search.toLowerCase())).toList();
            songList = songService.findByTitle(search);
        }
        else{
            songList = songService.listSongs();
        }
        model.addAttribute("songList", songList);

        return "listSongs";
    }
    @GetMapping("/songs/add-form")
    public String addSongPage(Model model) {

        List<Album> albumList = albumService.findAll();
        List<Song> songList = songService.listSongs();

        model.addAttribute("songs", songList);
        model.addAttribute("albums",albumList);
        return "add-song";
    }


    @PostMapping("/songs/add")
    public String saveSong(@RequestParam(value = "trackId",required = false) String trackId,
                           @RequestParam(value = "title", required = false) String title,
                           @RequestParam(value = "genre",required = false) String genre,
                           @RequestParam(value = "releaseYear",required = false) int releaseYear,
                           @RequestParam(value = "albumId",required = false) Long albumId){

        Album album = albumService.findById(albumId).orElseThrow(() -> new RuntimeException(String.valueOf(albumId)));

        if(trackId == null){
            this.songService.save(trackId, title, genre, releaseYear, album);
            return "redirect:/songs";
        }

        Song song = songService.findByTrackId(trackId);

        song.setTitle(title);
        song.setGenre(genre);
        song.setReleaseYear(releaseYear);
        song.setAlbum(albumService.findById(albumId).orElseThrow(() -> new RuntimeException(String.valueOf(albumId))));
        return "redirect:/songs";
    }

    @GetMapping("/songs/delete/{id}")
    public String deleteSong(@PathVariable String id){
        songService.deleteById(id);
        return "redirect:/songs";
    }

    @GetMapping("/songs/edit-form/{id}")
    public String getEditSongForm(@PathVariable String id, Model model){
        Song song = songService.findByTrackId(id);
        List<Artist> artists = artistService.listArtists();
        List<Album> albums = albumService.findAll();
        model.addAttribute("song", song);
        model.addAttribute("artists", artists);
        model.addAttribute("albums", albums);
        return "add-song";
    }

    @GetMapping("/songs/edit/{songId}")
    public String editSong(@PathVariable String songId,
                           @RequestParam(value = "title",required = false) String title,
                           @RequestParam(value = "genre",required = false) String genre,
                           @RequestParam(value = "releaseYear",required = false) int releaseYear,
                           @RequestParam(value = "albumId",required = false) Long albumId){
        Song song = this.songService.findByTrackId(songId);
        song.setTitle(title);
        song.setGenre(genre);
        song.setReleaseYear(releaseYear);
        song.setAlbum(albumService.findById(albumId).orElseThrow(() -> new IllegalArgumentException("Album not found")));
        return "redirect:/songs";
    }
}
