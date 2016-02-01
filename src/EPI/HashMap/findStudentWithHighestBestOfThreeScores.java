package EPI.HashMap;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by stameying on 2/1/16.
 */
public class findStudentWithHighestBestOfThreeScores {

    public static String findStudentWithHighest(ObjectInputStream ois) throws ClassNotFoundException, IOException{
        Map<String, PriorityQueue<Integer>> studentScores = new HashMap<>();
        try{
            while (true){
                String name = (String)ois.readObject();
                Integer score = (Integer)ois.readObject();
                PriorityQueue<Integer> scores = studentScores.get(name);
                if (scores == null){
                    scores = new PriorityQueue<>();
                    studentScores.put(name,scores);
                }
                scores.add(score);
                if (scores.size() > 3){
                    scores.poll();
                }
            }
        }catch (EOFException e){

        }

        String topStudent = "";
        int currentTopThreeScoreSum = 0;
        for (Map.Entry<String, PriorityQueue<Integer>> scores: studentScores.entrySet()){
            if (studentScores.size() == 3){
                int currentSum = getTopThreeScresSum(scores.getValue());
                if (currentSum > currentTopThreeScoreSum){
                    currentTopThreeScoreSum = currentSum;
                    topStudent = scores.getKey();
                }
            }
        }
        return topStudent;
    }

    private static int getTopThreeScresSum(PriorityQueue<Integer> queue){
        int sum = 0;
        for (int i = 0; i < 3; i++){
            sum += queue.poll();
        }
        return sum;
    }
}
