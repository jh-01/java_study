import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int result = 0;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        buildWall(0);
        System.out.print(result);
    }

    private static void buildWall(int count){
        if(count == 3){
            spread();
            return;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    buildWall(count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void spread(){
        int[][] copyMap = new int[N][M];
        for(int i = 0; i < N; i++){
            copyMap[i] = map[i].clone();
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(copyMap[i][j] == 2){
                    dfs(copyMap, i, j);
                }
            }
        }

        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(copyMap[i][j] == 0){
                    count++;
                }
            }
        }
        result = Math.max(result, count);
    }

    private static void dfs(int[][] copyMap, int x, int y){
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (copyMap[nx][ny] == 0) {
                    copyMap[nx][ny] = 2;
                    dfs(copyMap, nx, ny);
                }
            }
        }
    }
}
