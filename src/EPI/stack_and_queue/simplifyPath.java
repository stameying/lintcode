package EPI.stack_and_queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by stameying on 1/28/16.
 */
public class simplifyPath {

    public String simplifyPath(String path) {
        // method1
        List<String> res = new ArrayList<String>();
        String[] symbols = path.split("/");
        for (String token: symbols){
            if (token.length() == 0) continue;
            if (token.length() == 1 && token.charAt(0) == '.'){
                // case '.':
                continue;
            }else if (token.length() == 2 && "..".equals(token)){
                // case "..": go back to parent
                if (res.size() > 0) res.remove(res.size()-1);
                continue;
            }else{
                // directory
                res.add(token);
            }
        }
        if (res.size() == 0) return "/";
        StringBuilder builder = new StringBuilder();
        for (String str: res){
            builder.append("/").append(str);
        }
        return builder.toString();
    }

    /**
     * Using stack
     * */
    public String simplifyPath2(String path) {
        // method2
        Stack<String> stack = new Stack<>();
        String[] symbols = path.split("/");
        for (String token: symbols){
            if (token.length() == 0) continue;
            if (token.length() == 1 && token.charAt(0) == '.'){
                // case '.':
                continue;
            }else if (token.length() == 2 && "..".equals(token)){
                // case "..": go back to parent
                if (!stack.isEmpty()) stack.pop();
                continue;
            }else{
                // directory
                stack.push(token);
            }
        }
        if (stack.isEmpty()) return "/";
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()){
            builder.insert(0,"/"+stack.pop());
        }
        return builder.toString();
    }
}
