import java.io.*;
import java.util.*;

public class Main {

    private static int[][] map;
    private static boolean[][] visited;
    private static int M;
    private static int N;

    private static void bfs(int x, int y){
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] temp = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];
                if(nx > -1 && nx < N && ny > -1 && ny < M){
                    if(!visited[nx][ny] && map[nx][ny] == 1){
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
            
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int i = 0; i < T; i++){
            int result = 0;
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];

            for(int j = 0; j < K; j++){
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                map[Y][X] = 1;
            }

            for(int x = 0; x < N; x++){
                for(int y = 0; y < M; y++){
                    if(!visited[x][y] && map[x][y] == 1){
                        bfs(x, y);
                        result++;
                    }
                }
            }

            System.out.println(result);
        }

    }

}