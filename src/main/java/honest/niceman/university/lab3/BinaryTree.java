package honest.niceman.university.lab3;

public class BinaryTree {
    Node root;

    public static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    "}";
        }
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                "}";
    }
}
