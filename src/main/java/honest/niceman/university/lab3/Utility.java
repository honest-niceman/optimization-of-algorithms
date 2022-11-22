package honest.niceman.university.lab3;

public class Utility {
    public static int maxDepth(BinaryTree.Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
