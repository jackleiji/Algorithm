package interview.huawei0920;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        //nums[n],未到达时发送
        //报文序号sn，按照发送顺序小到大排序
        //sn不连续且可能相同，
        //nums采用循环覆盖，满了后从头部继续填充
        //假设需要重发的报文sn，找出sn的报文
        //在数组的开始和结束位置
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        int minSite = 0;
        int minData = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            nums[i] = in.nextInt();
            if(nums[i]<minData){
                minData=nums[i];
                minSite = i;
            }
        }
        int target = in.nextInt();
        int tempSite = minSite;
        int startData = -1;
        int endData = -1;
        int count = 0;
        for(int i=0;i<n;i++){
            int temp = (tempSite+i)%n;
            if(nums[temp] == target && count==0){
                count++;
                startData = temp;
                endData = temp;
            }
            if(nums[temp] == target){
                count++;
                endData = temp;
            }
            if(nums[temp]>target){
                break;
            }
        }
        System.out.println(startData);
        System.out.println(endData);
    }
}
//7
//4 4 7 8 2 3 4
//47 8 0 1 2 4 5