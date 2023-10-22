package leetcode.solution;

public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix.length;
        for(int i=0;i<len;i++){
            if(binarySearch(matrix[i],target)) return true;
        }

        return false;
    }
    public boolean binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;

        while (left<=right){
            int mid = (left+right)/2;

            if(arr[mid] == target) return true;
            else if(arr[mid] < target){
                left = mid+1;
            }else if(arr[mid] > target){
                right = mid-1;
            }
        }
        return false;
    }
}
