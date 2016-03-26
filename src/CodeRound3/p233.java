package src.CodeRound3;

/**
 * Created by stameying on 3/24/16.
 */
public class p233 {

    /*
        当某一位的数字小于i时，那么该位出现i的次数为：更高位数字x当前位数
        当某一位的数字等于i时，那么该位出现i的次数为：更高位数字x当前位数+低位数字+1
        当某一位的数字大于i时，那么该位出现i的次数为：(更高位数字+1)x当前位数
    */

    public static int countDigitOne(int n) {
        int cnt = 0;
        int factor = 1;
        int low = 0, cur = 0, high = 0;
        while (n/factor != 0){
            low = n-(n/factor)*factor;
            cur = (n/factor)%10;
            high = n/(factor*10);

//            System.out.println("low="+low+",cur="+cur+",high="+high);

            if (cur < 1){
                cnt += high*factor;
            }else if (cur == 1){
                cnt += (high*factor)+low+1;
            }else{
                cnt += (high+1)*factor;
            }

            factor*=10;
        }

        return cnt;
    }


    public static void main(String[] args) {
        int num = 399;
        System.out.println(countDigitOne(num));
    }
}
