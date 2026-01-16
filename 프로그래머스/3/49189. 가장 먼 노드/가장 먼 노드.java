import java.util.*;

class Solution {
    private int M;
    private boolean[] visited;
    private List<Integer>[] graph;
    private int[] dp;
    
    private void bfs(){
        int idx = 0;
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(0);
        dp[0] = 0;
        visited[0] = true;
        while(!q.isEmpty()){
            int temp = q.poll();
            
            for(int next : graph[temp]){
                if(!visited[next]){
                    visited[next] = true;
                    dp[next] = dp[temp] + 1;
                    q.offer(next);
                }
            }
        }
    }
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        M = edge.length;
        visited = new boolean[n];
        graph = new ArrayList[n];
        dp = new int[n];
        
        // 초기화
        for(int i = 0; i < n; i++){
            dp[i] = 0;
        }
        
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] e : edge){
            int a = e[0] - 1;
            int b = e[1] - 1;
            graph[a].add(b);
            graph[b].add(a);
        }
        
        bfs();
        
        // 최댓값 찾기
        int maxN = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            maxN = Math.max(maxN, dp[i]);
        }
        
        for(int i = 0; i < n; i++){
            if(dp[i] == maxN) answer++;
        }
        
        return answer;
    }
}