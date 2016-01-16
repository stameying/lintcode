package leetcode.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by stameying on 1/15/16.
 */

public class ZigzagIterator {
    int head1,head2,curHead;
    List<Integer> v1, v2;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
        this.head1 = 0;
        this.head2 = 0;
        curHead = 1;
    }

    public int next() {
        if (curHead == 1){
            curHead = 2;
            if (head1 < v1.size()){
                return v1.get(head1++);
            }else{
                return next();
            }
        }else{
            curHead = 1;
            if (head2 < v2.size()){
                return v2.get(head2++);
            }else{
                return next();
            }
        }
    }

    public boolean hasNext() {
        return head1 != v1.size() || head2 != v2.size();
    }

    public static void main(String[] args) {
        List<Integer> v1 = new ArrayList<>(Arrays.asList(1,2));
        List<Integer> v2 = new ArrayList<>(Arrays.asList(3,4,5,6));
        ZigzagIterator iterator = new ZigzagIterator(v1,v2);
        while (iterator.hasNext()) System.out.println(iterator.next());
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */