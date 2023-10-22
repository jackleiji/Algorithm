package interview.pinan1009;

public class Q1 {
    public static void main(String[] args) {
        
    }
    public int cutRope (int n) {
        // write code here
        if(n<2){
            return 0;
        }else if(n == 2){
            return 1;
        }else if(n==3){
            return 2;
        }
        //贪心算法，看每次可以拆分出优先3，其次2，若余数为1，说明3+1=4，可拆分2*2
        return getRes(n);
    }
    public int getRes(int n){
        //优先拆3，之后拆2，若余数为1，说明3+1=4，可拆分2*2；
        int splitTimes3 = n/3;
        int splitTimes2 = (n%3)/2;
        if(n%3==1){
            splitTimes3--;
            splitTimes2+=2;
        }
        return (int) Math.pow(3,splitTimes3) * (int)Math.pow(2,splitTimes2);
    }

}
