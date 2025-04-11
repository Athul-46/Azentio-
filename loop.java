class Node {
    int data;
    Node next;
    Node(int data) { this.data = data; }
}

public class LinkedListLoopDetector {
    public static boolean hasLoop(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
       
        Node head = new Node(1);
        head.next = new Node(2);
        Node loopNode = new Node(3);
        head.next.next = loopNode;
        loopNode.next = new Node(4);
        loopNode.next.next = new Node(5);
        loopNode.next.next.next = loopNode;

        System.out.println("Loop detected: " + hasLoop(head)); 
    }
}
