package src.Google_Topic.oa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stameying on 3/18/16.
 */
public class directors {

    public static int solution(String s){
        if (s.length() == 0) return 0;
        String[] paths = s.split("\n");
        int[] res = new int[1];

        List<String> cur = new ArrayList<>();
        for (int pos = 0; pos < paths.length; pos++){
            String location = paths[pos];
            System.out.println(cur);

            int spaceNum = 0, idx = 0;
            while (idx < location.length() && location.charAt(idx) == ' ') idx++;
            spaceNum = idx;
            if (spaceNum < cur.size()){
                cur.set(spaceNum,location.substring(spaceNum));
                for (int i = spaceNum+1; i < cur.size(); i++){
                    cur.remove(i);
                }
            }else{
                cur.add(location.substring(spaceNum));
            }

            if (location.indexOf('.') != -1){
                // check if its image
                int dotPos = location.indexOf('.');
                String extension = location.substring(dotPos+1);
                if (extension.equals("jpeg") || extension.equals("png") || extension.equals("gif")){
                    System.out.println("image="+cur);
                    int sol = 0;
                    for (int i = 0; i < spaceNum; i++){
                        System.out.println(cur.get(i)+" len="+cur.get(i).length());
                        res[0] += (1+ cur.get(i).length());
                    }
                }
            }
        }

        return res[0];
    }

    public static void main(String[] args) {
        String s = "dir1\n dirl1\n dirl2\n  picture.jpeg\n  dirl2l\n  file1.txt\ndir2\n file2.gif";
//        System.out.println(solution(s));


        System.out.println("ab".substring(2).length());
    }
}
