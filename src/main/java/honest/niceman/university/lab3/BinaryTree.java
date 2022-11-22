package honest.niceman.university.lab3;

import java.util.Objects;

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
            return "Node{" + value + "}";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            return value == node.value && left.equals(node.left) && right.equals(node.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, left, right);
        }
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                "}";
    }
}
