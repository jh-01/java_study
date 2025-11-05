import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static int N;
    private static int M;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static int bfs(int startX, int startY){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while(!q.isEmpty()){
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M){
                    continue;
                }

                if(!visited[nx][ny] && map[nx][ny] == 1){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    map[nx][ny] = map[x][y] + 1;
                }
            }
        }

        return map[N - 1][M - 1];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            String s = sc.nextLine();
            for(int j = 0; j < M; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }
}
