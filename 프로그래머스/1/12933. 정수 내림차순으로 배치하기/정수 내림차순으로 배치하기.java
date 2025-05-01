import java.util.stream.*;
import java.util.Comparator;

class Solution {
    public long solution(long n) {
        long answer = 0;
        Integer[] array =  Stream.of(String.valueOf(n).split(""))
            .map(Integer::parseInt) 
            .sorted(Comparator.reverseOrder())
            .toArray(Integer[]::new);
        for(int i = 0; i < array.length; i++){
            answer = answer * 10 + array[i];
        }
        return answer;
    }
}