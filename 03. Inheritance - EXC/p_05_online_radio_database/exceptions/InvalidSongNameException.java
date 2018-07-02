package p_05_online_radio_database.exceptions;

public class InvalidSongNameException extends InvalidSongException {
    public InvalidSongNameException(String name) {
        super(name);
    }
}
