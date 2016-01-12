package snapchat;

/**
 * Created by stameying on 1/11/16.
 */
public class map_using_bst {
    treeNode root;
    int size;
    // default constructor
    public map_using_bst(){
        root = null;
        size = 0;
    }

    /**
     * Param: integer represent key
     * Return: the value corresponding to the key, return -1 if key not found
     * */
    public Integer get(Integer key){
        treeNode cur = root;
        while (cur != null){
            if (cur.val < key){
                cur = cur.right;
            }else if (cur.val > key){
                cur = cur.left;
            }else{
                // find
                return cur.val;
            }
        }
        return -1;
    }


    /**
     *
     * */
    public void put(Integer key, Integer val){
        insertNode(root,key,val);
        this.size++;
    }


    public void insertNode(treeNode node, int key, int val){
        if (node == root && root == null){
            root = new treeNode(key,val);
            return;
        }else{
            if (node.key < key){
                // insert to right
                if (node.right != null) insertNode(node.right,key,val);
                else{
                    node.right = new treeNode(key,val);
                }
            }else{
                // insert to left
                if (node.left != null) insertNode(node.left,key,val);
                else{
                    node.left = new treeNode(key,val);
                }
            }
        }
    }

    public int size(){
        return this.size();
    }

    public static void main(String[] args) {
        map_using_bst map = new map_using_bst();
        map.put(2,2);
        map.put(3,3);
        System.out.println(map.get(1));
        System.out.println(map.get(2));
    }
}

class treeNode{
    int key;
    int val;
    treeNode left,right;
    public treeNode(int key, int val){
        this.key = key;
        this.val = val;
        left = null;
        right = null;
    }
}
