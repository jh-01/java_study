import java.util.*;

class Solution {
    int[] p;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        p = new int[n];
        
        for(int i = 0; i < n; i++){
            p[i] = i;
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j && computers[i][j] == 1){
                    union(i, j);
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < n; i++){
            set.add(find(i));
        }
        
        return set.size();
    }
    
    
    private int find(int x){
        if(p[x] == x) return x;
        return p[x] = find(p[x]);
    }
    
    private void union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        if(pa != pb){
            p[pb] = pa;
        }
    }
}