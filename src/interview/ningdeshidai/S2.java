package interview.ningdeshidai;

import java.util.*;

public class S2 {
    Map<Character,Integer> map = new HashMap<>();
    StringBuilder sb = new StringBuilder();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        map.put(ch,map.getOrDefault(ch,0)+1);
        sb.append(ch);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
//        Iterator<Map.Entry<Character,Integer>>entry = map.entrySet().iterator();
//        while (entry.hasNext()){
//            Map.Entry<Character,Integer> e = entry.next();
//            System.out.println(e.getValue()+" "+e.getKey());
//            System.out.println("----------------------");
//        }
        System.out.println(sb);
        for(int i=0;i<sb.length();i++){
            if(map.get(sb.charAt(i))==1){
                return sb.charAt(i);
            }
        }
        return '#';
    }
}
