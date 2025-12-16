import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();
        
        int temp = arr[0];
        list.add(temp);
        for(int i = 1; i < arr.length; i++){
            if(temp == arr[i]) continue;
            else {
                list.add(arr[i]);
                temp = arr[i];
            }
        }
        
        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}