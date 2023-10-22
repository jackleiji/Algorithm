package interview.weizongBank;

import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        for(int i=n-1;i>=0;i--){
            if(!set.contains(arr[i])){
                set.add(arr[i]);
                stack.push(arr[i]);
            }
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
