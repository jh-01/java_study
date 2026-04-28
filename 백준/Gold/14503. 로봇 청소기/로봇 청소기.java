import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int r, c, d;
    static int result = 0;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
  
        map = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();
        System.out.print(result);
    }

    private static void solve(){
        while (true) {
            // 현재칸 청소
            if(map[r][c] == 0){
                result++;
                map[r][c] = 2;
            }

            boolean moved = false;

            // 2. 4방향 탐색
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4; // 왼쪽 회전
                int nr = r + dx[d];
                int nc = c + dy[d];

                if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
                    if (map[nr][nc] == 0) {
                        r = nr;
                        c = nc;
                        moved = true;
                        break;
                    }
                }
            }

            if(!moved) { // 청소되지 않은 빈 칸이 없는 경우
                int nr = r - dx[d];
                int nc = c - dy[d];

                if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
                    if (map[nr][nc] != 1) { // 벽 아니면 이동
                        r = nr;
                        c = nc;
                    } else {
                        break; // 벽이면 종료
                    }
                } else break;
            }
        }  
    }
}
