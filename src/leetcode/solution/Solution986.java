import java.util.*;

public class Solution986 {
//    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        //法一遍历
//        int index_first = 0;
//        int index_second = 0;
//        List<Integer[]> list = new LinkedList<>();
//        int len1 = firstList.length;
//        int len2 = secondList.length;
//        while (index_first<len1 && index_second<len2){
//            int[] firstBlock = firstList[index_first];
//            int[] secondBlock = secondList[index_second];
//
//            if(firstBlock[0]==secondBlock[1]){
//                list.add(new Integer[]{firstBlock[0],firstBlock[0]});
//                index_second++;
//            } else if(firstBlock[0]<secondBlock[1]){
//                if(firstBlock[0]<secondBlock[0]){
//                    if(firstBlock[1]<secondBlock[0]){
//                        index_first++;
//                        continue;
//                    }
//                    if(firstBlock[1]==secondBlock[1]){
//                        list.add(new Integer[]{secondBlock[0],firstBlock[1]});
//                        index_first++;
//                        index_second++;
//                    }else if(firstBlock[1]<secondBlock[1]){
//                        list.add(new Integer[]{secondBlock[0],firstBlock[1]});
//                        index_first++;
//                    }else {
//                        list.add(new Integer[]{secondBlock[0],secondBlock[1]});
//                        index_second++;
//                    }
//                }else {
//                    if(firstBlock[1]==secondBlock[1]){
//                        list.add(new Integer[]{firstBlock[0],firstBlock[1]});
//                        index_first++;
//                        index_second++;
//                    }
//                    else if(firstBlock[1]<secondBlock[1]){
//                        list.add(new Integer[]{firstBlock[0],firstBlock[1]});
//                        index_first++;
//                    }else {
//                        list.add(new Integer[]{firstBlock[0],secondBlock[1]});
//                        index_second++;
//                    }
//                }
//            }else{
//                index_second++;
//            }
//        }
//        return list.toArray(new int[list.size()][]);

//    }
    //法二
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i<A.length && j<B.length) {
            int left = Math.max(A[i][0], B[j][0]);
            int right = Math.min(A[i][1], B[j][1]);
            if (left <= right) list.add(new int[] {left, right});
            if (A[i][1] <= B[j][1]) i++;
            else j++;
        }
        return list.toArray(new int[list.size()][]);
    }
}
