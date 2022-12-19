package com.ttasjwi.playlist.step01;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private final List<Song> tracks = new ArrayList<>();

    public void append(Song song) {
        tracks.add(song);
    }

    public List<Song> getTracks() {
        return tracks;
    }
}
