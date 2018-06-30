package p_05_online_radio_database.exceptions;

public class InvalidSongLengthException extends InvalidSongException {
    public InvalidSongLengthException(String name) {
        super(name);
    }
}
