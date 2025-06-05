import java.util.Scanner;

public class Music {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        int option;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("-------------------------------------------------------\n");
            System.out.println("1. Add song at the end of the playlist");
            System.out.println("2. Remove song by its name");
            System.out.println("3. Show all songs in order");
            System.out.println("4. Show all songs in reverse order");
            System.out.println("5. Search song by title and show informations");
            System.out.println("6. Play next or previous music");
            System.out.println("7. Finish program");
            System.out.print("--> ");
            option = sc.nextInt();
            sc.nextLine();
            System.out.print("-------------------------------------------------------");

            switch(option) {
                case 1:
                    System.out.print("\nSong: ");
                    String music = sc.nextLine();
                    System.out.print("Artist: ");
                    String artist = sc.nextLine();
                    System.out.print("Duration (seconds): ");
                    int duration = sc.nextInt();
                    playlist.append(music, artist, duration);
                    break;

                case 2:
                    System.out.print("\nSong name to remove: ");
                    String nameRemove = sc.nextLine();
                    if (!playlist.inPlaylist(nameRemove)) {
                        System.out.print("\nThere is no song named " + nameRemove);
                        break;
                    }
                    playlist.removeMusic(nameRemove);
                    break;

                case 3:
                    playlist.toShowInOrder();
                    break;

                case 4:
                    playlist.toShowReverse();
                    break;

                case 5:
                    System.out.print("\nSong name to search: ");
                    String nameInfo = sc.nextLine();
                    playlist.toShowInfo(nameInfo);
                    System.out.print("\n");
                    break;

                case 6:
                    System.out.print("\nName of the current song: ");
                    String current = sc.nextLine();
                    if (!playlist.inPlaylist(current)) {
                        System.out.print("\nThe is no song named " + current);
                        break;
                    }
                    System.out.print("1. Play next song\n2. Play previous song\n--> ");
                    int choice = sc.nextInt();
                    if (choice == 1) {
                        System.out.print("\n");
                        System.out.print(playlist.nextSong(current));
                    } else if (choice == 2) {
                        System.out.print("\n");
                        System.out.print(playlist.previousSong(current));
                    } else {
                        System.out.print("\nNone of the choices was chosen");
                    }
                    break;

            }
        } while(option != 7);
        System.out.println("\nClosing program...");
        sc.close();
    }
}