import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int result = 0;
    static int[][] map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(result);
    }

    private static void dfs(int depth){
        if (depth == 5) {
            updateMax();
            return;
        }

        int[][] original = copyMap(map);

        for (int dir = 0; dir < 4; dir++) {
            map = copyMap(original);   
            map = move(dir);
            dfs(depth + 1);
        }

        map = original; // 원본 상태로 복구
    }

    private static int[][] move(int dir){
        int[][] newMap = copyMap(map);
        if(dir == 0){ // 상
            for (int j = 0; j < N; j++) {
                int[] temp = new int[N];
                int idx = 0;

                for (int i = 0; i < N; i++) { // 열 가져오기
                    if (map[i][j] != 0) temp[idx++] = map[i][j];
                }

                int[] merged = merge(temp);

                for (int i = 0; i < N; i++) {
                    newMap[i][j] = merged[i];
                }
            }
        } else if(dir == 1){ // 하
            for (int j = 0; j < N; j++) {
                int[] temp = new int[N];
                int idx = 0;

                for (int i = N - 1; i >= 0; i--) { // 열 가져오기
                    if (map[i][j] != 0) temp[idx++] = map[i][j];
                }

                int[] merged = merge(temp);

                for (int i = N - 1, k = 0; i >= 0; i--, k++) {
                    newMap[i][j] = merged[k];
                }
            }
        } else if(dir == 2){ // 좌
            for (int i = 0; i < N; i++) {
                int[] temp = new int[N];
                int idx = 0;

                for (int j = 0; j < N; j++) { // 행 하나 가져오기
                    if (map[i][j] != 0) temp[idx++] = map[i][j];
                }

                int[] merged = merge(temp);

                for (int j = 0; j < N; j++) {
                    newMap[i][j] = merged[j];
                }
            }
        } else { // 우
            for (int i = 0; i < N; i++) {
                int[] temp = new int[N];
                int idx = 0;

                for (int j = N - 1; j >= 0; j--) { // 행 하나 가져오기
                    if (map[i][j] != 0) temp[idx++] = map[i][j];
                }

                int[] merged = merge(temp);

                for (int j = N - 1, k = 0; j >= 0; j--, k++) {
                    newMap[i][j] = merged[k];
                }
            }
        }
        return newMap;
    }

    private static int[] merge(int[] arr) {
        int[] merged = new int[N];
        int idx = 0;
        for(int i = 0; i < N; i++){
            if(arr[i] == 0) continue;

            if(i + 1 < N && arr[i + 1] == arr[i]){
                merged[idx++] = arr[i] * 2;
                i++;
            } else {
                merged[idx++] = arr[i];
            }
        }

        return merged;
    }

    private static int[][] copyMap(int[][] src) {
        int[][] copied = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copied[i][j] = src[i][j];
            }
        }
        return copied;
    }

    private static void updateMax() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result = Math.max(result, map[i][j]);
            }
        }
    }
}
