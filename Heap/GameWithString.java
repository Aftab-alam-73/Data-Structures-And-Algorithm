import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
public class GameWithString {
     static int minValue(String s, int k){
     HashMap<Character,Integer>map=new HashMap<>();
     PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
     for(int i=0;i<s.length();i++){
         if(map.containsKey(s.charAt(i))){
             map.put(s.charAt(i),map.get(s.charAt(i))+1);
         }else{
             map.put(s.charAt(i),1);
         }
     }
     for(char key:map.keySet()){
         pq.add(map.get(key));
     }
     while(k!=0){
         int num=pq.poll();
         pq.add(num-1);
         k--;
     }
     int ans=0;
     while(!pq.isEmpty()){
         ans+=Math.pow(pq.poll(),2);
     }
     return ans;
    }

    public static void main(String[] args) {
        String s="abccc";
        System.out.println(minValue(s, 1));
    }
}
