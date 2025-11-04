import java.util.*;
import java.util.stream.*;

public class Benchmark {
    public static void main(String[] args) {
        int n = 1_000_000; // 배열 크기
        int iterations = 10; // 반복 횟수
        Random rand = new Random();

        double[] timesAsc = new double[iterations];
        double[] timesWrapper = new double[iterations];
        double[] timesManual = new double[iterations];
        double[] timesDirect = new double[iterations];
        double[] timesStream = new double[iterations];

        for (int it = 0; it < iterations; it++) {
            // 랜덤 데이터 생성
            int[] people = new int[n];
            for (int i = 0; i < n; i++) people[i] = rand.nextInt(1000);

            // 1️⃣ 오름차순
            int[] ascArray = Arrays.copyOf(people, n);
            long start = System.nanoTime();
            Arrays.sort(ascArray);
            long end = System.nanoTime();
            timesAsc[it] = (end - start) / 1_000_000.0;

            // 2️⃣ Wrapper + reverseOrder()
            Integer[] wrapperArray = Arrays.stream(people).boxed().toArray(Integer[]::new);
            start = System.nanoTime();
            Arrays.sort(wrapperArray, Collections.reverseOrder());
            end = System.nanoTime();
            timesWrapper[it] = (end - start) / 1_000_000.0;

            // 3️⃣ 수동 뒤집기
            int[] manualArray = Arrays.copyOf(people, n);
            start = System.nanoTime();
            Arrays.sort(manualArray);
            for (int i = 0; i < manualArray.length / 2; i++) {
                int temp = manualArray[i];
                manualArray[i] = manualArray[manualArray.length - 1 - i];
                manualArray[manualArray.length - 1 - i] = temp;
            }
            end = System.nanoTime();
            timesManual[it] = (end - start) / 1_000_000.0;

            // 4️⃣ Arrays.sort(arr, Collections.reverseOrder())
            Integer[] directArray = Arrays.stream(people).boxed().toArray(Integer[]::new);
            start = System.nanoTime();
            Arrays.sort(directArray, Collections.reverseOrder());
            end = System.nanoTime();
            timesDirect[it] = (end - start) / 1_000_000.0;

            // 5️⃣ Stream + reverseOrder()
            start = System.nanoTime();
            int[] streamArray = Arrays.stream(people)
                                        .boxed()
                                        .sorted(Collections.reverseOrder())
                                        .mapToInt(Integer::intValue)
                                        .toArray();
            end = System.nanoTime();
            timesStream[it] = (end - start) / 1_000_000.0;
        }

        // 평균 & 표준편차 계산
        System.out.println("===== Benchmark 결과 (" + iterations + "회 반복) =====");
        printStats("오름차순 Arrays.sort()", timesAsc);
        printStats("내림차순 Wrapper + reverseOrder()", timesWrapper);
        printStats("내림차순 수동 뒤집기", timesManual);
        printStats("Arrays.sort(arr, Collections.reverseOrder())", timesDirect);
        printStats("Stream + sorted(reverseOrder())", timesStream);
    }

    private static void printStats(String name, double[] times) {
        double sum = 0;
        for (double t : times) sum += t;
        double avg = sum / times.length;

        double var = 0;
        for (double t : times) var += (t - avg) * (t - avg);
        double std = Math.sqrt(var / times.length);

        System.out.printf("%-40s 평균: %.4f ms, 표준편차: %.4f ms%n", name, avg, std);
    }
}
