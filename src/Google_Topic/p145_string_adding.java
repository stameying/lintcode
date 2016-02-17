package Google_Topic;

/**
 * Created by stameying on 2/16/16.
 */
public class p145_string_adding {

    public static String add(String num1, String num2){
        StringBuilder builder1 = new StringBuilder(num1).reverse();
        StringBuilder builder2 = new StringBuilder(num2).reverse();
        StringBuilder res = new StringBuilder();
        int carry = 0;
        for (int i = 0, j = 0; i < builder1.length() || j < builder2.length(); i++,j++){
            int digit1 = i < builder1.length()?builder1.charAt(i)-'0':0;
            int digit2 = j < builder2.length()?builder2.charAt(j)-'0':0;
            int sum = digit1+digit2+carry;
            if (sum >= 10) carry = 1;
            sum %= 10;
            res.append(sum);
        }
        if (carry == 1) res.append(1);
        return res.reverse().toString();
    }

    public static String decimaladd(String num1, String num2){
        while (num1.length() < num2.length()) num1+="0";
        while (num2.length() < num1.length()) num2+="0";
        StringBuilder builder1 = new StringBuilder(num1).reverse();
        StringBuilder builder2 = new StringBuilder(num2).reverse();
        StringBuilder res = new StringBuilder();
        int carry = 0;
        for (int i = 0, j = 0; i < builder1.length() || j < builder2.length(); i++,j++){
            int digit1 = i < builder1.length()?builder1.charAt(i)-'0':0;
            int digit2 = j < builder2.length()?builder2.charAt(j)-'0':0;
            int sum = digit1+digit2+carry;
            if (sum >= 10) carry = 1;
            sum %= 10;
            res.append(sum);
        }
        if (carry == 1) res.append(1);
        return res.reverse().toString();
    }


    public static String decimalAddition(String num1, String num2){
        int decimalPos1 = 0, decimalPos2 = 0;
        decimalPos1 = num1.indexOf(".");
        decimalPos2 = num2.indexOf(".");
        if (decimalPos1 == -1 && decimalPos2 == -1) return add(num1,num2);
        else if (decimalPos1 == -1 && decimalPos2 != -1){
            String part1 = add(num1,num2.substring(0,decimalPos2));
            String part2 = num2.substring(decimalPos2+1);
            return part1+"."+part2;
        }else if (decimalPos1 != -1 && decimalPos2 == -1){
            String part1 = add(num1.substring(0,decimalPos1),num2);
            String part2 = num1.substring(decimalPos1+1);
            return part1+"."+part2;
        }else{
            String part1 = add(num1.substring(0,decimalPos1),num2.substring(0,decimalPos2));
            String part2 = decimaladd(num1.substring(decimalPos1+1),num2.substring(decimalPos2+1));
            if (part2.length() > Math.max(num1.substring(decimalPos1+1).length(),num2.substring(decimalPos2+1).length())){
                part2 = part2.substring(1);
                return add(part1,"1")+"."+part2;
            }
            return part1+"."+part2;
        }
    }

    public static void main(String[] args) {
        String num1 = "3.600";
        String num2 = "0.37";
        System.out.println(decimalAddition(num1,num2));

//        System.out.println("2".indexOf("."));
    }
}
