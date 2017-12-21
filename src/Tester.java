/**
 * Created by abdll on 12/21/2017.
 */
import java.util.Scanner;
public class Tester {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String filename = s.next();
        int dataStructureType = s.nextInt();
        String user = s.next();
        String key = s.next();

        long timeI = System.currentTimeMillis();

        switch (dataStructureType) {
            case 1:
                TweetoAL tAL = new TweetoAL();
                tAL.readAL(filename);
                tAL.search(user, key);
                break;
            case 2:
                TweetoHT ht = new TweetoHT();
                ht.readSLL(filename);
                ht.search(user, key);
                break;
            case 3:
                TweetoBHHT tBHHT = new TweetoBHHT(Integer.parseInt(filename.substring(0, filename.indexOf("."))));
                tBHHT.readBHHT(filename);


        }

        long time = System.currentTimeMillis() - timeI;



    }

}
