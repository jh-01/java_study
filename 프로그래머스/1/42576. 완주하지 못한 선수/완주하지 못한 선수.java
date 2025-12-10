class Solution {
    
    
    public String solution(String[] participant, String[] completion) {
        Hash myHash = new Hash(200003);
        
        for(int i = 0; i < completion.length; i++){
            myHash.put(completion[i]);
        }
        
        for(int i = 0; i < participant.length; i++){
            int count = myHash.get(participant[i]);
            count--;
            myHash.update(participant[i], count);
            if(count < 0) return participant[i];
        }
        return "";
    }
}

class Hash{
    class Node {
        String key;
        int value;
        Node next;

        Node(String key, int value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    Node[] table;

    public Hash(int size){
        table = new Node[size];
    }

    private int hash(String key){
        int h = 0;
        for(int i = 0; i < key.length(); i++){
            h = (h * 31 + key.charAt(i)) % table.length;
        }
        return h;
    }

    public void put(String key){
        int idx = hash(key);

        Node node = table[idx];
        while(node != null){
            if(node.key.equals(key)){
                node.value++;
                return;
            }
            node = node.next;
        }
        table[idx] = new Node(key, 1, table[idx]);
    }

    public int get(String key){
        int idx = hash(key);

        Node node = table[idx];
        while(node != null){
            if(node.key.equals(key)){
                return node.value;
            }
            node = node.next;
        }
        return 0;
    }

    public void update(String key, int newValue){
        int idx = hash(key);

        Node node = table[idx];
        while(node != null){
            if(node.key.equals(key)){
                node.value = newValue;
                return;
            }
            node = node.next;
        }
    }
}