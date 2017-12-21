/**
 * Created by abdll on 12/21/2017.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TweetoHT {

    TweetoSLL[] HT;
    int size;

    public TweetoHT() {
        HT = new TweetoSLL[37];
        for (int i = 0; i < HT.length ; i++) {
            HT[i] = new TweetoSLL();
        }
    }

    public TweetoSLL[] getHT() {
        return HT;
    }

    public void setHT(TweetoSLL[] HT) {
        this.HT = HT;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        String HTText = "";
        for (TweetoSLL t : HT) {
            HTText = HTText + t.toString();
        }
        return HTText;
    }

    public void readSLL(String filename) {
        try {
            Scanner reader = new Scanner(new File(filename));
            while (reader.hasNext()) {
                String x = reader.next();
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
                int pos = hash(id);
                getHT()[pos].insert(new Tweeto(id, content));
                //tHT.insert(new Tweeto(id, content), pos);
                //System.out.println(x + " " + id + " " + content);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Tweets file not found");
        }
    }

    public static int hash(String ID){
        int index;
        int ch  = ID.toLowerCase().charAt(1);
        if(ch > 96)
            index = ch % 37;
        else
            index = (ch % 37) + 1;

        return index;
    }


    public void insert(Tweeto T, int P) {
        getHT()[P].insert(T);
    }

    public Tweeto search(String U, String K) {
        U = "@" + U;
        int p = hash(U);
        return getHT()[p].Search(U, K);
    }
}
