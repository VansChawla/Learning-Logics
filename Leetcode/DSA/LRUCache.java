class Node{
    int key;
    int value;

    Node next;
    Node prev;

    Node(int key, int value){
        this.key=key;
        this.value=value;
    }
}

public class LRUCache {
    HashMap<Integer, Node> cache = new HashMap<>();
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            addToFront(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = value;
            remove(node);
            addToFront(node);
        }else{
            Node node = new Node(key, value);
            cache.put(key, node);
            addToFront(node);

            if(cache.size() > capacity){
                Node temp = tail.prev;
                cache.remove(temp.key);
                remove(temp);
            }
        }
    }

    public void remove(Node node){  // Node A <-> Node B <-> Node C
        node.next.prev = node.prev; // node.next(Node C) shift its prev to Node B's prev
        node.prev.next = node.next; // node.prev(Node A) shift its next to Node B's next
    }

    public void addToFront(Node node){
        Node temp = head.next;   // Remember the old first node
        head.next = node;        // Link dummy Head forward to New Node
        node.prev = head;        // Link New Node backward to dummy Head
        node.next = temp;        // Link New Node forward to old first node
        temp.prev = node;        // Link old first node backward to New Node
    }
}