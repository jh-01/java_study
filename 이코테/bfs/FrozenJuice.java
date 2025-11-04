package 이코테.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FrozenJuice {

    private static int n;
    private static int m;
    private static int[][]map;
    private static boolean[][] visited;
    
     // 상, 하, 좌, 우 이동 방향
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    private static void bfs(int startX, int startY){
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
             // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 밖이면 패스
                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;

                // 0(구멍)이고 아직 방문 안했으면
                if (map[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            String s = sc.nextLine();
            for(int j = 0; j < m; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 방문하지 않았고, 구멍(0)이라면 BFS 수행
                if (map[i][j] == 0 && !visited[i][j]) {
                    bfs(i, j);
                    result++;
                }
            }
        }

        System.out.println(result);
        sc.close();
    }
}
