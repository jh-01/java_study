import java.util.*;

class Solution {
    int[] parent;
    
    public int solution(int n, int[][] costs) {
        int cost = 0;       
        Arrays.sort(costs, (a, b) -> {return a[2] - b[2];});
        
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        for(int i = 0; i < costs.length; i++){
            int[] temp = costs[i];
            int a = temp[0];
            int b = temp[1];
            
            if(union(a, b)){
                cost += temp[2];
            }
        }
        return cost;
    }
    
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
}