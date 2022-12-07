package honest.niceman.university.lab6;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final int PRICE_TO_USE = 10;

    public static void main(String[] args) {
        JukeBox jukeBox = new JukeBox(3);
        List<Playlist> playlists = jukeBox.getPlaylists();
        for (Playlist playlist : playlists) {
            System.out.println(playlist.toString());
        }

        Client client = new Client(10, "Alex");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. play");
            System.out.println("2. resume");
            System.out.println("3. pause");
            System.out.println("4. refill the balance");
            System.out.println("5. end");
            int c = Integer.parseInt(sc.nextLine());
            if (c == 5) {
                break;
            }
            gotoChoice(c, sc, jukeBox, client);
        }
    }

    private static void gotoChoice(int c, Scanner scanner, JukeBox jukeBox, Client client) {
        switch (c) {
            case 1 -> {
                if (client.pay(PRICE_TO_USE)) {
                    System.out.println("Enter playlist idx: ");
                    int playlistIdx = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter song idx: ");
                    int songIdx = Integer.parseInt(scanner.nextLine());
                    jukeBox.playSong(playlistIdx, songIdx);
                } else {
                    System.out.println("Your balance is not sufficient to play songs");
                }
            }
            case 2 -> jukeBox.resumeSong(jukeBox.getCurrentSong());
            case 3 -> jukeBox.pauseSong(jukeBox.getCurrentSong());
            case 4 -> client.add(PRICE_TO_USE);
        }
    }
}
