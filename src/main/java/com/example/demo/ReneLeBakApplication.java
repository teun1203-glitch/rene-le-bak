package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@SpringBootApplication
@RestController
public class ReneLeBakApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReneLeBakApplication.class, args);
    }

    static class Track {
        public String name;
        public String rule;
        public String youtubeId;

        public Track(String name, String rule, String youtubeId) {
            this.name = name;
            this.rule = rule;
            this.youtubeId = youtubeId;
        }
    }

    private final List<Track> weightedTracks = new ArrayList<>();
    private final Random random = new Random();

    public ReneLeBakApplication() {
        addMultiple(new Track("Solid Stigma", "🛡️ SAFE!", "Uls5CnmAdic"), 71);
        addMultiple(new Track("If I Tell You", "🍺 3 slokken nemen!", "vAJFokM391w"), 20);
        addMultiple(new Track("If I Tell You - Hardstyle Remix", "💀 ATJE!", "Qmi4Z9q7ov0"), 4);
        addMultiple(new Track("Kiss Me Baby", "🍻 Geef een atje!", "bAtkKfZPQ38"), 4);
        addMultiple(new Track("In Tirol", "🍺 Iedereen een bak!", "wafcCrdpQKA"), 1);
    }

    private void addMultiple(Track track, int count) {
        for (int i = 0; i < count; i++) {
            weightedTracks.add(track);
        }
    }

    @GetMapping("/next")
    public Track nextTrack() {
        return weightedTracks.get(random.nextInt(weightedTracks.size()));
    }
}