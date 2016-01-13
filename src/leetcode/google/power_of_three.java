package leetcode.google;

/**
 * Created by stameying on 1/12/16.
 */
public class power_of_three {

    public boolean power_of_three(int n){
        return n<=0?false:n==Math.pow(3,Math.round(Math.log(n)/Math.log(3)));
    }
}
