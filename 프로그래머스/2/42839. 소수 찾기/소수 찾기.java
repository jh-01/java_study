import java.util.*;
import java.util.stream.Collectors;

class Solution {
    HashSet<Integer> hashSet = new HashSet<>();
    boolean[] isUsed;
    
    private void dfs(String s, String numbers){
        if(s.length() > 0){
            hashSet.add(Integer.valueOf(s));
        }
        
        for(int i = 0; i < numbers.length(); i++){
            if(!isUsed[i]){
                isUsed[i] = true;
                dfs(s + numbers.charAt(i), numbers);
                isUsed[i] = false;
            }
        }
    }
    
    public int solution(String numbers) {
        int answer = 0;
        isUsed = new boolean[numbers.length()];
        
        // 모든 조합을 만든다 (중복 제거 필요)
        dfs("", numbers);
        
        // 개별 검사 
        for (int temp : hashSet) {
            boolean flag = true;
            if(temp < 2) continue;
            for(int j = 2; j <= Math.sqrt(temp); j++){
                if(temp % j == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }
        
        return answer;
    }
}