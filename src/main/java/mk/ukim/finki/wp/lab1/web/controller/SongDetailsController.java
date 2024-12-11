package mk.ukim.finki.wp.lab1.web.controller;


import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.wp.lab1.model.Artist;
import mk.ukim.finki.wp.lab1.model.Song;
import mk.ukim.finki.wp.lab1.service.ArtistService;
import mk.ukim.finki.wp.lab1.service.SongService;
import mk.ukim.finki.wp.lab1.service.implementation.ArtistServiceImpl;
import mk.ukim.finki.wp.lab1.service.implementation.SongServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/song/song-details")
public class SongDetailsController {
    private final SongService songService;
    private final ArtistService artistService;
    //int counter = 0;


    public SongDetailsController(SongServiceImpl songService, ArtistServiceImpl artistService) {
        this.songService = songService;
        this.artistService = artistService;
    }

    @GetMapping
    public String showSongDetails(@RequestParam(required = false) Model model) {

        Song s = songService.listSongs().stream().findFirst().orElse(null);

        model.addAttribute("song",s);
        return "songDetails";
    }

    @PostMapping
    public String saveSongDetails(@RequestParam(value = "id", required = false) Long id,
                                  @RequestParam(value = "artistId", required = false) String artistId,
                                  Model model) {
        Song s = songService.listSongs().stream().findFirst().orElse(null);

        if (id != null && artistId != null) {
            s = songService.findById(id);
            Artist a = artistService.findById(Long.valueOf(artistId));

            if (!s.getPerformers().contains(a)){
                s.addPerformer(a);
            }
        }

        int counter = songService.counter(id);
        model.addAttribute("song", s);
        model.addAttribute("count", counter);

        return "songDetails";
    }
    @PostMapping("/add-comment")
    public String addComment(@RequestParam(value = "id", required = false) Long id,
                             @RequestParam(value = "comment", required = false) String text,
                             Model model){

        Song song = songService.findById(id);

        System.out.println("Fleze" + id);

        songService.comments(text,id);

        int counter = songService.counter(id);
        model.addAttribute("comment", song);
        model.addAttribute("count", counter);
        model.addAttribute("song", song);


        return "songDetails";
    }

}
