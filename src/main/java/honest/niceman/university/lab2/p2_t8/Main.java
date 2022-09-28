package honest.niceman.university.lab2.p2_t8;

/*
For a cycled linked list, implement an algorithm that returns the initial node
of the loop. A cycled linked list is a linked list in which the pointer of the next node
references an earlier node, forming a loop.
Example:
Input: A->B->C->D->E->C (previous node C)
Output: C
*/
public class Main {
    public static void main(String[] args) {
        MyCycledLinkedList myCycledLinkedList = new MyCycledLinkedList();
        myCycledLinkedList.addNode("E");
        myCycledLinkedList.addNode("D");
        myCycledLinkedList.addNode("C");
        myCycledLinkedList.addNode("B");
        myCycledLinkedList.addNode("A");
        //imitate the loop
        myCycledLinkedList.head.next.next.next.next = myCycledLinkedList.head.next.next;
        System.out.println(myCycledLinkedList.getFirstNodeOfTheLoopFloyd());
        System.out.println(myCycledLinkedList.getFirstNodeOfTheLoopSet());
    }
}
