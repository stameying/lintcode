import java.util.Arrays;

/**
 * Created by stameying on 12/12/15.
 */
public class quickSort {

    public void sort(int[] input){
        quickSort(input,0,input.length-1);
    }

    public void quickSort(int[] input, int left, int right){
        if (left >= right) return;
        int pivot = input[left];
        int i = left, j = right;
        while (i != j){
            while ( i < j && input[j] >= pivot) j--;
            while ( i < j && input[i] <= pivot) i++;
            if ( i < j){
                swap(input,i,j);
            }
        }
        swap(input,left,i);
        quickSort(input,left,i-1);
        quickSort(input,i+1,right);
    }

    public void quickSort2(int[] input, int left, int right){
        if (left >= right) return;
        int pivot = input[left];
        int i = left, j = right;
        while (i <= j){
            while ( i < j && input[j] >= pivot) j--;
            while ( i < j && input[i] <= pivot) i++;
            if ( i <= j){
                swap(input,i,j);
                i++;
                j--;
            }
        }
        swap(input,left,i);
        if (j > left) quickSort(input,left,j);
        if (i < right) quickSort(input,i,right);
    }

    public void swap(int[] input, int left, int right){
        int temp = input[left];
        input[left] = input[right];
        input[right] = temp;
    }

    public static void main(String[] args) {
        quickSort sortMethod = new quickSort();
        int[] input = {4,2,5,1,3,7};
        int[] input2 = {7,9,4,5};
        sortMethod.sort(input2);
        String output = Arrays.toString(input2);
        System.out.print(output);
    }
}
