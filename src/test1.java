import java.util.Arrays;

/**
 * Created by stameying on 1/4/16.
 */
public class test1 {

    public static void main(String[] args) {
        String str = "/he//hi///my/name////is xiaoran";
        String[] arr = str.split("/");
        System.out.println(Arrays.toString(arr));
    }
}