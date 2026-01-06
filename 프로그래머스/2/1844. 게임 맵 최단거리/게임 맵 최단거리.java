import java.util.*;

class Solution {
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};
    private boolean[][] isVisited;
    private int N;
    private int M;
    
    private int bfs(int x, int y, int[][] maps){
        int depth = 1;
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{x, y, depth});
        isVisited[x][y] = true;
        while(!q.isEmpty()){
            int[] temp = q.poll();
            int tx = temp[0];
            int ty = temp[1];
            depth = temp[2];
            
            if(tx == N - 1 && ty == M - 1) return depth;
            
            for(int i = 0; i < 4; i++){
                int nx = tx + dx[i];
                int ny = ty + dy[i];
                
                // 범위 벗어나는 경우
                if(nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                if(maps[nx][ny] == 1 && !isVisited[nx][ny]){
                    q.offer(new int[]{nx, ny, depth + 1});
                    isVisited[nx][ny] = true;
                }
            }
        }
        
        if(!isVisited[N - 1][M - 1]) return -1;
        return depth;
    }
    
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        isVisited = new boolean[N][M];
        
        return bfs(0, 0, maps);
    }
}