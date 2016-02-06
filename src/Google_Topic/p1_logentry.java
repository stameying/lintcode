package Google_Topic;

import java.util.*;

/**
 * Created by stameying on 2/6/16.
 */
public class p1_logentry {

    public static class LogEntry{
        public String candidate; // name
        public int time;

        public LogEntry(String name, int time){
            this.candidate = name;
            this.time = time;
        }
    }

    public static class People{
        public String candidate; // name
        public int tickets;

        public People(String candidate, int tickets) {
            this.candidate = candidate;
            this.tickets = tickets;
        }
    }

    public static class TicketComparator implements Comparator<People>{
        @Override
        public int compare(People p1, People p2){
            return Integer.compare(p2.tickets,p1.tickets);
        }

        public static final TicketComparator tc = new TicketComparator();
    }

    public static String findWinner(int time, List<LogEntry> logs){
        HashMap<String, Integer> pool = new HashMap<>();

        /*
            insert log entry into pool according to time
        */
        for (LogEntry entry: logs){
            if (entry.time <= time){
                if (pool.containsKey(entry.candidate)){
                    pool.put(entry.candidate, pool.get(entry.candidate)+1);
                }else{
                    pool.put(entry.candidate,1);
                }
            }
        }

        /*
            find the candidate with max tickets number
        */
        int curMax = 0;
        String candidateName = "";
        for (Map.Entry<String, Integer> entry: pool.entrySet()){
            if (entry.getValue() > curMax){
                curMax = entry.getValue();
                candidateName = entry.getKey();
            }
        }
        return candidateName;
    }

    public static void findFirstKWinnder(int time, List<LogEntry> logs, int k){
        // create a max heap to keep track of top K people with highest tickets number
        PriorityQueue<People> queue = new PriorityQueue<>(16,TicketComparator.tc);
        // create a hash table to store candidate name to ticket mapping
        HashMap<String, People> map = new HashMap<>();
        for (LogEntry log: logs){
            if (log.time <= time){
                if (map.containsKey(log.candidate)){
                    People p = map.get(log.candidate);
                    queue.remove(p);
                    int tickets = map.get(log.candidate).tickets+1;
                    p.tickets = tickets;
                    map.put(log.candidate,p);
                    queue.offer(p);
                }else{
                    People p = new People(log.candidate,1);
                    map.put(log.candidate,p);
                    queue.offer(p);
                }
            }
        }

        // pop out first k maximum candidates
        for (int i = 0; i < k; i++){
            People p = queue.poll();
            System.out.println(p.candidate+" with " + p.tickets + " tickets");
        }
    }

    public static void main(String[] args){
        List<LogEntry> logs = new ArrayList<>();
        logs.add(new LogEntry("c1",1));
        logs.add(new LogEntry("c2",2));
        logs.add(new LogEntry("c1",2));
        logs.add(new LogEntry("c2",3));
        logs.add(new LogEntry("c2",4));
        logs.add(new LogEntry("c3",1));
        logs.add(new LogEntry("c3",2));
//        System.out.println("the winner by 2 is " + findWinner(2,logs));
//        System.out.println("the winner by 4 is " + findWinner(4,logs));
        findFirstKWinnder(2,logs,2);
    }

}
