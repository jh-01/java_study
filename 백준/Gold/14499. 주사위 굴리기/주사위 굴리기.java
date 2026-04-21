import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] order = new int[K];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++){
            order[i] = Integer.parseInt(st.nextToken());
        }

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        int[] dice = new int[6];
        for(int i = 0; i < K; i++){
            int nx = x + dx[order[i] - 1];
            int ny = y + dy[order[i] - 1];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

            int[] temp = dice.clone();
            int top = temp[0];
            int bottom = temp[1];
            int south = temp[2];
            int north = temp[3];
            int west = temp[4];
            int east = temp[5];

            if(order[i] == 1){
                temp[0] = west;
                temp[1] = east;
                temp[4] = bottom;
                temp[5] = top;
            } else if(order[i] == 2){
                temp[0] = east;
                temp[1] = west;
                temp[4] = top;
                temp[5] = bottom;
            } else if(order[i] == 3){
                temp[0] = south;
                temp[1] = north;
                temp[2] = bottom;
                temp[3] = top;
            } else {
                temp[0] = north;
                temp[1] = south;
                temp[2] = top;
                temp[3] = bottom;
            }

            if(map[nx][ny] == 0){
                map[nx][ny] = temp[1];  // 바닥값 복사
            } else {
                temp[1] = map[nx][ny];  // 지도값을 바닥으로
                map[nx][ny] = 0;
            }
            dice = temp;
            x = nx;
            y = ny;
            System.out.println(temp[0]);
        }
    }
}
