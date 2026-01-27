import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {
        int N = expressions.length;
        List<String[]> candidate = new ArrayList<>();
        boolean[][] formation = new boolean[N][10];
        boolean[] fixed = new boolean[N];

        // formation 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 2; j < 10; j++) {
                formation[i][j] = true;
            }
        }

        // 각 식별로 가능한 진법 계산
        for (int i = 0; i < N; i++) {
            String[] s = expressions[i].split(" ");

            if (s[4].equals("X")) {
                candidate.add(s);
                fixed[i] = true;
                continue;
            }

            for (int j = 2; j < 10; j++) {
                if (!isValidNumber(s[0], j) ||
                    !isValidNumber(s[2], j) ||
                    !isValidNumber(s[4], j)) {
                    formation[i][j] = false;
                    continue;
                }

                int a = convert(s[0], j);
                int b = convert(s[2], j);
                int c = convert(s[4], j);

                formation[i][j] =
                        s[1].equals("+") ? (a + b == c) : (a - b == c);
            }
        }

        // 전체 공통 진법 계산 (X 포함 숫자 유효성!)
        boolean[] common = new boolean[10];
        Arrays.fill(common, true);

        for (int j = 2; j < 10; j++) {
            for (int i = 0; i < N; i++) {
                String[] s = expressions[i].split(" ");

                if (!isValidNumber(s[0], j) || !isValidNumber(s[2], j)) {
                    common[j] = false;
                    break;
                }

                if (!fixed[i] && !formation[i][j]) {
                    common[j] = false;
                    break;
                }
            }
        }

        // X 문제 계산
        String[] answer = new String[candidate.size()];
        for (int i = 0; i < candidate.size(); i++) {
            Set<String> results = new HashSet<>();
            String[] s = candidate.get(i);

            for (int j = 2; j < 10; j++) {
                if (!common[j]) continue;

                int a = convert(s[0], j);
                int b = convert(s[2], j);
                int c = s[1].equals("+") ? a + b : a - b;

                String cur = toBase(c, j);
                if (isValidNumber(cur, j)) {
                    results.add(cur);
                }
            }

            answer[i] = results.size() == 1
                    ? s[0] + " " + s[1] + " " + s[2] + " " + s[3] + " " + results.iterator().next()
                    : s[0] + " " + s[1] + " " + s[2] + " " + s[3] + " ?";
        }

        return answer;
    }

    private boolean isValidNumber(String num, int base) {
        for (char ch : num.toCharArray()) {
            if (ch - '0' >= base) return false;
        }
        return true;
    }

    private int convert(String num, int base) {
        int value = 0;
        for (char ch : num.toCharArray()) {
            value = value * base + (ch - '0');
        }
        return value;
    }

    private String toBase(int value, int base) {
        if (value == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (value > 0) {
            sb.append(value % base);
            value /= base;
        }
        return sb.reverse().toString();
    }
}
