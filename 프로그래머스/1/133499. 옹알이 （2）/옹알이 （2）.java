class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] canSpeaks = {"aya", "ye", "woo", "ma"};
        for(String word : babbling){
            String tempBabbling = word;
            int tempPick = -1;
            while(tempBabbling.length() > 0){
                boolean isPossible = false;
                for(int j = 0; j < canSpeaks.length; j++){
                    if(tempPick == j) continue;
                    if(tempBabbling.startsWith(canSpeaks[j])){
                        isPossible = true;
                        tempPick = j;
                        if(tempBabbling.length() == canSpeaks[j].length()){
                            answer++;
                            break;
                        }
                        tempBabbling = tempBabbling.substring(canSpeaks[j].length());
                        break;
                    }
                }
                if(!isPossible) break;
            }
        }
        return answer;
    }
}