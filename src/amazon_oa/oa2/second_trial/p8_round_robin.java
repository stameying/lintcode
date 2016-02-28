package src.amazon_oa.oa2.second_trial;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Created by stameying on 2/27/16.
 */
public class p8_round_robin {

    public static class process{
        public int arrTime;
        public int exeTime;
        public process(int arrTime, int exeTime){
            this.arrTime = arrTime;
            this.exeTime = exeTime;
        }
    }

    public static float RoundRobin_WaitingTime(int[] arrivalTime, int[] executionTime, int q){
        if (arrivalTime == null || executionTime == null || arrivalTime.length != executionTime.length || q <= 0) return 0;
        int countOfJob = arrivalTime.length, curTime = 0, totalWaitTime = 0, curJobIndex = 0;
        Queue<process> cpuQueue = new LinkedList<>();
        while (!cpuQueue.isEmpty() || curJobIndex < countOfJob){
            if (cpuQueue.isEmpty()){ // more job coming
                process nextJob = new process(arrivalTime[curJobIndex], executionTime[curJobIndex]);
                cpuQueue.offer(nextJob);
                curTime = arrivalTime[curJobIndex++];
            }else{
                process curJob = cpuQueue.poll();
                totalWaitTime += (curTime-curJob.arrTime);
                curTime += Math.min(curJob.exeTime,q);
                for (; curJobIndex < countOfJob && arrivalTime[curJobIndex] <= curTime; curJobIndex++){
                    process pendingJob = new process(arrivalTime[curJobIndex],executionTime[curJobIndex]);
                    cpuQueue.offer(pendingJob);
                }
                if (curJob.exeTime > q){
                    curJob.arrTime = curTime;
                    curJob.exeTime -= q;
                    cpuQueue.offer(curJob);
                }
            }
        }

        return (float)totalWaitTime/countOfJob;
    }


    public static void main(String[] args) {
        float rvalue = RoundRobin_WaitingTime(new int[] {0, 1, 4}, new int[] {5, 2, 3}, 3);
        System.out.println(rvalue);
    }
}
