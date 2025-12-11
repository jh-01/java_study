import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int N = clothes.length;
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i= 0; i < N; i++){
            map.compute(clothes[i][1], (key, value) -> value == null ? 1 : value + 1);
        }
        
        for(int v : map.values()){
            answer *= (v + 1);
        }
        return answer - 1;
    }
}