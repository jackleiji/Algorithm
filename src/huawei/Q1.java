package huawei;

import java. util.*;
//10 20 50 80 1 1
//1 1 1 3 6 89 10
public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
//        String str = scanner.nextLine();
        String str ="10 20 50 80 1 1";
        String[] arr = str.split(" ");
        //链表遍历
        List<Integer> list = new ArrayList();
        for(int i=0;i<arr.length;i++){
            int len = list.size();
            int target = Integer.parseInt(arr[i]);
            //写入第一个数
            if(len==0){
                list.add(target);
                continue;
            }
            int site = findTarget(list,target);
            if(len==site) {
                list.add(target);
                continue;
            }
            while (len!=site){
                for(int j=len-1;j>=site;j--){
                    list.remove(j);
                }
                len = list.size();
                target *= 2;
                site = findTarget(list,target);
            }
            list.add(target);
        }
        System.out.println(Arrays.toString(list.toArray()));
    }
    public static int findTarget(List<Integer> list,Integer target){
        int len = list.size();
        int sum = 0;
        for(int i=len-1;i>=0;i--){
            sum += list.get(i);
            if(target==sum){
                return i;
            }
        }
        return len;
    }
}
