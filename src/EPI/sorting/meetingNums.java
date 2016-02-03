package EPI.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by stameying on 2/2/16.
 */
public class meetingNums {

    private static class Event{
        public int start, finish;

        public Event(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }

    }

    private static class EndPoint implements Comparable<EndPoint>{
        public int time;
        public boolean isStart;

        public int compareTo(EndPoint e){
            if (time != e.time){
                return Integer.compare(time,e.time);
            }else{
                return isStart&&!e.isStart?-1: !isStart&&e.isStart?1:0;
            }
        }

        public EndPoint(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }
    }

    public static int findMaxMeetingNum(List<Event> A){
        List<EndPoint> E = new ArrayList<>();
        for (Event event: A){
            E.add(new EndPoint(event.start,true));
            E.add(new EndPoint(event.finish,false));
        }

        Collections.sort(E);

        int maxNum = 0, tempNum = 0;
        for (EndPoint endpoint: E){
            if (endpoint.isStart){
                tempNum++;
                if (tempNum > maxNum) maxNum = tempNum;
            }else{
                tempNum--;
            }
        }
        return maxNum;
    }


}
