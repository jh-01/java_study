import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int Q;
    static int[][] map;
    static int[] magic;
    static int remain = 0;
    static int biggest = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        int len = (int)Math.pow(2, N);
        map = new int[len][len];
        visited = new boolean[len][len];
        for(int i = 0; i < len; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < len; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                remain += map[i][j];
            }
        }

        magic = new int[Q];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < Q; i++){
            magic[i] = Integer.parseInt(st.nextToken());
        }

        solve();

        System.out.println(remain);
        System.out.println(biggest);
    }

    private static void solve(){
        int len = (int)Math.pow(2, N);
        for(int i = 0; i < Q; i++){
            rotate(magic[i]);
            melt();
        }
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    biggest = Math.max(biggest, dfs(i, j));
                }
            }
        }
    }

    private static void rotate(int L){
        int len = (int)Math.pow(2, N);
        int size = (int)Math.pow(2, L);
        int[][] newMap = new int[len][len];

        for (int sx = 0; sx < len; sx += size) {
            for (int sy = 0; sy < len; sy += size) {
                // (sx, sy)를 시작점으로 하는 size x size 부분 격자 회전
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        newMap[sx + j][sy + size - 1 - i] = map[sx + i][sy + j];
                    }
                }
            }
        }
        map = newMap;
    }

    private static void melt(){
        int len = (int)Math.pow(2, N);
        boolean[][] decrease = new boolean[len][len];

        for(int r = 0; r < len; r++){
            for(int c = 0; c < len; c++){
                if(map[r][c] <= 0) continue;

                int count = 0;
                for(int i = 0; i < 4; i++){
                    int nr = r + dx[i];
                    int nc = c + dy[i];

                    if (nr < 0 || nr >= len || nc < 0 || nc >= len) continue;
                    if (map[nr][nc] > 0) count++;
                }

                if (count < 3) decrease[r][c] = true;
            }
        }

        for (int r = 0; r < len; r++) {
            for (int c = 0; c < len; c++) {
                if (decrease[r][c]) {
                    map[r][c]--;
                    remain--;
                }
            }
        }
    }

    private static int dfs(int r, int c){
        int len = (int)Math.pow(2, N);
        visited[r][c] = true;
        int count = 1;

        for (int d = 0; d < 4; d++) {
            int nr = r + dx[d];
            int nc = c + dy[d];

            if (nr < 0 || nr >= len || nc < 0 || nc >= len) continue;
            if (visited[nr][nc]) continue;
            if (map[nr][nc] <= 0) continue;

            count += dfs(nr, nc);
        }

        return count;
    }
}
