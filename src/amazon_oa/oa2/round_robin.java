package src.amazon_oa.oa2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by stameying on 2/27/16.
 */
public class round_robin {

    private static class process{
        public int arrTime;
        public int exeTime;

        public process(int arrTime, int exeTime) {
            this.arrTime = arrTime;
            this.exeTime = exeTime;
        }
    }


    public static float round_robin(int[] ArrTimes, int[] ExecTimes, int q){
        if (ArrTimes == null || ExecTimes == null || ArrTimes.length != ExecTimes.length || q == 0) return 0;
        int jobCount = ArrTimes.length;
        Queue<process> cpuQueue = new LinkedList<>();
        int curTime = 0, totalWaitTime = 0, index = 0;
        while (!cpuQueue.isEmpty() || index < jobCount){
            if (cpuQueue.isEmpty()){ // still have jobs to execute later
                cpuQueue.offer(new process(ArrTimes[index],ExecTimes[index]));
                curTime = ArrTimes[index++];
            }else{ // execute current job
                process curJob = cpuQueue.poll();
                totalWaitTime += (curTime- curJob.arrTime);
                curTime += Math.min(curJob.exeTime,q);
                for (; index < jobCount && ArrTimes[index] <= curTime; index++){
                    cpuQueue.offer(new process(ArrTimes[index],ExecTimes[index]));
                }
                if (curJob.exeTime > q){
                    cpuQueue.offer(new process(curTime, curJob.exeTime-q));
                }
            }
        }
        return (float)totalWaitTime/jobCount;
    }


    public static float round_robin_average_waiting_time(int[] arrTimes, int[] exeTimes, int q){
        // no tasks
        if (arrTimes == null || exeTimes == null || arrTimes.length != exeTimes.length || q == 0) return 0;

        int numOfJob = arrTimes.length, curTime = 0, curJobIdx = 0, totalWaitTime = 0;
        Queue<process> cpuQueue = new LinkedList<>();
        while (!cpuQueue.isEmpty() || curJobIdx != numOfJob){
            // waiting for next job coming
            if (cpuQueue.isEmpty()){
                process nextJob = new process(arrTimes[curJobIdx],exeTimes[curJobIdx]);
                cpuQueue.offer(nextJob); // insert next job into cpu queue
                curTime = arrTimes[curJobIdx++]; // update current time to the start time of next job
            }else{
                // execute current job
                process curJob = cpuQueue.poll();
                totalWaitTime += (curTime-curJob.arrTime);
                curTime += Math.min(curJob.exeTime,q); // update current time to the smaller value of execute time of current job or q

                // insert arrivied jobs into cpu queue
                for (; curJobIdx < numOfJob && arrTimes[curJobIdx] <= curTime; curJobIdx++){
                    process candidateJob = new process(arrTimes[curJobIdx], exeTimes[curJobIdx]);
                    cpuQueue.offer(candidateJob);
                }

                // insert current job back to queue if it can't be finished within this q period
                if (curJob.exeTime > q){
                    curJob.arrTime = curTime;
                    curJob.exeTime = curJob.exeTime-q;
                    cpuQueue.offer(curJob);
                }
            }
        }

        // calculate average waiting time
        return (float)totalWaitTime/numOfJob;
    }

    public static float Solution(int[] Atime, int[] Etime, int q) {
        if (Atime == null || Etime == null || Atime.length != Etime.length)	return 0;
        int length = Atime.length;
        Queue<process> queue = new LinkedList<process>();
        int curTime = 0, waitTime = 0;
        int index = 0;
        while (!queue.isEmpty() || index < length) {
            if (!queue.isEmpty()) {
                process cur = queue.poll();
                waitTime += curTime - cur.arrTime;
                curTime += Math.min(cur.exeTime, q);
                for (; index < length && Atime[index] <= curTime; index++)
                    queue.offer(new process(Atime[index], Etime[index]));
                if (cur.exeTime > q)
                    queue.offer(new process(curTime, cur.exeTime - q));
            }
            else {
                queue.offer(new process(Atime[index], Etime[index]));
                curTime = Atime[index++];
            }
        }
        return (float) waitTime / length;
    }














    public static void main(String[] args) {
        float rvalue = round_robin_average_waiting_time(new int[] {0, 1, 4}, new int[] {5, 2, 3}, 3);
        System.out.println(rvalue);
    }
}
