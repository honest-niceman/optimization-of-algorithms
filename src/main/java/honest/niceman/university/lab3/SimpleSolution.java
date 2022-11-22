package honest.niceman.university.lab3;

public class SimpleSolution {
    private SimpleSolution() {}

    private static boolean areIdentical(BinaryTree.Node treeOneNode,
                                        BinaryTree.Node treeTwoNode) {
        System.out.println(treeOneNode);
        if (treeOneNode == null && treeTwoNode == null) {
            return true;
        } else if (treeOneNode == null || treeTwoNode == null) {
            return false;
        } else return (treeOneNode.value == treeTwoNode.value
                && areIdentical(treeOneNode.left, treeTwoNode.left)
                && areIdentical(treeOneNode.right, treeTwoNode.right));
    }

    public static boolean isSubtree(BinaryTree.Node treeOneNode,
                                    BinaryTree.Node treeTwoNode) {
        if (treeTwoNode == null) {
            return true;
        } else if (treeOneNode == null) {
            return false;
        } else if (areIdentical(treeOneNode, treeTwoNode)) {
            return true;
        } else return isSubtree(treeOneNode.left, treeTwoNode) || isSubtree(treeOneNode.right, treeTwoNode);
    }
}
