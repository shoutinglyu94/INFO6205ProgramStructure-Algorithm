package algo.chap3.search;


public class HashTable {
    private int M = 97;
    private Node[] st = new Node[M];
    int size;
    
    private static class Node{
        private Object key;
        private Object val;
        private Node next;
        public Node(Object key,Object val,Node x){
            this.key = key;
            this.val = val;
        }
    }
    public HashTable(int capacity) {
        this.size = capacity;
    }
    
    private int hash(Object key){
        return (key.hashCode() & 0x7fffffff) % M;
    }
    public void put(Object key, Object value) {
        int i = hash(key);
        for(Node x = st[i];x!=null;x = x.next)
            if(key.equals(x.key)){
                x.val = value;
                return;
            }
        st[i] = new Node(key,value,st[i]);
    }

    public Object getValue(Object key) {
        int i = hash(key);
        for(Node x = st[i];x!=null;x = x.next)
            if(key.equals(x.key)) return x.val;
        return null;
    }

    // This is only for testing and should be made private
    public boolean check(int bits, int length) {
        return false;
    }

    public void show() {

    }

}
