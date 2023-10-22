import java.util.*;

public class MinStack {
    int[] arr = new int[30000];
    int index = 0;
    int min_val = Integer.MAX_VALUE;
    public MinStack() {

    }

    public void push(int val) {
        arr[index] = val;
        if(arr[index]<min_val){
            min_val = arr[index];
        }
        index++;
    }

    public void pop() {
        if(index<=0)
            return;
        if(arr[index-1]==min_val){
            int[] asort = Arrays.copyOf(arr,index);
            Arrays.sort(asort);
            min_val = asort[0];
        }
        index--;
    }

    public int top() {
        if(index<=0)
            return -1;
        return arr[index-1];
    }

    public int getMin() {
        return min_val;
    }
}
