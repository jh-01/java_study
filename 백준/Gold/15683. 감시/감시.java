import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[][] office;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static List<int[]> cameraList;
    private static int[][][] dir = {
        {},
        {{0},{1},{2},{3}},                 // 1
        {{0,2},{1,3}},                     // 2
        {{0,1},{1,2},{2,3},{3,0}},         // 3
        {{0,1,2},{1,2,3},{2,3,0},{3,0,1}}, // 4
        {{0,1,2,3}}                        // 5
    };

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        office = new int[N][M];
        cameraList = new ArrayList<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                office[i][j] = Integer.parseInt(st.nextToken());
                if(office[i][j] >= 1 && office[i][j]<= 5){
                    cameraList.add(new int[]{i, j, office[i][j]});
                }
            }
        }

        int result = dfs(0);
        System.out.println(result);
    }

    private static int dfs(int cameraIndex){
        int minNum = Integer.MAX_VALUE;

        if(cameraIndex >= cameraList.size()){
            int count = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(office[i][j] == 0)
                        count++;
                }
            }
            minNum = Math.min(count, minNum);
            return minNum;
        }

        int[] camera = cameraList.get(cameraIndex);

        for(int i = 0; i < dir[camera[2]].length; i++) {
            int[][] copy = new int[N][M];
            for(int j = 0; j< N; j++){
                copy[j] = office[j].clone();
            }

            for(int j = 0; j < dir[camera[2]][i].length; j++){
                watch(camera[0], camera[1], dir[camera[2]][i][j]);
            }

            minNum = Math.min(minNum, dfs(cameraIndex + 1));
            
            for(int j=0; j < N; j++){
                office[j] = copy[j].clone();
            }
        }

        return minNum;
    }

    private static void watch(int x, int y, int dir){
        while(true){
            x += dx[dir];
            y += dy[dir];

            if(x < 0 || x >= N || y < 0 || y >= M) break;
            if(office[x][y] == 6) break;

            if(office[x][y] == 0)
                office[x][y] = -1;
        }
    }
}
