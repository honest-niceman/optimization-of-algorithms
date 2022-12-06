package honest.niceman.university.lab6;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Song {
    private final Clip clip;
    private final String filePath;
    private Status status;
    private Long currentFrame;

    public Song(String filePath) {
        this.filePath = filePath;
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
            this.clip = AudioSystem.getClip();
            this.clip.open(audioInputStream);
            this.clip.loop(Clip.LOOP_CONTINUOUSLY);
            this.clip.stop();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public Clip getClip() {
        return clip;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getCurrentFrame() {
        return currentFrame;
    }

    public void setCurrentFrame(Long currentFrame) {
        this.currentFrame = currentFrame;
    }

    @Override
    public String toString() {
        return "Song{" +
                "clip=" + clip +
                ", status=" + status +
                ", currentFrame=" + currentFrame +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
