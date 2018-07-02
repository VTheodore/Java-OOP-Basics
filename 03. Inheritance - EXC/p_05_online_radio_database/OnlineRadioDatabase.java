package p_05_online_radio_database;

import java.util.ArrayList;
import java.util.List;

public class OnlineRadioDatabase {
    private List<Song> songs;

    private String totalPlaylistLength;

    public OnlineRadioDatabase() {
        this.songs = new ArrayList<>();
    }

    private String getTotalPlaylistLength() {
        int totalSeconds = 0;
        for (Song song : this.songs) {
            totalSeconds += song.getTotalSongLength();
        }

        return String.format("%dh %dm %ds", totalSeconds / 3600, (totalSeconds % 3600) / 60, totalSeconds % 60);
    }

    public void addSong(Song song){
        this.songs.add(song);
        System.out.println("Song added.");
    }

    @Override
    public String toString() {
        return String.format("Songs added: %d%nPlaylist length: %s", this.songs.size(), this.getTotalPlaylistLength());
    }
}
