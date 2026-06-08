public class DesignLinkedList {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    class MyLinkedList {
        Node head;
        int size;

        public MyLinkedList() {
            this.head = null;
            this.size = 0;
        }

        public int get(int index) {
            if (index < 0 || index >= size)
                return -1;
            Node temp = head;
            for (int i = 0; i < index; i++) {
                if (temp == null)
                    return -1;
                temp = temp.next;
            }
            return temp.data;
        }

        public void addAtHead(int val) {
            Node newnode = new Node(val);
            newnode.next = head;
            head = newnode;
            size++;
        }

        public void addAtTail(int val) {
            if (size == 0) {
                addAtHead(val);
                return;
            }
            Node newnode = new Node(val);
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newnode;
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index > size)
                return;
            if (index <= 0) {
                addAtHead(val);
                return;
            }
            if (index == size) {
                addAtTail(val);
                return;
            }

            Node newNode = new Node(val);
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size)
                return;

            if (index == 0) {
                head = head.next;
            } else {
                Node temp = head;
                for (int i = 0; i < index - 1; i++) {
                    temp = temp.next;
                }
                temp.next = temp.next.next;
            }
            size--;
        }
    }

    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */
}
