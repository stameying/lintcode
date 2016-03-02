package src.CodeRound2;

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
            return builder.toString();
        }
    }


    public static void main(String[] args) {
        
    }
}
