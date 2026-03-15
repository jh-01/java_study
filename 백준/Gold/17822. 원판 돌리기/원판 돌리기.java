
import java.io.*;
import java.util.*;

public class Main {
    private static int N, M, T;
    private static int[][] board;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                int x = Integer.parseInt(st.nextToken());
                board[i][j] = x;
            }
        }

        for(int t = 0; t < T; t++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            for(int i = x; i <= N; i += x){
                rotate(i - 1, d, k);
            }

            boolean flag = false;
            boolean[][] remove = new boolean[N][M];
            // 인접 같은 숫자 찾기
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){

                    if(board[i][j] == -1) continue;

                    for(int dir=0;dir<4;dir++){

                        int nx = i + dx[dir];
                        int ny = j + dy[dir];

                        if(nx < 0 || nx >= N) continue;

                        ny = (ny + M) % M;

                        if(board[nx][ny] == board[i][j]){
                            remove[i][j] = true;
                            remove[nx][ny] = true;
                            flag = true;
                        }
                    }
                }
            }

            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(remove[i][j]){
                        board[i][j] = -1;
                    }
                }
            }

            if(!flag){
                adjustAverage();
            }
        }

        int result = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(board[i][j] != -1){
                    result += board[i][j];
                }
            }
        }

        System.out.println(result);
    }

    private static void rotate(int x, int d, int k){
        int[] rotated = new int[M];
        if(d == 0){
            for(int j = 0; j < M; j++){
                rotated[(j + k) % M] = board[x][j];
            }
        } else {
            for(int j = 0; j < M; j++){
                rotated[j] = board[x][(j + k) % M];
            }
        }

        board[x] = rotated; 
    }

    private static void adjustAverage(){
        int sum = 0;
        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(board[i][j] != -1){
                    sum += board[i][j];
                    count++;
                }
            }
        }
        if(count == 0) return;

        double avg = (double)sum / count;

        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < M; j++){
                if(board[i][j] == -1) continue;

                if(board[i][j] > avg) board[i][j]--;
                else if(board[i][j] < avg) board[i][j]++;
            }
        }
    }
}
