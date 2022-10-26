package honest.niceman.university.lab2.part3.task3;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/*
3. Как известно, слишком высокая стопка тарелок может развалиться.
Следовательно, в реальной жизни, когда высота стопки превысила бы
некоторое пороговое значение, мы начали бы складывать тарелки в
новую стопку. Реализуйте структуру данных SetOfStacks, имитирующую
реальную ситуацию. Структура SetOfStack должна состоять из
нескольких стеков, новый стек создается, как только предыдущий
достигнет порогового значения. Методы SetOfStacks.push() и
SetOfStacks.рор() должны вести себя так же, как при работе с одним
стеком (то есть метод рор() должен возвращать те же значения,
которые бы он возвращал при использовании одного большого стека).
Реализуйте функцию popAt(int index), которая осуществляет операцию
рор с заданным внутренним стеком.
*/
public class SetOfStacks {
    List<MyStack> stacks;
    private static final int MAX_HEIGHT = 2;

    public SetOfStacks() {
        this.stacks = new ArrayList<>();
    }

    public void push(String val) {
        if (stacks.isEmpty()) {
            MyStack m = new MyStack();
            m.push(val);
            stacks.add(m);
        } else {
            MyStack lastStack = stacks.get(stacks.size() - 1);
            if (lastStack.size < MAX_HEIGHT) {
                lastStack.push(val);
            } else {
                MyStack m = new MyStack();
                m.push(val);
                stacks.add(m);
            }
        }
    }

    public String pop() {
        if (stacks.isEmpty()) {
            throw new EmptyStackException();
        }
        MyStack stack = stacks.get(stacks.size() - 1);
        String popResult = stack.pop();
        if (stack.size == 0) {
            stacks.remove(stack);
        }
        return popResult;
    }

    public String popAt(int index) {
        if (stacks.size() - 1 < index || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        MyStack stack = stacks.get(index);
        String popResult = stack.pop();
        if (stack.size == 0) {
            stacks.remove(stack);
        }
        return popResult;
    }

    public static class MyStack {
        private Node top;
        private int size;

        public void push(String val) {
            Node cur = new Node(val);
            cur.next = top;
            top = cur;
            size++;
        }

        public String pop() {
            if (size == 0) {
                throw new EmptyStackException();
            }
            String poppedElement = top.name;
            top = top.next;
            size--;
            return poppedElement;
        }

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

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("MyStack{ ");
            Node n = top;
            while (n != null) {
                stringBuilder.append(n);
                stringBuilder.append(", ");
                n = n.next;
            }
            stringBuilder.append("size=");
            stringBuilder.append(size);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    @Override
    public String toString() {
        return "SetOfStack{" +
                "stacks=" + stacks +
                '}';
    }
}
