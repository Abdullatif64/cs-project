/**
 * Created by abdll on 12/21/2017.
 */
public class Tweeto {
    private String ID;
    private String tweet;
    private Tweeto next;

    public Tweeto(String ID, String Tweet, Tweeto next) {
        this.ID = ID;
        this.tweet = Tweet;
        this.next = next;
    }

    public Tweeto(String ID, String Tweet) {
        this.ID = ID;
        this.tweet = Tweet;
    }

    public Tweeto(){}

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String Tweet) {
        this.tweet = Tweet;
    }

    public Tweeto getNext() {
        return next;
    }

    public void setNext(Tweeto next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "[" + getID() + "] [" + getTweet() + "]\n";
    }
}
