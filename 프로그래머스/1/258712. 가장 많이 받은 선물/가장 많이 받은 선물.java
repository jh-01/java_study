import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        int[] answer = new int[n];
        int[] giftIndex = new int[n];

        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(friends[i], i);
        }

        int[][] giftTable = new int[n][n];
        for (String gift : gifts) {
            String[] t = gift.split(" ");
            int from = indexMap.get(t[0]);
            int to = indexMap.get(t[1]);
            giftTable[from][to]++;
        }

        // giftIndex(선물지수) 계산
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                giftIndex[i] += giftTable[i][j];
                giftIndex[i] -= giftTable[j][i];
            }
        }

        // 다음 달 계산
        int maxResult = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (giftTable[i][j] > giftTable[j][i]) answer[i]++;
                else if (giftTable[i][j] < giftTable[j][i]) answer[j]++;
                else {
                    if (giftIndex[i] > giftIndex[j]) answer[i]++;
                    else if (giftIndex[i] < giftIndex[j]) answer[j]++;
                }

                maxResult = Math.max(maxResult, Math.max(answer[i], answer[j]));
            }
        }
        return maxResult;
    }
}

/*
다음 달에 누가 선물을 많이 받을지 예측
- 선물을 주고받은 기록이 있다면, 이번 달까지 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받음

- 주고받은 기록이 하나도 없거나 주고받은 수가 같다면, 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받음

- 선물 지수 : 이번 달까지 자신이 친구들에게 준 선물의 수에서 받은 선물의 수를 뺀 값

*/