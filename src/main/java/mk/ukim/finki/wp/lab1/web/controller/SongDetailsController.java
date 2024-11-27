package mk.ukim.finki.wp.lab1.web.controller;


import mk.ukim.finki.wp.lab1.model.Artist;
import mk.ukim.finki.wp.lab1.model.Song;
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
    private final SongServiceImpl songService;
    private final ArtistServiceImpl artistService;
    //int counter = 0;


    public SongDetailsController(SongServiceImpl songService, ArtistServiceImpl artistService) {
        this.songService = songService;
        this.artistService = artistService;
    }

    @GetMapping
    public String showSongDetails(@RequestParam(value = "", required = false) Model model) {

        Song s = songService.listSongs().stream().findFirst().orElse(null);

        model.addAttribute("song",s);
        return "songDetails";
    }

    @PostMapping
    public String saveSongDetails(@RequestParam(value = "trackId", required = false) String trackId,
                                  @RequestParam(value = "artistId", required = false) String artistId,
                                  Model model) {
        Song s = songService.listSongs().stream().findFirst().orElse(null);

        if (trackId != null && !trackId.isEmpty() && artistId != null && !artistId.isEmpty()) {
            s = songService.findByTrackId(trackId);
            Artist a = artistService.findById(Long.valueOf(artistId));

            if (!s.getPerformers().contains(a)){
                s.addPerformer(a);
            }
        }

        int counter = songService.counter(trackId);
        model.addAttribute("song", s);
        model.addAttribute("count", counter);

        return "songDetails";
    }
}
