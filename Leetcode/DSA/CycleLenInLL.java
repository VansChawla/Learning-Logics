class CycleLenInLL{ {
    public int lengthOfLoop(Node head) {
        // Find Cycle
        Node slow = head;
        Node fast = head;
        boolean hasCycle = false;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                hasCycle = true;
                break;
            }
        }
        
        if(!hasCycle){
            return 0;
        }
        
        
        // Count len of the cycle
        int len = 1;
        slow = slow.next; // Fix fast and move slow
        
        while(slow != fast){
            slow = slow.next;
            len++;
        }

        return len;
    }
}