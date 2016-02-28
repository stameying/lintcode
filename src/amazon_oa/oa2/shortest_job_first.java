package src.amazon_oa.oa2;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by stameying on 2/27/16.
 */
public class shortest_job_first {


    private static class process{
        public int arrTime;
        public int exeTime;

        public process(int arrTime, int exeTime) {
            this.arrTime = arrTime;
            this.exeTime = exeTime;
        }
    }

    public static float shortest(int[] req, int[] dur){
        // case of empty job list or invalid input
        if (req == null || dur == null || req.length != dur.length) return 0;
        int index = 0, len = req.length, waitTime = 0, curTime = 0;
        PriorityQueue<process> pq = new PriorityQueue<>(ShortestJobFirstComparator.SHORTESTJOB_COMPARATOR);
        while (!pq.isEmpty() || index < len){
            if (!pq.isEmpty()){
                process cur = pq.poll();
                waitTime += curTime-cur.arrTime;
                curTime += cur.exeTime;
                while (index < len && req[index] <= curTime){
                    pq.offer(new process(req[index],dur[index]));
                    index++;
                }
            }else{
                process next = new process(req[index],dur[index]);
                curTime = req[index++];
                pq.offer(next);
            }
        }

        return (float)waitTime/len;
    }

    private static class ShortestJobFirstComparator implements Comparator<process> {
        @Override
        public int compare(process p1, process p2){
            int res = Integer.compare(p1.exeTime,p2.exeTime);
            if (res != 0) return res;
            else return Integer.compare(p1.arrTime,p2.arrTime);
        }

        public static final ShortestJobFirstComparator SHORTESTJOB_COMPARATOR = new ShortestJobFirstComparator();
    }

    public static void main(String[] args) {
        float rvalue = shortest(new int[] {0, 2, 4, 5}, new int[] {7, 4, 1, 4});
        System.out.println(rvalue);
    }
}
