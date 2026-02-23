import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int answer = 1;
        int goal = cards.length;
        int targetSum = goal + 1;
        int initSize = goal / 3;
        
        Set<Integer> hand = new HashSet<>();
        List<Integer> open = new ArrayList<>();
        int idx = 0;
        
        for(int i = 0; i < initSize; i++){
            hand.add(cards[i]);
        }

        int m = initSize;
        while(true){
            if (m >= goal) break;

            // ⭐ 라운드 시작 시 2장 공개
            open.add(cards[m++]);
            open.add(cards[m++]);
            
             boolean success = false;
            
            // 1. 갖고 있는 것 중에서
            for (int card : new HashSet<>(hand)) {
                int target = targetSum - card;
                if (hand.contains(target) && card != target) {
                    hand.remove(card);
                    hand.remove(target);
                    success = true;
                    break;
                }
            }
            
            // 2. 코인 한개만 사용
            if (!success && coin >= 1) {
                for (int card : open) {
                    int target = targetSum - card;
                    if (hand.contains(target)) {
                        hand.remove(target);
                        open.remove(Integer.valueOf(card));
                        coin--;
                        success = true;
                        break;
                    }
                }
            }
            
            // 3. 코인 두개 사용
            if (!success && coin >= 2) {
                for (int i = 0; i < open.size(); i++) {
                    int card = open.get(i);
                    int target = targetSum - card;

                    if (open.contains(target) && card != target) {
                        open.remove(Integer.valueOf(card));
                        open.remove(Integer.valueOf(target));
                        coin -= 2;
                        success = true;
                        break;
                    }
                }
            }
            
            if (!success) break;
            
            answer++;
        }

        return answer;
    }
}