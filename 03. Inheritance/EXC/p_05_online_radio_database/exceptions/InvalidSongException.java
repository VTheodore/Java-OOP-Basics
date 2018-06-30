package p_05_online_radio_database.exceptions;

public class InvalidSongException extends IllegalArgumentException {
    public InvalidSongException(String name){
        super(name);
    }
}
