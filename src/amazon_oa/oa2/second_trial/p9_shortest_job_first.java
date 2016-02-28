package src.amazon_oa.oa2.second_trial;
import java.util.PriorityQueue;
import java.util.Comparator;
/**
 * Created by stameying on 2/27/16.
 */
public class p9_shortest_job_first {


    public static class process{
        public int arrTime;
        public int exeTime;
        public process(int arrTime, int exeTime){
            this.arrTime = arrTime;
            this.exeTime = exeTime;
        }
    }


    private static class SJF_Comparator implements Comparator<process>{
        @Override
        public int compare(process p1, process p2){
            int res = Integer.compare(p1.exeTime,p2.exeTime);
            if (res == 0){
                return Integer.compare(p1.arrTime,p2.exeTime);
            }else return res;
        }

        public static final SJF_Comparator SHORTEST_JOB_FIRST_COMPARATOR = new SJF_Comparator();
    }

    public static float short_job_first(int[] requestTime, int[] duration){
        if (requestTime == null || duration == null || requestTime.length != duration.length) return 0;
        int countOfJob = requestTime.length, curTime = 0, totalWaitTime = 0, curJobIdx = 0;
        PriorityQueue<process> cpuQueue = new PriorityQueue<>(SJF_Comparator.SHORTEST_JOB_FIRST_COMPARATOR);
        while (!cpuQueue.isEmpty() || curJobIdx < countOfJob){
            if (!cpuQueue.isEmpty()){
                process curJob = cpuQueue.poll();
                totalWaitTime += (curTime-curJob.arrTime);
                curTime += curJob.exeTime;
                for (;curJobIdx < countOfJob && curTime >= requestTime[curJobIdx]; curJobIdx++){
                    process pendingJob = new process(requestTime[curJobIdx], duration[curJobIdx]);
                    cpuQueue.offer(pendingJob);
                }
            }else{
                process nextJob = new process(requestTime[curJobIdx],duration[curJobIdx]);
                cpuQueue.offer(nextJob);
                curTime = requestTime[curJobIdx++];
            }
        }

        return (float)totalWaitTime/countOfJob;
    }

    public static void main(String[] args) {
        float rvalue = short_job_first(new int[] {0, 1, 3, 9}, new int[] {2,1,7,5});
        System.out.println(rvalue);
    }
}
