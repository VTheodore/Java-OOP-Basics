package L03_InheritanceEXC.p_05_online_radio_database;

public class Song {
    private String artistName;

    private String songName;

    private int minutes;

    private int seconds;

    public Song(String artistName, String songName, int minutes, int seconds) {
        this.artistName = artistName;
        this.songName = songName;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    protected String getArtistName() {
        return this.artistName;
    }

    private void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    protected String getSongName() {
        return this.songName;
    }

    private void setSongName(String songName) {
        this.songName = songName;
    }

    protected int getMinutes() {
        return this.minutes;
    }

    private void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    protected int getSeconds() {
        return this.seconds;
    }

    private void setSeconds(int seconds) {
        this.seconds = seconds;
    }


}
