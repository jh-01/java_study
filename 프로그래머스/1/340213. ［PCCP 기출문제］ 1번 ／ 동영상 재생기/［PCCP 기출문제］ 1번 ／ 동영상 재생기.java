import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int videoSec = toSec(video_len);
        int posSec = toSec(pos);
        int opStartSec = toSec(op_start);
        int opEndSec = toSec(op_end);
        
        // 오프닝 건너뛰기
        if(posSec >= opStartSec && posSec<= opEndSec){
            posSec = opEndSec;
        }
        
        for(String command : commands){
            if(command.equals("prev")){
                posSec = Math.max(0, posSec - 10);
            } else if(command.equals("next")){
                posSec = Math.min(videoSec, posSec + 10);
                
            }
            // 오프닝 건너뛰기
            if(posSec >= opStartSec && posSec<= opEndSec){
                posSec = opEndSec;
            }
        }
        
        return String.format("%02d:%02d", posSec / 60, posSec % 60);
    }
    
    private int toSec(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}