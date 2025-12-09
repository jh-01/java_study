import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int N;
        Queue<Integer> q = new LinkedList();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        for(int i = 1; i <= N; i++){
            q.add(i);
        }

        while(q.size() > 1){
            System.out.print(q.poll() + " ");
            q.add(q.poll());
        }

        System.out.println(q.poll());
    }
}
