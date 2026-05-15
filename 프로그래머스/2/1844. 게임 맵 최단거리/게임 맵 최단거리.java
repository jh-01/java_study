import java.util.*;

class Solution {
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};
    private boolean[][] visit;
    
    public int solution(int[][] maps) {
        visit = new boolean[maps.length][maps[0].length];
        return bfs(maps, 0, 0);
    }
    
    private int bfs(int[][] maps, int x, int y){
        int N = maps.length;
        int M = maps[0].length;
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{x, y});
        visit[x][y] = true;
        while(!q.isEmpty()){
            int[] temp = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];
                
                if(nx < 0 || nx >= N || ny < 0 || ny >= M || maps[nx][ny] == 0) continue;
                
                if(!visit[nx][ny]){
                    visit[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    maps[nx][ny] = maps[temp[0]][temp[1]] + 1;
                }
            }
        }
        
        if(!visit[N - 1][M - 1]) return -1;
        return maps[N-1][M-1];
    }
}