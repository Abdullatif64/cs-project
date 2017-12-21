import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by abdll on 12/21/2017.
 */
public class TweetoAL {
    ArrayList<Tweeto> AL = new ArrayList<>();

    public ArrayList<Tweeto> getAL() {
        return AL;
    }

    public void setAL(ArrayList<Tweeto> AL) {
        this.AL = AL;
    }



    public void readAL(String filename) {
        try {
            Scanner reader = new Scanner(new File(filename));
            while (reader.hasNext()) {
                reader.next();
                String content = "";
                String id = reader.next();
                String temp = reader.next();
                while (true) {
                    if (temp.contains("@") || temp.contains("RT")) {
                        temp = reader.next();
                    } else {
                        break;
                    }
                }
                content = temp;
                String last = reader.nextLine();
                while (!last.contains("2016")) {
                    last = last + reader.nextLine();
                }
                content = content + last.substring(0, last.indexOf("Wed Dec") - 1);
                getAL().add(new Tweeto(id, content));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Tweets file not found");
        }
    }

    public Tweeto search(String U, String K) {
        U = "@" + U;
        Iterator<Tweeto> ALI = getAL().iterator();
        while (ALI.hasNext()) {
            Tweeto t = ALI.next();
            if (t.getTweet().toLowerCase().contains(K.toLowerCase()) && t.getID().toLowerCase().startsWith(U.toLowerCase()))
                return t;
        }
        return null;
    }
}
