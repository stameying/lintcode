package EPI.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by stameying on 2/2/16.
 */
public class validPlacement {
    private List<Player> players;

    class Player implements Comparable<Player> {
        public Integer height;
        public Player(Integer h) {height = h;}

        @Override
        public int compareTo(Player that){
            return Integer.compare(this.height,that.height);
        }

        @Override
        public boolean equals(Object obj){
            if (obj == null || !(obj instanceof Player)) return false;
            return this==obj?true:height.equals(((Player) obj).height);
        }
    }


    class Team{
        public Team(List<Integer> heights){
            players = new ArrayList<Player>(heights.size());
            for (int i = 0; i < heights.size(); i++){
                players.add(new Player(heights.get(i)));
            }
        }

        private List<Player> sortPlayerByHeight(){
            List<Player> sortedPlayers = new ArrayList<>(players);
            Collections.sort(sortedPlayers);
            return sortedPlayers;
        }

    }

    public static boolean validPlacementExists(Team A, Team B){
        List<Player> ASorted = A.sortPlayerByHeight();
        List<Player> BSorted = B.sortPlayerByHeight();
        for (int i = 0; i < ASorted.size() && i < BSorted.size(); i++){
            if (ASorted.get(i).compareTo(BSorted.get(i)) >= 0) return false;
        }
        return true;
    }


}
