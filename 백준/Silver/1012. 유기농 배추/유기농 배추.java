import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int N;
    private static int M;
    private static int K;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    private static void bfs(int startX, int startY){
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while(!q.isEmpty()){
            int[] temp = q.poll();
            int tx = temp[0];
            int ty = temp[1];

            for(int i = 0; i < 4; i++){
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M){
                    continue;
                }

                if(!visited[nx][ny] && map[nx][ny] == 1){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();

        for(int t = 0; t < T; t++){
            int answer = 0;
            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();

            map = new int[N][M];
            visited = new boolean[N][M];
            for(int i = 0; i < K; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                sc.nextLine();
                map[y][x] = 1;
            }

            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(!visited[i][j] && map[i][j] == 1){
                        answer++;
                        bfs(i, j);
                    }
                    
                }
            }
            System.out.println(answer);
        }
    }
}
