class LFUCache {
    private static class Node {
        int key, val, freq;
        Node prev, next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }

    private static class DoublyLinkedList {
        Node head, tail;
        int size;
        
        DoublyLinkedList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addNode(Node node) {
            Node nextNode = head.next;
            head.next = node;
            node.prev = head;
            node.next = nextNode;
            nextNode.prev = node;
            size++;
        }

        void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
    }

    private final int capacity;
    private int minFreq;
    private int size;
    private final Map<Integer, Node> keyMap;
    private final Map<Integer, DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.size = 0;
        this.keyMap = new HashMap<>();
        this.freqMap = new HashMap<>();
    }
    
    public int get(int key) {
        if (!keyMap.containsKey(key)) {
            return -1;
        }
        Node node = keyMap.get(key);
        updateFreq(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }

        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            node.val = value;
            updateFreq(node);
            return;
        }

        if (size >= capacity) {
            DoublyLinkedList minFreqList = freqMap.get(minFreq);
            Node toRemove = minFreqList.tail.prev; // Evict LRU from the min-frequency list
            keyMap.remove(toRemove.key);
            minFreqList.removeNode(toRemove);
            size--;
        }

        minFreq = 1;
        Node newNode = new Node(key, value);
        DoublyLinkedList newList = freqMap.computeIfAbsent(minFreq, k -> new DoublyLinkedList());
        newList.addNode(newNode);
        keyMap.put(key, newNode);
        size++;
    }

    private void updateFreq(Node node) {
        int oldFreq = node.freq;
        DoublyLinkedList oldList = freqMap.get(oldFreq);
        oldList.removeNode(node);

        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;
        DoublyLinkedList newList = freqMap.computeIfAbsent(node.freq, k -> new DoublyLinkedList());
        newList.addNode(node);
    }
}