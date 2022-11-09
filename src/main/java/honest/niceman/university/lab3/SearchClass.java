package honest.niceman.university.lab3;

import java.util.List;

public class SearchClass {
    private SearchClass() {}

    private static boolean areIdentical(BinaryTree.Node treeOneNode,
                                        BinaryTree.Node treeTwoNode) {
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

    public static boolean isSubtree(BinaryTree.Node treeOneNode,
                                    BinaryTree.Node treeTwoNode) {
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

    public static boolean improvedIsSubtree(BinaryTree.Node treeOneNode,
                                            BinaryTree.Node treeTwoNode,
                                            List<BinaryTree.Node> rowToExit) {
        if (treeTwoNode == null) {
            return true;
        }
        if (treeOneNode == null) {
            return false;
        }
        if (rowToExit.contains(treeOneNode)) {
            return false;
        }
        if (areIdentical(treeOneNode, treeTwoNode)) {
            return true;
        }
        return isSubtree(treeOneNode.left, treeTwoNode) || isSubtree(treeOneNode.right, treeTwoNode);
    }

    public static void findAllNodesAtTheLevel(BinaryTree.Node node,
                                       int currentLevel,
                                       int requestedLevel,
                                       List<BinaryTree.Node> result) {
        if (currentLevel == requestedLevel) {
            result.add(node);
        } else {
            if (node.left != null) {
                findAllNodesAtTheLevel(node.left, currentLevel + 1, requestedLevel, result);
            }
            if (node.right != null) {
                findAllNodesAtTheLevel(node.right, currentLevel + 1, requestedLevel, result);
            }
        }
    }

    public static int maxDepth(BinaryTree.Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
