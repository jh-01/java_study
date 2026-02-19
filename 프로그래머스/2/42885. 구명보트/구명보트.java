import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int N = people.length;
        int answer = 0;
        
        Arrays.sort(people);
        
        int i = 0;
        int j = N - 1;
        while(i <= j){
            if(people[i] + people[j] <= limit){
                i++;
            }
            j--;
            answer++;
        }
        
        return answer;
    }
}