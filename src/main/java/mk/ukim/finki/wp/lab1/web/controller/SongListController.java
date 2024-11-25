package mk.ukim.finki.wp.lab1.web.controller;

import mk.ukim.finki.wp.lab1.model.Song;
import mk.ukim.finki.wp.lab1.service.implementation.SongServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/song/song-list")
public class SongListController {

    private final SongServiceImpl songService;

    public SongListController(SongServiceImpl songService) {
        this.songService = songService;
    }

    @GetMapping
    public String showSongList(@RequestParam(value = "search", required = false) String search, Model model) {

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
}
