import java.util.*;

class Solution {
    private boolean[][] visited;
    private int N, M;
    
    private int bfs(int x, int y, int[][] land, Set<Integer> cols){
        int count = 1;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{x, y});
        visited[x][y] = true;
        cols.add(y); // 시작 열 저장

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i = 0; i < 4; i++){
                int nX = cur[0] + dx[i];
                int nY = cur[1] + dy[i];

                if(nX < 0 || nX >= N || nY < 0 || nY >= M)
                    continue;

                if(!visited[nX][nY] && land[nX][nY] == 1){
                    visited[nX][nY] = true;
                    q.add(new int[]{nX, nY});
                    cols.add(nY);   // 열 저장
                    count++;
                }
            }
        }
        return count;
    }
    
    public int solution(int[][] land) {
        N = land.length;
        M = land[0].length;
        visited = new boolean[N][M];
        
        int[] oil = new int[M]; // 열별 석유량 누적
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(land[i][j] == 1 && !visited[i][j]){
                    Set<Integer> cols = new HashSet<>();
                    int size = bfs(i, j, land, cols);

                    // 이 덩어리가 포함된 열에만 size 더함
                    for(int col : cols){
                        oil[col] += size;
                    }
                }
            }
        }

        int answer = 0;
        for(int v : oil){ // max 값 구하기
            answer = Math.max(answer, v);
        }
        
        return answer;
    }
}