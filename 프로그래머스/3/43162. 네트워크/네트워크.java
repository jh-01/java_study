import java.util.*;

class Solution {
    private boolean[] isVisited;
    
    private void bfs(int start, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(start);
        while(!q.isEmpty()){
            int x = q.poll();
            isVisited[x] = true;
            
            for(int y = 0; y < computers.length; y++){
                if(!isVisited[y] && computers[x][y] == 1){
                    q.offer(y);
                }
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        isVisited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(!isVisited[i]) {
                bfs(i, computers);
                answer++;
            }
        }
        
        return answer;
    }
}