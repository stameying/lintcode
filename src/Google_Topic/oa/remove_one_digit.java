package src.Google_Topic.oa;

/**
 * Created by stameying on 3/17/16.
 */
public class remove_one_digit {

    public static int solution1(int x){
        if (x < 11 || x > 1000000000) return -1;
        String num = String.valueOf(x);

        //找到第一个比后面小的
        for (int i = 0; i < num.length()-1; i++){
            if (num.charAt(i) == num.charAt(i+1)){
                while (i+1 < num.length() && num.charAt(i) == num.charAt(i+1)) i++;
                if (i+1 < num.length() && num.charAt(i) < num.charAt(i+1)){
                    String sol = num.substring(0,i)+num.substring(i+1);
                    int val = Integer.parseInt(sol);
                    return val;
                }
            }
        }

        // 到这里的话说明是递减,随便删最后一个就好
        for (int i = num.length()-1; i > 0; i--){
            if (num.charAt(i) == num.charAt(i-1)){
                String sol = num.substring(0,i)+num.substring(i+1);
                int val = Integer.parseInt(sol);
                return val;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int num1 = 22110226;
        System.out.println(solution1(num1));
    }
}
