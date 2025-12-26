import java.util.*;

class Solution {
    public int solution(String word) {
        int answer = 0;
        int[] nums = {781, 156, 31, 6, 1};
        Map<Character, Integer> map = new HashMap<>(); 
        
        // 문자에 맞는 숫자 저장 
        map.put('A', 0); 
        map.put('E', 1); 
        map.put('I', 2); 
        map.put('O', 3); 
        map.put('U', 4);
        
        // 몇자리 글자인지 확인
        int count = word.length();
        
        // 계산
        for(int i = 0; i < count; i++){
            char c = word.charAt(i);
            int x = map.get(c);
            answer += x * nums[i] + 1;
        }
        
        return answer;
    }
}