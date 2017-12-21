/**
 * Created by abdll on 12/21/2017.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TweetoBHHT {
    public static int hash(String ID){
        int index;
        int ch  = ID.toLowerCase().charAt(1);
        if(ch > 96)
            index = ch % 37;
        else
            index = (ch % 37) + 1;

        return index;
    }

    private Tweeto[][] HT;
    private int size;
    private int[] depth = new int[37];

    public TweetoBHHT(int s) {
        // added +1 because the binary heap implimintation using array starts from index 1 not 0
        HT = new Tweeto[37][s+1];
    }

    public Tweeto[][] getHT() {
        return HT;
    }

    public void setHT(Tweeto[][] HT) {
        this.HT = HT;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void insert(Tweeto t) {
        int pos = hash(t.getID());
        getHT()[pos][++depth[pos]] = t;
        swim(depth[pos], pos);
        size++;
    }

    private void swim(int k, int pos) {
        while (k > 1 && less(k / 2, k, pos)) {
            swap(k, k / 2, pos);
            k = k / 2;
        }
    }

    private boolean less(int i, int j, int pos) {
        return getHT()[pos][i].getID().toLowerCase().compareTo(getHT()[pos][j].getID().toLowerCase()) < 0;
    }

    private void swap(int i, int j, int pos) {
        Tweeto t = getHT()[pos][i];
        getHT()[pos][i] = getHT()[pos][j];
        getHT()[pos][j] = t;
    }

    public Tweeto remove(String maxID) {
        int pos = hash(maxID);
        Tweeto max = getHT()[pos][1];
        swap(1, depth[pos]--, pos);
        sink(1, pos);
        getHT()[pos][depth[pos] + 1] = null;
        size--;
        return max;
    }

    private void sink(int k, int pos) {
        while (2 * k <= depth[pos]) {
            int j = 2 * k;
            if (j < depth[pos] && less(j, j + 1, pos)) {
                j++;
            }
            if (!less(k, j, pos)) {
                break;
            }
            swap(k, j, pos);
            k = j;
        }
    }

    public void readBHHT(String filename) {
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
                insert(new Tweeto(id, content));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Tweets file not found");
        }
    }

    /*
    public void print() {
        for (int i = 0; i < HT.length; i++) {
            for (int j = 1; j < HT[i].length; j++) {
                if (HT[i][j] == null) {
                    break;
                }
                System.out.println(HT[i][j].toString());
            }
                System.out.println("\n\n\n");
        }
    }
    */


}
