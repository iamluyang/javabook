package online.javabook.algo.dsa.api.tree.btree;


// Searching a key on a B-tree in Java

public class BTree {

    private int degree;

    /**
     * Node creation
     */
    public class BTreeNode {

        // 当前节点存在多少个Key
        int keyTotal;

        // 当前节点包含的key
        int keys[] = new int[2 * degree - 1];

        // 当前节点的子节点容器
        BTreeNode children[] = new BTreeNode[2 * degree];

        // 当前节点是否是叶子节点
        boolean leaf = true;

        /**
         * 返回查找的key在当前节点keys容器中的索引位置
         * @param key
         * @return
         */
        public int find(int key) {
            for (int index = 0; index < this.keyTotal; index++) {
                if (this.keys[index] == key) {
                    return index;
                }
            }
            return -1;
        }
    }

    // btree的根节点
    private BTreeNode root;

    /**
     *
     * @param degree
     */
    public BTree(int degree) {
        this.degree = degree;
        this.root = new BTreeNode();
        this.root.keyTotal = 0;
        this.root.leaf = true;
    }

    /**
     * 查询key是否存在
     *
     * @param key
     * @return
     */
    public boolean contain(int key) {
        if (this.search(root, key) != null) {
            return true;
        } else {
            return false;
        }
    }

    private BTreeNode search(BTreeNode node, int key) {
        int keyIndex;

        // 判断节点的有效性
        if (node == null)
            return null;

        for (keyIndex = 0; keyIndex < node.keyTotal; keyIndex++) {
            // 如果被查询的key小于当前key列表中的第一个key值，则
            if (key < node.keys[keyIndex]) {
                break;
            }
            // 如果被查询的key等于当前key列表中的key值，则当前节点就是要找的节点
            if (key == node.keys[keyIndex]) {
                return node;
            }
            // 否则一直循环递增keyIndex的值，直到返回大于key的结束区间索引位置
        }
        if (node.leaf) {
            return null;
        } else {
            return search(node.children[keyIndex], key);
        }
    }

    /**
     * 插入一个key值，当节点的keys容器满了，则会产生节点的分裂
     *
     * @param key
     */
    public void insert(final int key) {

        BTreeNode oldRoot = root;

        // 如果当前root节点的key已经满了，则创建一个新的BTreeNode节点，并分裂当前节点
        if (oldRoot.keyTotal == 2 * degree - 1) {
            BTreeNode newRoot = new BTreeNode();

            // 用新节点代替root节点
            root = newRoot;
            // 新节点为内部节点类型
            newRoot.leaf = false;
            // 新节点的keys为空
            newRoot.keyTotal = 0;
            // 老的root节点成为新节点的第一个子节点
            newRoot.children[0] = oldRoot;
            // 节点分裂
            split(newRoot, 0, oldRoot);
            // 将插入的key放入newRoot节点中
            insertValue(newRoot, key);
        } else {
            insertValue(oldRoot, key);
        }
    }

    /**
     * 节点的分裂
     *
     * @param newNode
     * @param pos
     * @param oldNode
     */
    private void split(BTreeNode newNode, int pos, BTreeNode oldNode) {

        BTreeNode splitNode = new BTreeNode();
        splitNode.leaf = oldNode.leaf;
        splitNode.keyTotal = degree - 1;

        for (int j = 0; j < degree - 1; j++) {
            splitNode.keys[j] = oldNode.keys[j + degree];
        }
        if (!oldNode.leaf) {
            for (int j = 0; j < degree; j++) {
                splitNode.children[j] = oldNode.children[j + degree];
            }
        }
        oldNode.keyTotal = degree - 1;
        for (int j = newNode.keyTotal; j >= pos + 1; j--) {
            newNode.children[j + 1] = newNode.children[j];
        }
        newNode.children[pos + 1] = splitNode;

        for (int j = newNode.keyTotal - 1; j >= pos; j--) {
            newNode.keys[j + 1] = newNode.keys[j];
        }
        newNode.keys[pos] = oldNode.keys[degree - 1];
        newNode.keyTotal = newNode.keyTotal + 1;
    }

    /**
     * Insert the node
     *
     * @param bTreeNode
     * @param key
     */
    final private void insertValue(BTreeNode bTreeNode, int key) {

        if (bTreeNode.leaf) {
            int i = 0;
            for (i = bTreeNode.keyTotal - 1; i >= 0 && key < bTreeNode.keys[i]; i--) {
                bTreeNode.keys[i + 1] = bTreeNode.keys[i];
            }
            bTreeNode.keys[i + 1] = key;
            bTreeNode.keyTotal = bTreeNode.keyTotal + 1;
        } else {
            int i = 0;
            for (i = bTreeNode.keyTotal - 1; i >= 0 && key < bTreeNode.keys[i]; i--) {
                //
            }

            i++;
            BTreeNode tempNode = bTreeNode.children[i];
            if (tempNode.keyTotal == 2 * degree - 1) {
                split(bTreeNode, i, tempNode);
                if (key > bTreeNode.keys[i]) {
                    i++;
                }
            }
            insertValue(bTreeNode.children[i], key);
        }
    }

    /**
     * 显示BTree
     */
    public void show() {
        show(root);
    }

    /**
     * 显示BTree
     *
     * @param btreeNtode
     */
    private void show(BTreeNode btreeNtode) {
        for (int i = 0; i < btreeNtode.keyTotal; i++) {
            System.out.print(btreeNtode.keys[i] + " ");
        }
        if (!btreeNtode.leaf) {
            for (int i = 0; i < btreeNtode.keyTotal + 1; i++) {
                show(btreeNtode.children[i]);
            }
        }
    }

    public static void main(String[] args) {
        BTree bTree = new BTree(3);
        bTree.insert(8);
        bTree.insert(9);
        bTree.insert(10);
        bTree.insert(11);
        bTree.insert(15);
        bTree.insert(20);
        bTree.insert(17);

        bTree.show();

        if (bTree.contain(20)) {
            System.out.println("\nfound");
        } else {
            System.out.println("\nnot found");
        }
    }
}
