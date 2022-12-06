package honest.niceman.university.lab6;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private List<Song> songs;

    public Playlist(int size) {
        this.songs = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            songs.add(new Song("src/main/resources/songs/" + i + ".snd"));
        }
    }

    public Song getSong(int idx) {
        if (idx >= songs.size()) {
            throw new IndexOutOfBoundsException("Idx is too big for this playlist");
        }
        if (idx < 0) {
            throw new IndexOutOfBoundsException("Idx should be positive");
        }
        return songs.get(idx);
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "songs=" + songs +
                '}';
    }
}