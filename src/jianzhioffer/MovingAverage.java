package jianzhioffer;
//Solution41
public class MovingAverage {
    int s;
    int len = 0;
    int tail = 0;
    int[] arr;
    double sum = 0;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        s=size;
        arr = new int[size];
    }

    public double next(int val) {
        if(len<s){
            arr[len] = val;
            len++;
            sum+=val;
            return sum/len;
        }
        tail %= s;
        sum += (val-arr[tail]);
        arr[tail] = val;
        tail++;
        return sum/len;
    }
}
