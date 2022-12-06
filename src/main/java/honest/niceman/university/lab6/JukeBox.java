package honest.niceman.university.lab6;

import javax.sound.sampled.Clip;
import java.util.ArrayList;
import java.util.List;

public class JukeBox {
    private final List<Playlist> playlists;

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public JukeBox(int size) {
        this.playlists = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            this.playlists.add(new Playlist(i+3));
        }
    }

    public void playSong(int playlistIdx, int songIdx) {
        Song song = playlists.get(playlistIdx).getSong(songIdx);
        Clip clip = song.getClip();
        clip.start();
        song.setStatus(Status.PLAY);
    }

    public void pauseSong(int playlistIdx, int songIdx) {
        Song song = playlists.get(playlistIdx).getSong(songIdx);
        if (song.getStatus() == Status.PLAY) {
            Clip clip = song.getClip();
            clip.stop();
            long microsecondPosition = clip.getMicrosecondPosition();
            song.setCurrentFrame(microsecondPosition);
            song.setStatus(Status.PAUSED);
        } else {
            throw new IllegalArgumentException("Song should be started before paused");
        }
    }

    public void resumeSong(int playlistIdx, int songIdx) {
        Song song = playlists.get(playlistIdx).getSong(songIdx);
        if (song.getStatus() == Status.PAUSED) {
            Clip clip = song.getClip();
            clip.setMicrosecondPosition(song.getCurrentFrame());
            clip.start();
            song.setStatus(Status.PLAY);
        } else {
            throw new IllegalArgumentException("Song should be paused before resumed");
        }
    }
}
