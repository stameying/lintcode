package src.CodeRound2;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by stameying on 2/18/16.
 */
public class max_point_in_a_line {

    class Point {
             int x;
             int y;
             Point() { x = 0; y = 0; }
             Point(int a, int b) { x = a; y = b; }

    }

    private static class Rational implements Comparable<Rational>{
        public Integer numerator;
        public Integer denominator;
        public Rational(Integer numerator, Integer denominator){
            this.numerator = numerator;
            this.denominator = denominator;
        }

        @Override
        public int compareTo(Rational r2){
            if (this.denominator == 0 && r2.denominator == 0) return 0;
            else if (this.denominator == 0) return 1;
            else if (r2.denominator == 0) return -1;
            else{
                return Double.compare(((double)this.numerator)/this.denominator,((double)r2.numerator)/r2.denominator);
            }
        }

        @Override
        public boolean equals(Object obj){
            if (obj == null || !(obj instanceof Rational)) return false;
            if (this == obj) return true;
            else return (this.numerator*((Rational)obj).denominator == this.denominator*((Rational)obj).numerator);
        }

        @Override
        public int hashCode(){
            int gcd = BigInteger.valueOf(numerator).gcd(BigInteger.valueOf(denominator)).intValue();
            if (gcd != 0) return Objects.hash(this.numerator/gcd,this.denominator/gcd);
            else return 0;
        }
    }

    //
    public int maxPoints(Point[] points) {
        if (points.length < 2) return 0;
        Map<Rational, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < points.length; i++){
            map.clear();
            int duplicate = 1;
            Point A = points[i];
            for (int j = 0; j < points.length; j++){
                if (i == j) continue;
                Point B = points[j];
                if (A.x == B.x && A.y == B.y){
                    duplicate++;
                    continue;
                }
                Rational scope = new Rational(A.y-B.y,A.x-B.x);
                if (map.containsKey(scope)){
                    map.put(scope,map.get(scope)+1);
                }else{
                    map.put(scope,1);
                }
            }
            if (map.size() == 0){
                max = Math.max(max,duplicate);
            }else{
                for (Rational key: map.keySet()){
                    max = Math.max(max,duplicate+map.get(key));
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Rational r1 = new Rational(0,0);
        Rational r2 = new Rational(-2,-2);
        Map<Rational, Integer> map = new HashMap<>();
        map.put(r1,2);

//        System.out.println(map.containsKey(r2));

        int gcd = BigInteger.valueOf(2).gcd(BigInteger.valueOf(3)).intValue();
        System.out.println(gcd);
    }
}
