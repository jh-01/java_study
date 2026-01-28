class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // 마지막 공격 시간
        int T = attacks[attacks.length - 1][0];
        
        // 연속 성공 
        int sequence = 0;
        
        // 공격 인덱스
        int atkIdx = 0;
        
        int curHealth = health;
        
        for(int t = 0; t < T + 1; t++){
            if(curHealth <= 0) return -1;
            
            if(atkIdx < attacks.length && t == attacks[atkIdx][0]){ // 공격 성공
                sequence = 0;
                curHealth -= attacks[atkIdx][1];
                if(curHealth <= 0) return -1;
                atkIdx++;
            } else {
                sequence++;
                int heal = bandage[1];
                if(sequence == bandage[0]){ // 붕대 연속 감기 성공
                    if(sequence > 0) heal += bandage[2];
                    sequence = 0;
                }

                curHealth += heal;
                if(curHealth > health) curHealth = health;
            }
        }

        return curHealth;
    }
}