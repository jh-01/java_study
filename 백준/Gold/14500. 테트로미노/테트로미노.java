import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int result = 0;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visited[i][j] = false;

                checkT(i, j); // ㅗ 모양
            }
        }

        System.out.println(result);
    }

    private static void dfs(int x, int y, int depth, int sum){
        if(depth == 4){
            result = Math.max(result, sum);
            return;
        }

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= N || ny < 0 | ny >= M) continue;

            if(!visited[nx][ny]){
                visited[nx][ny] = true;
                dfs(nx, ny, depth + 1, sum + map[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }

    // ㅗ 모양 처리
    private static void checkT(int x, int y){
        int sum = map[x][y];
        int min = Integer.MAX_VALUE;
        int count = 0;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

            count++;
            sum += map[nx][ny];
            min = Math.min(min, map[nx][ny]);
        }

        if(count == 4){
            sum -= min; // + 모양에서 가장 작은거 하나 빼서 ㅗ 만들기
        }

        result = Math.max(result, sum);
    }
}
