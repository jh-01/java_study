import java.util.*;

class Solution {
    private int max = 0;
    private boolean[] visited;
    private int[][] dungeon;
    
    private void dfs(int k, int count){
        max = Math.max(max, count);
        
        for(int i = 0; i < dungeon.length; i++){
            if(!visited[i] && k >= dungeon[i][0]){
                visited[i] = true;
                dfs(k - dungeon[i][1], count + 1);
                visited[i] = false;
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        dungeon = dungeons;
        visited = new boolean[dungeon.length];
        
        dfs(k, 0);
        return max;
    }
}