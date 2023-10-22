package interview.BaiduViewer;

import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();

        StringBuilder s = new StringBuilder();
        String color = "red";
        int site = 0;

        while (x>0){
            int sum = 0;
            int i =1;
            while (sum+i<=x){
                sum+=i;
                i++;
                s.append(color.charAt(site));
            }
            x -= sum;
            site = (site+1)%3;
        }
        System.out.println(s);
    }
}
