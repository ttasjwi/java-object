package com.ttasjwi.playlist.step02;

public class PersonalPlaylist extends Playlist {

    public void remove(Song song) {
        getTracks().remove(song);
    }
}
