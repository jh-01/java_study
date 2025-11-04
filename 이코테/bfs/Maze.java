package 이코테.bfs;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Maze {
    private static int n;
    private static int m;
    private static int[][] map;

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    private static int bfs(int startX, int startY){
        Queue<int[]> q = new LinkedList();
        int[][] dist = new int[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                dist[i][j] = -1;
            }
        }

        q.offer(new int[]{startX, startY});
        dist[startX][startY] = 1;

        while (!q.isEmpty()) {
            int[] pop = q.poll();
            int x = pop[0];
            int y = pop[1];

            if(x == n - 1 && y == m - 1){
                return dist[x][y];
            }

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny =  y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m){
                    continue;
                }
                if(map[nx][ny] == 0) continue;

                if(dist[nx][ny] == -1){
                    q.offer(new int[]{nx, ny});
                    dist[nx][ny] = dist[x][y] + 1;
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        map = new int[n][m];
        
        for(int i = 0; i < n; i++){
            String s = sc.nextLine();
            for(int j = 0; j < m; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }
}
