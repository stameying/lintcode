package Google_Topic;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by stameying on 2/17/16.
 */
public class p176_zigzag_iterator {


        Queue<Iterator> queue;
        public p176_zigzag_iterator(List<Integer> v1, List<Integer> v2) {
            queue = new LinkedList<>();
            if (!v1.isEmpty()) queue.offer(v1.iterator());
            if (!v2.isEmpty()) queue.offer(v2.iterator());
        }

        public int next() {
            Iterator next = queue.poll();
            int res = (int)next.next();
            if (next.hasNext()) queue.offer(next);
            return res;
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
}
