import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        
        int totalKinds = set.size();
        int canPick = nums.length / 2;

        return Math.min(totalKinds, canPick);
    }
}