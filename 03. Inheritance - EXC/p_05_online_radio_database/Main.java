package p_05_online_radio_database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        OnlineRadioDatabase ord = new OnlineRadioDatabase();

        while (n-- > 0){
            String[] tokens = in.readLine().split(";");

            String artist = tokens[0];
            String songName = tokens[1];
            int minutes = Integer.parseInt(tokens[2].split(":")[0]);
            int seconds = Integer.parseInt(tokens[2].split(":")[1]);

            Song song;
            try {
                song = new Song(artist, songName, minutes, seconds);
                ord.addSong(song);
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }

        System.out.println(ord.toString());
    }
}
