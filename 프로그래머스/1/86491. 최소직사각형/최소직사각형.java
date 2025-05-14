import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        List<Card> cards = new ArrayList<>();
        int maxW = 0;
        int maxL = 0;
        for(int i = 0; i < sizes.length; i++){
            if(sizes[i][0] >= sizes[i][1]){
                cards.add(new Card(sizes[i][0], sizes[i][1]));
                if(maxW < sizes[i][0]) maxW = sizes[i][0];
                if(maxL < sizes[i][1]) maxL = sizes[i][1];
            }
            else {
                cards.add(new Card(sizes[i][1], sizes[i][0]));
                if(maxW < sizes[i][1]) maxW = sizes[i][1];
                if(maxL < sizes[i][0]) maxL = sizes[i][0];
            }
        }
        return maxW * maxL;
    }
    
    public class Card {
        private int width;
        private int length;
        
        public Card(int width, int length){
            this.width = width;
            this.length = length;
        }
    }
}