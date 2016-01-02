/**
 * Created by stameying on 1/1/16.
 */

class NBComparator{
    public int cmp(String a, String b){
        return -1;
    }
}
public class nuts_and_bolts_problems {

    /**
     * public class NBCompare {
     *     public int cmp(String a, String b);
     * }
     * You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
     * if "a" is bigger than "b", it will return 1, else if they are equal,
     * it will return 0, else if "a" is smaller than "b", it will return -1.
     * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
     */
    public class Solution {
        /**
         * @param nuts: an array of integers
         * @param bolts: an array of integers
         * @param compare: a instance of Comparator
         * @return: nothing
         */
        public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
            // write your code here
            if (nuts == null || nuts.length <= 1) return;
            // System.out.println("bolts arr="+Arrays.toString(nuts));
            // System.out.println("bolts arr="+Arrays.toString(bolts));
            sort(nuts,bolts,compare,0,bolts.length-1);

        }

        public void sort(String[] nuts, String[] bolts, NBComparator compare, int left, int right){
            if (left >= right) return;
            String pivot = bolts[left];
            int index = partition(nuts,left,right,pivot,compare);
            //  System.out.println("index = " + index + " pivot="+pivot);
            pivot = nuts[index];
            // System.out.println("!!");
            // System.out.println("bolts arr="+Arrays.toString(bolts));
            int index2 = partition2(bolts,left,right,pivot,compare);
            // System.out.println("index2 = " + index2 + " pivot="+pivot);
            sort(nuts,bolts,compare,left,index-1);
            sort(nuts,bolts,compare,index+1,right);
        }

        public int partition(String[] arr, int left, int right, String pivot, NBComparator compare){
            int i = left;
            for (int j = left; j < right; j++){
                if (compare.cmp(arr[j],pivot) == -1){
                    swap(arr,i,j);
                    i++;
                }else if (compare.cmp(arr[j],pivot) == 0){
                    // move pivot to the highest position so that later on we can swap it back to its correct position
                    swap(arr,j,right);
                    j--;
                }
            }
            swap(arr,i,right);
            return i;
        }

        public int partition2(String[] arr, int left, int right, String pivot, NBComparator compare){
            int i = left;
            for (int j = left; j < right; j++){
                // System.out.println("res arr="+Arrays.toString(arr));
                // System.out.println("i="+i+" j="+j);
                // System.out.println("word="+arr[j]+"pivot="+pivot+"res="+compare.cmp(pivot,arr[j]));
                if (compare.cmp(pivot,arr[j]) == 1){
                    swap(arr,i,j);
                    i++;
                }else if (compare.cmp(pivot,arr[j]) == 0){
                    // move pivot to the highest position so that later on we can swap it back to its correct position
                    swap(arr,j,right);
                    j--;
                }
                // System.out.println("i="+i+" j="+(j+1));
            }
            swap(arr,i,right);
            // System.out.println("res arr="+Arrays.toString(arr));
            return i;
        }

        public void swap(String[] arr, int left, int right){
            String temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
        }

    };
}
