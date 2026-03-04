import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] map = new int[R][C];
        List<int[]> purifiers = new ArrayList<>();
        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] < 0){
                    purifiers.add(new int[]{i, j});
                }
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for (int t = 0; t < T; t++) {
            int[][] newMap = new int[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if(map[i][j] > 0){ // 먼지가 있는 칸
                        int spreadAmount = map[i][j] / 5;
                        int spreadCount = 0;

                        for (int d = 0; d < 4; d++) {
                            int nr = i + dx[d];
                            int nc = j + dy[d];

                            // 범위 안이고 공기청정기가 아닐 때만 확산
                            if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != -1) {
                                newMap[nr][nc] += spreadAmount;
                                spreadCount++;
                            }
                        }

                        // 현재 칸에 남는 먼지
                        newMap[i][j] += map[i][j] - (spreadAmount * spreadCount);
                    }
                }
            }
            map = newMap;
            for (int[] p : purifiers) {
                map[p[0]][p[1]] = -1;
            }

            int upper = purifiers.get(0)[0]; // 위쪽 공기청정기 행
            int lower = purifiers.get(1)[0]; // 아래쪽 공기청정기 행
            
            // 위쪽 (반시계)
            // 1. 왼쪽 열
            for (int i = upper - 1; i > 0; i--) {
                map[i][0] = map[i - 1][0];
            }

            // 2. 위쪽 행
            for (int j = 0; j < C - 1; j++) {
                map[0][j] = map[0][j + 1];
            }

            // 3. 오른쪽 열
            for (int i = 0; i < upper; i++) {
                map[i][C - 1] = map[i + 1][C - 1];
            }

            // 4. 아래쪽 행
            for (int j = C - 1; j > 1; j--) {
                map[upper][j] = map[upper][j - 1];
            }
            // 공기청정기 바로 오른쪽은 0
            map[upper][1] = 0;


           // 아래쪽 (시계)
            // 1. 왼쪽 열
            for (int i = lower + 1; i < R - 1; i++) {
                map[i][0] = map[i + 1][0];
            }

            // 2. 아래쪽 행
            for (int j = 0; j < C - 1; j++) {
                map[R - 1][j] = map[R - 1][j + 1];
            }

            // 3. 오른쪽 열
            for (int i = R - 1; i > lower; i--) {
                map[i][C - 1] = map[i - 1][C - 1];
            }

            // 4. 위쪽 행
            for (int j = C - 1; j > 1; j--) {
                map[lower][j] = map[lower][j - 1];
            }

            map[lower][1] = 0;
        }

        int result = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] > 0)
                {
                    result += map[i][j];
                }
            }
        }

        System.out.println(result);
    }
}
