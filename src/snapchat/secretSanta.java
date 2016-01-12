package snapchat;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Created by stameying on 1/10/16.
 */
public class secretSanta {


    public secretSanta() {

    }

    // method 1
    public void search(String[] names) {
        int len = names.length;
        Random r = new Random();
        for (int i = 0; i < len; i++) {
            int s = i + r.nextInt(len - i);
            while (s == i && len - i != 1) s = i + r.nextInt(len - i);
            swap(names, s, i);
        }
    }

    public void swap(String[] names, int left, int right){
        String temp = names[left];
        names[left] = names[right];
        names[right] = temp;
    }

    public static void main(String[] args) {
        String[] names = {"mary", "alice", "mike"};
        System.out.println("input:"+ Arrays.toString(names));
        secretSanta test = new secretSanta();
        test.search(names);
        System.out.println("output:"+ Arrays.toString(names));

    }
}
