package EPI.stack_and_queue;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Stack;

/**
 * Created by stameying on 1/28/16.
 */
public class building_subset {
    public static Stack<BuildingWithHeight> bexamineBuildingWithHeight(InputStream sin) throws ClassNotFoundException,IOException{
        int buildingIdx = 0;
        int height;
        Stack<BuildingWithHeight> stack = new Stack<>();
        try{
            ObjectInputStream osin = new ObjectInputStream(sin);
            while (true){
                height = (Integer)osin.readObject();
                while (!stack.isEmpty() && (stack.peek().height <= height)) stack.pop();
                stack.push(new BuildingWithHeight(buildingIdx++,height));
            }

        }catch(IOException e){

        }
        return stack;
    }
}

class BuildingWithHeight{
    int id;
    int height;

    public BuildingWithHeight(int id, int height) {
        this.id = id;
        this.height = height;
    }
}
