public class Playlist {

    private DoubleNode head;
    private DoubleNode tail;
    

    // Constructor:
    public Playlist() {
        this.head = null;
        this.tail = null;
    }

    // Methods:

    // To insert in the beggining of the List:
    public void insert(String music, String artist, int duration) { 
        DoubleNode node = new DoubleNode(head, null, music, artist, duration);
        if (head != null) {
            head.setPrev(node);
        }
        head = node;

        if (tail == null) {
            tail = head;
        }
    }

    // To insert in the end of the List:
    public void append(String music, String artist, int duration) {
        if (isEmpty()) {
            insert(music, artist, duration);
            return;
        }
        DoubleNode node = new DoubleNode(null, tail, music, artist, duration);
        tail.setNext(node);
        tail = node;
    }

    // To get the position of the Node:
    public DoubleNode getNode(String music) {
        DoubleNode node = head;
        while (node != null) {
            if (node.getMusic().equals(music)) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }


    // To remove the song (node) from the list:
    public DoubleNode removeMusic(String music) {
        DoubleNode node = head;
        while (node != null) {
            if (node.getMusic().equals(music)) {
                if (node.getPrev() != null) { 
                    node.getPrev().setNext(node.getNext());
                } else {
                    head = node.getNext();
                    if (head != null) {
                        node.setPrev(null);
                    }
                }

                if (node.getNext() != null) {
                    node.getNext().setPrev(node.getPrev());
                } else {
                    tail = node.getPrev();
                    if (tail != null) {
                        tail.setNext(null);
                    }
                }
                return node;
                }
            node = node.getNext();
        }
        return null;
    }

    // To print the in order of the list:
    public void toShowInOrder() {
        DoubleNode node = head;
        
        while (node != null) {
            System.out.print("\n--------------------\n");
            System.out.print("Song: " + node.getMusic() + "\nArtist: " + node.getArtist() + "\nDuration: " + node.getDuration());
            System.out.print("\n--------------------\n");
            node = node.getNext();
        }
    }

    // To print in reverse order of the list:
    public void toShowReverse() {
        DoubleNode node = tail;

        while (node != null) {
            System.out.print("\n--------------------\n");
            System.out.print("Song: " + node.getMusic() + "\nArtist: " + node.getArtist() + "Duration: " + node.getDuration());
            System.out.print("\n--------------------\n");
            node = node.getPrev();
        }
    }
    
    // To verify if the list is empty:
    public boolean isEmpty() {
        return head == null;
    }

    // To change the current music (chosen by the user) to the next song from the list:
    public DoubleNode nextSong(String music) {
        DoubleNode node = getNode(music);
        if (node == null) {
            System.out.print("ERROR: Song not found");
            return null;
        }
        if (node.getNext() == null) {
            System.out.print("ERROR: End of the list");
            return null;
        }
        return node.getNext();
    }

    // To change the currente music (chosen by the user) to the previous song from the list:
    public DoubleNode previousSong(String music) {
        DoubleNode node = getNode(music);
        if (node == null) {
            System.out.print("ERROR: Song not found");
            return null;
        }
        if (node.getPrev() == null) {
            System.out.print("ERROR: End of the list");
            return null;
        }
        return node.getPrev();
    }

    // To show information about the music chosen by the user:
    public void toShowInfo(String music) {
        DoubleNode node = head;
        while (node != null) {
            if (node.getMusic().equals(music)) {
                System.out.print("\n--- About " + music + "---\n");
                System.out.print("Artist: " + node.getArtist() + "\nDuration: " + node.getDuration());
                return;
            }
            node = node.getNext();
        }
        System.out.print("ERROR: Song not found");
    }

    // Verify if a certain music is int the list:
    public boolean inPlaylist(String music) {
        DoubleNode node = head;
        while (node != null) {
            if (node.getMusic().equals(music)) {
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

}