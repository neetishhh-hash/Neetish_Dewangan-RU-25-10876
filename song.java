import java.util.*;

public class MusicPlaylistManagementSystem {

    static class Song {
        String title, artist;

        Song(String title, String artist) {
            this.title = title;
            this.artist = artist;
        }

        public String toString() {
            return title + " - " + artist;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Song> playlist = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n=== Music Playlist Management System ===");
            System.out.println("1. Add Song");
            System.out.println("2. Display Playlist");
            System.out.println("3. Shuffle Playlist");
            System.out.println("4. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Song Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Artist Name: ");
                    String artist = sc.nextLine();

                    playlist.add(new Song(title, artist));
                    System.out.println("Song Added!");
                    break;

                case 2:
                    if (playlist.isEmpty()) {
                        System.out.println("Playlist is Empty.");
                    } else {
                        System.out.println("\nPlaylist:");
                        for (Song s : playlist) {
                            System.out.println(s);
                        }
                    }
                    break;

                case 3:
                    Collections.shuffle(playlist);
                    System.out.println("Playlist Shuffled!");
                    break;

                case 4:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}
