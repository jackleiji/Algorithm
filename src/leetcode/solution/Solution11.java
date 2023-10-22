public class Solution11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int area = 0;
        while (left<right){
            System.out.println(right-left);
            if(height[left]>height[right])
                area = Math.max(area,(right-left)*height[right]);
            else
                area = Math.max(area,(right-left)*height[left]);
            if(height[left]>height[right]) right--;
            else left++;
        }

        return area;
    }
}
