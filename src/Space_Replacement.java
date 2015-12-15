/**
 * Created by stameying on 12/14/15.
 */
public class Space_Replacement {
    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public static int replaceBlank(char[] string, int length) {
        // Write your code here
        int spaceCount = 0;
        for (int i = 0; i < length; i++){
            if (string[i] == ' ') spaceCount++;
        }
        int trueLen = length + 2 * spaceCount;

        int curPos = trueLen-1;
        for (int i = length-1; i >= 0; i--){
            if (string[i] != ' '){
                string[curPos--] = string[i];
            }else{
                string[curPos-2] = '%';
                string[curPos-1] = '2';
                string[curPos] = '0';
                curPos -= 3;
            }
        }
        return trueLen;
    }

    public static void main(String[] args) {
        String str = "hello world ";
        char[] chars = str.toCharArray();
        System.out.println(replaceBlank(chars, 12));;
    }
}
