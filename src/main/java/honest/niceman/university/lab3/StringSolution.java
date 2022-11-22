package honest.niceman.university.lab3;

public class StringSolution {
    public static boolean containsTree(BinaryTree.Node t1,
                                       BinaryTree.Node t2) {
        StringBuilder tree1 = new StringBuilder();
        StringBuilder tree2 = new StringBuilder();

        getOrderString(t1, tree1);
        getOrderString(t2, tree2);

        return tree1.indexOf(tree2.toString()) != -1;
    }

    private static void getOrderString(BinaryTree.Node node,
                                      StringBuilder sb) {
        if (node == null) {
            sb.append("N");
            return;
        }
        sb.append(node.value);
        getOrderString(node.left, sb);
        getOrderString(node.right, sb);
    }
}
