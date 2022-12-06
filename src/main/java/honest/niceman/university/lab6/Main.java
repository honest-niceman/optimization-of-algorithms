package honest.niceman.university.lab6;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        JukeBox jukeBox = new JukeBox(3);
        List<Playlist> playlists = jukeBox.getPlaylists();
        for (int i = 0; i < playlists.size(); i++) {
            System.out.println(playlists.get(i).toString());
        }
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. play");
            System.out.println("2. resume");
            System.out.println("3. pause");
            System.out.println("4. end");
            int c = Integer.parseInt(sc.nextLine());
            if (c == 4) {
                break;
            }
            gotoChoice(c, sc, jukeBox);
        }
    }

    private static void gotoChoice(int c, Scanner scanner, JukeBox jukeBox) {
        System.out.println("Enter playlist idx: ");
        int playlistIdx = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter song idx: ");
        int songIdx = Integer.parseInt(scanner.nextLine());
        switch (c) {
            case 1 -> jukeBox.playSong(playlistIdx, songIdx);
            case 2 -> jukeBox.resumeSong(playlistIdx, songIdx);
            case 3 -> jukeBox.pauseSong(playlistIdx, songIdx);
        }
    }
}
