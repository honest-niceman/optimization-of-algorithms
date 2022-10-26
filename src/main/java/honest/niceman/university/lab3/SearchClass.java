package honest.niceman.university.lab3;

public class SearchClass {
    private SearchClass() {}

    private static boolean areIdentical(BinaryTree.Node treeOneNode, BinaryTree.Node treeTwoNode) {
        if (treeOneNode == null && treeTwoNode == null) {
            return true;
        }
        if (treeOneNode == null || treeTwoNode == null) {
            return false;
        }
        return (treeOneNode.value == treeTwoNode.value
                && areIdentical(treeOneNode.left, treeTwoNode.left)
                && areIdentical(treeOneNode.right, treeTwoNode.right));
    }

    public static boolean isSubtree(BinaryTree.Node treeOneNode, BinaryTree.Node treeTwoNode) {
        if (treeTwoNode == null) {
            return true;
        }
        if (treeOneNode == null) {
            return false;
        }
        if (areIdentical(treeOneNode, treeTwoNode)) {
            return true;
        }
        return isSubtree(treeOneNode.left, treeTwoNode) || isSubtree(treeOneNode.right, treeTwoNode);
    }
}
