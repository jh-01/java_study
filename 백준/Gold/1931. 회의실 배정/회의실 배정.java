import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list.add(new int[]{s, e});
        }

        list.sort((a, b) -> {
            if(a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });
        int[] prev = list.get(0);
        int count = 1;

        for(int i = 1; i < N; i++){
            int[] temp = list.get(i);
            if(prev[1] <= temp[0]){
                prev = temp;
                count++;
            }
        }

        System.out.println(count);
    }
}
