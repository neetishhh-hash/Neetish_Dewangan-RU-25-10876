import java.util.Random;

// Song Class
class Song {
    private String title;
    private String artist;

    // Constructor
    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }
}

// Playlist Class
class Playlist {
    private Song[] songs;
    private int count;

    // Constructor
    public Playlist(int size) {
        songs = new Song[size];
        count = 0;
    }

    // Add song to playlist
    public void addSong(Song s) {
        if (count < songs.length) {
            songs[count] = s;
            count++;
            System.out.println("Song added: " + s.getTitle());
        } else {
            System.out.println("Playlist is full!");
        }
    }

    // Display playlist
    public void displayPlaylist() {
        if (count == 0) {
            System.out.println("Playlist is empty.");
            return;
        }

        System.out.println("\nPlaylist:");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + songs[i].getTitle()
                    + " - " + songs[i].getArtist());
        }
    }

    // Shuffle playlist (Fisher-Yates)
    public void shufflePlaylist() {
        Random rand = new Random();

        for (int i = count - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);

            // Swap songs
            Song temp = songs[i];
            songs[i] = songs[j];
            songs[j] = temp;
        }

        System.out.println("\nPlaylist shuffled successfully!");
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {

        // Create playlist
        Playlist playlist = new Playlist(10);

        // Add songs
        playlist.addSong(new Song("Believer", "Imagine Dragons"));
        playlist.addSong(new Song("Shape of You", "Ed Sheeran"));
        playlist.addSong(new Song("Blinding Lights", "The Weeknd"));

        // Display original playlist
        playlist.displayPlaylist();

        // Shuffle playlist
        playlist.shufflePlaylist();

        // Display shuffled playlist
        playlist.displayPlaylist();
    }
}