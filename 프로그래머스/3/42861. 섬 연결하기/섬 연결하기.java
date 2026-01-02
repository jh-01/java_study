import java.util.*;

class Solution {
    private int[] parent;
    
    private int find(int x){
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    private boolean union(int x, int y){
        x = find(x);
        y = find(y);
        
        if(x == y) return false; // 이미 연결됨
        parent[y] = x;
        return true;
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        // cost 기준으로 정렬
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        
        // 리스트에 값 넣기
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        for(int i = 0; i < costs.length; i++){
            int x = costs[i][0];
            int y = costs[i][1];
            int cost = costs[i][2];
            
            // 연결됐는지 확인
            if(union(x, y)){
                answer += cost;
            }
        }
        return answer;
    }
}