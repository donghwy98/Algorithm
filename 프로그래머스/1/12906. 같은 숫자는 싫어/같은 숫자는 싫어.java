import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<arr.length-1; i++) {
            if(arr[i]!=arr[i+1]) {
                list.add(arr[i]);
            }
            if(i==arr.length-2) {
                list.add(arr[i+1]);
            }
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}