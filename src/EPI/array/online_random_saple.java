package EPI.array;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by stameying on 1/29/16.
 */
public class online_random_saple {

    public static List<Integer> onlineRandomSample(InputStream sin, int k) throws IOException, ClassNotFoundException{
        List<Integer> runningSample = new ArrayList<>(k);

        ObjectInputStream osin = new ObjectInputStream(sin);
        for (int i = 0; i < k; i++){
            Integer x = (Integer)osin.readObject();
            runningSample.add(x);
        }

        // after reading the first K elements
        int numSeenSoFar = k;
        Random ran = new Random();
        while (true){
            try{
               Integer x = (Integer)osin.readObject();
                numSeenSoFar++;

                // generate a radnom number in [0, numSeenSoFar], it this number is in [0,k-1], we replace it with the sample
                int idxToRepalce = ran.nextInt(numSeenSoFar);
                if (idxToRepalce < k){
                    runningSample.set(idxToRepalce,x);
                }
            }catch (EOFException e){
                break;
            }
        }
        osin.close();
        return runningSample;
    }

}
