package src.first_round;

/**
 * Created by stameying on 12/21/15.
 */
public class UnionFind {

    int[] ids;
    int count;

    public UnionFind(int size){
        this.ids = new int[size];
        for (int i = 0; i < this.ids.length; i++){
            ids[i] = i;
        }
        this.count = size;
    }

    public boolean count(){
        return this.count();
    }

    public int find(int m){
        return ids[m];
    }

    public boolean areConnected(int m, int n){
        return find(m) == find(n);
    }

    public boolean union(int m, int n ){
        int source = find(m);
        int target = find(n);

        if (source != target){
            for (int i = 0; i < ids.length; i++){
                if (ids[i] == source){
                    ids[i] = target;
                }
            }
            count--;
            return true;
        }else{
            return false;
        }
    }
}
