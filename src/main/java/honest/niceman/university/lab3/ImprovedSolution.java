package honest.niceman.university.lab3;

public class ImprovedSolution {
    private static boolean areIdentical(BinaryTree.Node treeOneNode,
                                        BinaryTree.Node treeTwoNode,
                                        int currentDepth,
                                        int maxDepthToCheck) {
        System.out.println(treeOneNode);
        if (treeOneNode == null && treeTwoNode == null) {
            return true;
        } else if (treeOneNode == null || treeTwoNode == null) {
            return false;
        } else if (currentDepth > maxDepthToCheck + 1) {
            return false;
        } else return (treeOneNode.value == treeTwoNode.value
                && areIdentical(treeOneNode.left, treeTwoNode.left, ++currentDepth, maxDepthToCheck)
                && areIdentical(treeOneNode.right, treeTwoNode.right, ++currentDepth, maxDepthToCheck));
    }

    public static boolean isSubTree(BinaryTree.Node treeOneNode,
                                    BinaryTree.Node treeTwoNode,
                                    int currentDepth,
                                    int maxDepthToCheck) {
        if (treeTwoNode == null) {
            return true;
        } else if (treeOneNode == null) {
            return false;
        } else if (areIdentical(treeOneNode, treeTwoNode, currentDepth, maxDepthToCheck)) {
            return true;
        } else if (currentDepth > maxDepthToCheck + 1) {
            return false;
        } else return (isSubTree(treeOneNode.left, treeTwoNode, ++currentDepth, maxDepthToCheck)
                || isSubTree(treeOneNode.right, treeTwoNode, ++currentDepth, maxDepthToCheck));
    }
}
