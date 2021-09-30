package online.javabook.algo.dsa.api.tree.binary;

public class SimpleBinaryTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public SimpleBinaryTree(Node root) {
        this.root = root;
    }

    public void prepOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.getItem());
        System.out.print(" → ");
        prepOrder(node.getLeft());
        prepOrder(node.getRight());
    }

    public void inorder(Node node) {
        if (node == null) {
            return;
        }

        inorder(node.getLeft());
        System.out.print(node.getItem());
        System.out.print(" → ");
        inorder(node.getRight());
    }

    public void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.print(node.getItem());
        System.out.print(" → ");
    }

    public int getTreeDeep(Node node) {
        int deep = 0;
        if (node != null) {
            deep = 1;
        } else {
            return 0;
        }

        int leftDeep = getTreeDeep(node.getLeft());
        int rightDeep = getTreeDeep(node.getRight());
        if (leftDeep > rightDeep) {
            return deep + leftDeep;
        }
        return deep + rightDeep;
    }

    public static void main(String[] args) {

        Node root = new Node<String>("A");
        SimpleBinaryTree binaryTree = new SimpleBinaryTree(root);

        Node b = new Node("B");
        Node c = new Node("C");
        root.setLeft(b);
        root.setRight(c);

        b.setLeft(new Node("D"));
        b.setRight(new Node("E"));
        c.setLeft(new Node("F"));
        c.setRight(new Node("G"));

        System.out.println("先序遍历:");
        binaryTree.prepOrder(root);

        System.out.println("\n中序遍历:");
        binaryTree.inorder(root);

        System.out.println("\n后序遍历:");
        binaryTree.postOrder(root);

        //
        System.out.println("树的深度:");
        System.out.println(binaryTree.getTreeDeep(root));
    }
}
