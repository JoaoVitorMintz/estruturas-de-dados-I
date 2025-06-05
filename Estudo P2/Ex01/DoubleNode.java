public class DoubleNode {

    // Variables:
    private DoubleNode next;
    private DoubleNode prev;
    private String music;
    private String artist;
    private int duration;

    // Constructors:
    public DoubleNode() {
        this(null, null, "", "", 0);
    }

    public DoubleNode(DoubleNode next, DoubleNode prev, String music, String artist, int duration) {
        this.next = next;
        this.prev = prev;
        this.music = music;
        this.artist = artist;
        this.duration = duration;
    }

    // Getters:
    public String getMusic() {
        return music;
    }

    public String getArtist() {
        return artist;
    }

    public int getDuration() {
        return duration;
    }

    public DoubleNode getNext() {
        return next;
    }

    public DoubleNode getPrev() {
        return prev;
    }

    // Setters:
    public void setMusic(String music) {
        this.music = music;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }
    
    public void setPrev(DoubleNode prev) {
        this.prev = prev;
    }
}
