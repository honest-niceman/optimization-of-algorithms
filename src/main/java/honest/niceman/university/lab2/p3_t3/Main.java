package honest.niceman.university.lab2.p3_t3;

/*
As you know, too high a stack of plates can fall apart.
Therefore, in real life, when the height of the stack would exceed a
certain threshold value, we would begin to stack plates in
a new stack. Implement a SetOfStacks data structure that simulates
a real situation. The SetOfStacks structure should consist of
several stacks, a new stack is created as soon as the previous
one reaches the threshold value. The SetOfStacks.push() and
SetOfStacks.pop() methods should behave the same as when working with a single
stack (that is, the pop() method should return the same values,
which it would return when using one large stack).
Implement the popAt(int index) function, which performs
the pop operation with a given inner stack.
 */

public class Main {
    public static void main(String[] args) {
        SetOfStacks setOfStacks = new SetOfStacks();
        setOfStacks.push("A");
        setOfStacks.push("B");
        setOfStacks.push("C");
        setOfStacks.push("D");
        setOfStacks.push("E");
        setOfStacks.push("F");
        setOfStacks.push("G");
        System.out.println(setOfStacks);
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks);
        System.out.println(setOfStacks.popAt(1));
        System.out.println(setOfStacks);
        setOfStacks.push("Z");
        System.out.println(setOfStacks);
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks);
    }
}
