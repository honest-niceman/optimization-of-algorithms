package honest.niceman.university.lab3;

/*
10. Т1 и Т2 – два очень больших бинарных дерева, причем Т1 значительно больше Т2.
Создайте алгоритм, проверяющий, является ли Т2 поддеревом Т1. Дерево Т2 считается
поддеревом T1, если существует такой узел n в Т1, что поддерево, «растущее» из n,
идентично дереву Т2. (Иначе говоря, если вырезать дерево в узле n, оно будет идентично Т2.)
*/
public class Main {
    public static void main(String[] args) {
        BinaryTree t1 = new BinaryTree();

        t1.root = new BinaryTree.Node(26);
        t1.root.right = new BinaryTree.Node(3);
        t1.root.left = new BinaryTree.Node(10);
        t1.root.left.left = new BinaryTree.Node(4);
        t1.root.left.right = new BinaryTree.Node(6);
        t1.root.right.right = new BinaryTree.Node(3);
        t1.root.left.left.right = new BinaryTree.Node(30);
        t1.root.left.left.right.left = new BinaryTree.Node(12);
        t1.root.right.right.left = new BinaryTree.Node(77);
        t1.root.right.right.right = new BinaryTree.Node(78);
        t1.root.right.right.right.right = new BinaryTree.Node(78);
        t1.root.right.right.right.right.right = new BinaryTree.Node(78);
        t1.root.right.right.right.right.right.right = new BinaryTree.Node(78);

        BinaryTree t2 = new BinaryTree();

//        t2.root = new BinaryTree.Node(10);
//        t2.root.left = new BinaryTree.Node(4);
//        t2.root.right = new BinaryTree.Node(6);
//        t2.root.left.right = new BinaryTree.Node(30);
//        t2.root.left.right.left = new BinaryTree.Node(12);

        t2.root = new BinaryTree.Node(777);
        t2.root.left = new BinaryTree.Node(777);
        t2.root.right = new BinaryTree.Node(777);
        t2.root.left.right = new BinaryTree.Node(777);
        t2.root.left.right.left = new BinaryTree.Node(777);


        if (SimpleSolution.isSubtree(t1.root, t2.root)) {
            System.out.println("Straight: Tree 2 is subtree of Tree 1 ");
        } else {
            System.out.println("Straight: Tree 2 is not a subtree of Tree 1");
        }

        System.out.println();
        System.out.println("------------------");
        System.out.println();

        int n = Utility.maxDepth(t1.root);
        int m = Utility.maxDepth(t2.root);

        if (ImprovedSolution.isSubTree(t1.root, t2.root, 0, n - m + 1)) {
            System.out.println("Improved: Tree 2 is subtree of Tree 1 ");
        } else {
            System.out.println("Improved: Tree 2 is not a subtree of Tree 1");
        }

        System.out.println();
        System.out.println("------------------");
        System.out.println();

        if (StringSolution.containsTree(t1.root, t2.root)) {
            System.out.println("String: Tree 2 is subtree of Tree 1 ");
        } else {
            System.out.println("String: Tree 2 is not a subtree of Tree 1");
        }

        System.out.println();
        System.out.println("------------------");
        System.out.println();

        if (StringSolution.containsTree(t1.root, t2.root)) {
            System.out.println("Another: Tree 2 is subtree of Tree 1 ");
        } else {
            System.out.println("Another: Tree 2 is not a subtree of Tree 1");
        }
    }
}
