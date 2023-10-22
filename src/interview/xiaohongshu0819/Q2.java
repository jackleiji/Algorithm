package interview.xiaohongshu0819;

import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        //b = d q,p=q,d=q，n=u
        //w = vv,m=nn
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i=0;i<n;i++){
            String temp = scan.next();
            System.out.println(check(temp)?"YES":"NO");
        }
    }
    static boolean check(String str){
        int left = 0;
        int right = str.length()-1;
        while (left<right){
            char l = str.charAt(left);
            char r = str.charAt(right);
            if(l==r){
                left++;
                right--;
                continue;
            }else if((l=='b' && (r=='d' || r=='q' || r=='p'))||(r=='b' && (l=='d' || l=='p' || l=='q'))){//b = d q
                right--;
                left++;
                continue;
            }else if ((l=='p' && (r=='d' || r=='q'))||(r=='p'&& (l=='d' || l=='q'))){//p=q,d=p
                right--;
                left++;
                continue;
            }else if ((l=='d' &&  r=='q')||(r=='d'&& l=='q')){//p=q,d=p
                right--;
                left++;
                continue;
            }else if ((l=='n' && r=='u')||(l=='u'&&r=='n')){
                right--;
                left++;
                continue;
            } else if(l=='m' && (r=='n'||r=='u')){ //w = vv,m=nn
                right--;
                if(str.charAt(right)=='n'||str.charAt(right)=='u'){
                    right--;
                    left++;
                }else return false;
            }else if((l=='n'||l=='u') && r=='m'){
                left++;
                if(str.charAt(left)=='n'||str.charAt(left)=='u'){
                    right--;
                    left++;
                }else return false;
            }else if(l=='w' && r=='v'){
                right--;
                if(str.charAt(right)=='v'){
                    right--;
                    left++;
                }else return false;
            }else if(l=='v' && r=='w'){
                left++;
                if(str.charAt(left)=='v'){
                    right--;
                    left++;
                }else return false;
            }else {
                return false;
            }
        }
        return true;
    }
}