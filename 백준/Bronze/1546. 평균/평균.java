import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int N;
        int M = 0;
        double sum = 0;
        int maxIdx = -1;
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        sc.nextLine();

        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
            if(M < arr[i]){
                M = arr[i];
                maxIdx = i;
            }
        }

        for(int i = 0; i < N; i++){
            double d = (double)arr[i] / M * 100;
            sum += d;
        }

        System.out.println((double)sum / N);
    }
}
