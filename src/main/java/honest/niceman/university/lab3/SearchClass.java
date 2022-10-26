package honest.niceman.university.lab3;

public class SearchClass {
    private SearchClass() {}

    private static boolean areIdentical(BinaryTree.Node node1, BinaryTree.Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return (node1.value == node2.value
                && areIdentical(node1.left, node2.left)
                && areIdentical(node1.right, node2.right));
    }

    public static boolean isSubtree(BinaryTree.Node node1, BinaryTree.Node node2) {
        if (node2 == null) {
            return true;
        }
        if (node1 == null) {
            return false;
        }
        if (areIdentical(node1, node2)) {
            return true;
        }
        return isSubtree(node1.left, node2) || isSubtree(node1.right, node2);
    }
}
