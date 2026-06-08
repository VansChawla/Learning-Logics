class BrowserHistoryWdLL {
    class Node {
        String url;
        Node back;
        Node next;

        Node(String url) {
            this.url = url;
            this.back = this.back = null;

        }
    }

    Node curr;

    public BrowserHistory(String homepage) {
        curr = new Node(homepage);
    }

    public void visit(String url) {
        Node newNode = new Node(url);
        curr.next = newNode;
        newNode.back = curr;
        curr = newNode;
    }

    public String back(int steps) {
        while (curr.back != null && steps > 0) {
            curr = curr.back;
            steps--;
        }
        
        return curr.url;
    }

    public String forward(int steps) {
        while (curr.next != null && steps > 0) {
            curr = curr.next;
            steps--;
        }

        return curr.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */