package online.javabook.algo.dsa.api.tree.binary;

public class FullBinaryTree extends SimpleBinaryTree {

    private Node root;

    public FullBinaryTree(Node root) {
        super(root);
    }

    public Node getRoot() {
        return root;
    }

    public boolean isFullBinaryTree(Node node) {
        if (node == null) {
            return true;
        }

        if (node.getLeft() == null && node.getRight() == null)
            return true;

        if ((node.getLeft() != null) && (node.getRight() != null))
            return (isFullBinaryTree(node.getLeft()) && isFullBinaryTree(node.getRight()));

        return false;
    }

    public static void main(String[] args) {

        Node root = new Node<Integer>(1);
        FullBinaryTree binaryTree = new FullBinaryTree(root);

        Node _2 = new Node(2);
        Node _3 = new Node(3);
        Node _4 = new Node(4);
        Node _5 = new Node(5);
        Node _6 = new Node(6);
        Node _7 = new Node(7);

        root.setLeft(_2);
        root.setRight(_3);

        _2.setLeft(_4);
        _2.setRight(_5);

        _5.setLeft(_6);
        _5.setRight(_7);

        System.out.println("判断是否是满二叉树:");
        System.out.println(binaryTree.isFullBinaryTree(root));
    }
}
