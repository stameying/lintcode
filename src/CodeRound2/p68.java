package src.CodeRound2;

import java.util.List;

/**
 * Created by stameying on 3/2/16.
 */
public class p68 {


    public void addLineToRes(String[] preLine, int totalSpace, int maxWidth, List<String> res, boolean lastLine){
        if (!lastLine){
            int space = totalSpace/(preLine.length-1);
            int modSpace = totalSpace%(preLine.length-1);
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < preLine.length; i++){
                builder.append(preLine[i]);
                for (int j = 0; j < space; j++) builder.append(' ');
                if (modSpace > 0){
                    builder.append(' ');
                    modSpace--;
                }
            }
            res.add(builder.toString());
            return;
        }
    }


    public static void main(String[] args) {
        String[] str = {"hello","word","i","am"};
        System.out.println();
    }
}
