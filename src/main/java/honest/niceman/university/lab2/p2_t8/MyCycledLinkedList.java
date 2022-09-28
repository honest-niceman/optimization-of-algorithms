package honest.niceman.university.lab2.p2_t8;

import java.util.HashSet;
import java.util.Set;

public class MyCycledLinkedList {
    Node head;

    public static class Node {
        String name;
        Node next;

        Node(String d) {
            name = d;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public void addNode(String name) {
        Node newNode = new Node(name);
        newNode.next = head;
        head = newNode;
    }

    /*
    Simple Set<> algorithm
    O(N) space complexity
    O(N) time complexity
    */
    public Node getFirstNodeOfTheLoopSet() {
        Set<Node> nodes = new HashSet<>();
        Node n = head;
        while (n.next != null) {
            if (nodes.contains(n)) {
                return n;
            }
            nodes.add(n);
            n = n.next;
        }
        return null;
    }

    /*
    Floyd's cycle detection algorithm
    O(1) space complexity
    O(N) time complexity
    */
    public Node getFirstNodeOfTheLoopFloyd() {
        Node slowPointer = head;
        Node fastPointer = head;
        while (slowPointer != null && fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            /*
            once we get the same node in both pointers we reset
            the first pointer to the beginning of the list
            and incrementing both pointers step by step until
            they reach the loop starting node
             */
            if (slowPointer == fastPointer) {
                slowPointer = head;
                while (slowPointer != fastPointer) {
                    slowPointer = slowPointer.next;
                    fastPointer = fastPointer.next;
                }
                return slowPointer;
            }
        }
        return null;
    }

    public void printList() {
        StringBuilder stringBuilder = new StringBuilder();
        Node n = head;
        while (n != null) {
            stringBuilder.append(n.name);
            stringBuilder.append("-->");
            n = n.next;
        }
        System.out.println(stringBuilder);
    }
}
