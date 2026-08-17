import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        
        int i = 0;
        int n = arr.length;
        int num = -1;
        while(i < n){
            if(arr[i] != num){
                list.add(arr[i]);
                num = arr[i];
            }
            i++;
        }
        
        int[] answer = new int[list.size()];
        for(int j = 0; j < list.size(); j++){
            answer[j] = list.get(j);
        }
        
        return answer;
    }
}