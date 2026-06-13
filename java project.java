import java.util.Random;

class Song {
    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }
}

class Playlist {
    private Song[] songs;
    private int count;

    public Playlist(int size) {
        songs = new Song[size];
        count = 0;
    }

    public void addSong(Song s) {
        if (count < songs.length) {
            songs[count] = s;
            count++;
            System.out.println("Song added: " + s.getTitle());
        } else {
            System.out.println("Playlist is full!");
        }
    }

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

    public void shufflePlaylist() {
        Random rand = new Random();

        for (int i = count - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);

            Song temp = songs[i];
            songs[i] = songs[j];
            songs[j] = temp;
        }

        System.out.println("\nPlaylist shuffled successfully!");
    }
}

public class Main {
    public static void main(String[] args) {

        Playlist playlist = new Playlist(10);

        playlist.addSong(new Song("Believer", "Imagine Dragons"));
        playlist.addSong(new Song("Shape of You", "Ed Sheeran"));
        playlist.addSong(new Song("Blinding Lights", "The Weeknd"));

        playlist.displayPlaylist();

        playlist.shufflePlaylist();

        playlist.displayPlaylist();
    }
}
