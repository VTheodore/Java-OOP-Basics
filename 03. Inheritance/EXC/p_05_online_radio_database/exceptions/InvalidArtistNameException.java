package p_05_online_radio_database.exceptions;

public class InvalidArtistNameException extends InvalidSongException {
    public InvalidArtistNameException(String name) {
        super(name);
    }
}
