import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static List<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.add(new int[]{start, end});
        }

        list.sort((a, b) -> {
                if(a[0] != b[0]) return a[0] - b[0];
                else return a[1] - b[1];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(list.get(0)[1]);

        for(int i = 1; i < N; i++){
            int start = list.get(i)[0];
            int end = list.get(i)[1];

            if(pq.peek() <= start){
                pq.poll();
            }

            pq.add(end);
        }

        System.out.println(pq.size());
    }
}
