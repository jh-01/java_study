import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static int N;
    private static int M;
    private static int zeroCount = 0;

    private static int[][] maps;
    private static Queue<int[]> q = new LinkedList<>();
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    private static int bfs(){
        int maxCount = 0;
        while (!q.isEmpty()) {
            int[]temp = q.poll();
            int tx = temp[0];
            int ty = temp[1];

            for(int i = 0; i < 4; i++){
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M){
                    continue;
                }

                if(maps[nx][ny] == 0){
                    maps[nx][ny] = maps[tx][ty] + 1;
                    q.add(new int[] {nx, ny});
                    zeroCount--;
                    maxCount  = maxCount < maps[nx][ny]? maps[nx][ny] : maxCount;
                }
            }
        }
        return maxCount;
    }

    public static void main(String[] args){
        int maxCount = 0;
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        sc.nextLine();

        maps = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                maps[i][j] = sc.nextInt();
                if(maps[i][j] == 0) zeroCount++;
                if(maps[i][j] == 1){
                    q.add(new int[]{i, j});
                }
            }
            sc.nextLine();
        }

        if(zeroCount == 0){
            System.out.println(0);
            return;
        }

        int count = bfs();
        if(zeroCount > 0) System.out.println(-1);
        else System.out.println(count - 1);
    }
}