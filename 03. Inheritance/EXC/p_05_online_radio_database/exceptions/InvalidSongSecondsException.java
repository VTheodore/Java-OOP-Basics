package p_05_online_radio_database.exceptions;

public class InvalidSongSecondsException extends InvalidSongLengthException {
    public InvalidSongSecondsException(String name) {
        super(name);
    }
}
