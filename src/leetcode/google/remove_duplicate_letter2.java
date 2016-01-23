package leetcode.google;

import java.util.Stack;

/**
 * Created by stameying on 1/22/16.
 */
public class remove_duplicate_letter2 {

    public String removeDuplicateLetters(String s) {
        int[] freqMap = new int[256];
        for (int i = 0; i < s.length(); i++){
            freqMap[s.charAt(i)]++;
        }
        Stack<Character> stack = new Stack<Character>();
        boolean[] visited = new boolean[256];
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            freqMap[ch]--;
            if (visited[ch]) continue;
            while (!stack.isEmpty() && stack.peek() > ch && freqMap[stack.peek()] > 0){
                int temp = stack.pop();
                visited[temp] = false;
            }
            stack.push(ch);
            visited[ch]=true;
        }
        while (!stack.isEmpty()){
            builder.append(stack.pop());
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        remove_duplicate_letter2 test = new remove_duplicate_letter2();
        String s = "cbacabdaadacb";
        System.out.println(test.removeDuplicateLetters(s));
    }
}
