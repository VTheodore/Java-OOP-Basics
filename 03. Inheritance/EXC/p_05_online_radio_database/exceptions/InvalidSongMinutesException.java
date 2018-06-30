package p_05_online_radio_database.exceptions;

public class InvalidSongMinutesException extends InvalidSongLengthException {
    public InvalidSongMinutesException(String name) {
        super(name);
    }
}
