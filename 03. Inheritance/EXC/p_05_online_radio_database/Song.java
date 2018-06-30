package p_05_online_radio_database;

import p_05_online_radio_database.exceptions.*;

public class Song {
    private static final String INVALID_ARTIST_NAME_ERR = "Artist name should be between 3 and 20 symbols.";

    private static final String INVALID_SONG_NAME_ERR = "Song name should be between 3 and 20 symbols.";

    private static final String INVALID_SONG_MINUTES_ERR = "Song minutes should be between 0 and 14.";

    private static final String INVALID_SONG_SECONDS_ERR = "Song seconds should be between 0 and 59.";

    private static final int SONG_UPPER_BOUNDARY = 14 * 60 + 59;

    private static final String INVALID_SONG_LENGTH_ERR = "Invalid song length.";

    private String artistName;

    private String songName;

    private int minutes;

    private int seconds;


    public Song(String artistName, String songName, int minutes, int seconds) {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setMinutes(minutes);
        this.setSeconds(seconds);

        if (this.getTotalSongLength() < 0 || getTotalSongLength() > SONG_UPPER_BOUNDARY){
            throw new InvalidSongLengthException(INVALID_SONG_LENGTH_ERR);
        }
    }

    private void setArtistName(String artistName) {
        if (artistName.length() < 3 || artistName.length() > 20){
            throw new InvalidArtistNameException(INVALID_ARTIST_NAME_ERR);
        }
        this.artistName = artistName;
    }

    private void setSongName(String songName) {
        if (songName.length() < 3 || songName.length() > 20){
            throw new InvalidSongNameException(INVALID_SONG_NAME_ERR);
        }
        this.songName = songName;
    }

    private void setMinutes(int minutes) {
        if (minutes < 0 || minutes > 14){
            throw new InvalidSongMinutesException(INVALID_SONG_MINUTES_ERR);
        }
        this.minutes = minutes;
    }

    private void setSeconds(int seconds) {
        if (seconds < 0 || seconds > 59){
            throw new InvalidSongSecondsException(INVALID_SONG_SECONDS_ERR);
        }
        this.seconds = seconds;
    }

    public int getTotalSongLength(){
        return this.minutes * 60 + this.seconds;
    }
}
