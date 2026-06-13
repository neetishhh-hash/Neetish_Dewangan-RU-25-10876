import java.util.*;

public class MusicPlaylistManagementSystem {
    static String[] titles = new String[100];
    static String[] artists = new String[100];
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
                    titles[count] = sc.nextLine();
                    System.out.print("Enter Artist Name: ");
                    artists[count] = sc.nextLine();
                    count++;
                    System.out.println("Song Added!");
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("Playlist is Empty.");
                    } else {
                        System.out.println("\nPlaylist:");
                        for (int i = 0; i < count; i++) {
                            System.out.println(titles[i] + " - " + artists[i]);
                        }
                    }
                    break;

                case 3:
                    for (int i = count - 1; i > 0; i--) {
                        int j = (int)(Math.random() * (i + 1));
                        String tempT = titles[i]; titles[i] = titles[j]; titles[j] = tempT;
                        String tempA = artists[i]; artists[i] = artists[j]; artists[j] = tempA;
                    }
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
