package 이코테.dfs;

import java.util.Scanner;

public class FrozenJuice {

    private static int n;
    private static int m;
    private static int[][] map;

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    private static boolean dfs(int x, int y){
        if(x < 0 || x >= n || y < 0 || y >= m){
            return false;
        }

        if (map[x][y] == 0) {
            map[x][y] = 1; // 방문 처리

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                dfs(nx, ny);
            }
            return true;
        }
        return false;
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

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(dfs(i, j) == true){
                    result++;
                }
            }
        }

        System.out.println(result);
        sc.close();
    }
}
