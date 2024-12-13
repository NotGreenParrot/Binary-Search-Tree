public class MySearchTree<E extends Comparable<E>> implements Tree<E> {
    private BinNode root;
    private int size;

    public MySearchTree() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public boolean search(E e) {
        BinNode current = root;
        while (current != null) {
            int cmp = e.compareTo(current.getValue());
            if (cmp == 0) {
                return true;
            } else if (cmp < 0) {
                current = current.left();
            } else {
                current = current.right();
            }
        }
        return false;
    }

    @Override
    public boolean insert(E e) {
        if (root == null) {
            root = new BinNode(e);
            size++;
            return true;
        }

        BinNode parent = null;
        BinNode current = root;
        while (current != null) {
            int cmp = e.compareTo(current.getValue());
            if (cmp == 0) {
                return false; // Duplicate value, not inserted
            } else if (cmp < 0) {
                parent = current;
                current = current.left();
            } else {
                parent = current;
                current = current.right();
            }
        }

        BinNode newNode = new BinNode(e);
        if (e.compareTo(parent.getValue()) < 0) {
            parent.setLeft(newNode);
        } else {
            parent.setRight(newNode);
        }
        size++;
        return true;
    }

    @Override
    public boolean delete(E e) {
        // Helper methods for deletion are required, e.g., finding the minimum value in a subtree.
        BinNode parent = null;
        BinNode current = root;

        while (current != null && !current.getValue().equals(e)) {
            parent = current;
            if (e.compareTo(current.getValue()) < 0) {
                current = current.left();
            } else {
                current = current.right();
            }
        }

        if (current == null) {
            return false; // Element not found
        }

        // Case 1: Node to delete has no children (is a leaf)
        if (current.isLeaf()) {
            if (current == root) {
                root = null;
            } else if (parent.left() == current) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
        }

        // Case 2: Node to delete has one child
        else if (current.left() == null || current.right() == null) {
            BinNode child = (current.left() != null) ? current.left() : current.right();
            if (current == root) {
                root = child;
            } else if (parent.left() == current) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
        }

        // Case 3: Node to delete has two children
        else {
            BinNode successorParent = current;
            BinNode successor = current.right();

            while (successor.left() != null) {
                successorParent = successor;
                successor = successor.left();
            }

            current.setValue(successor.getValue());

            if (successorParent.left() == successor) {
                successorParent.setLeft(successor.right());
            } else {
                successorParent.setRight(successor.right());
            }
        }

        size--;
        return true;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void inorder() {
        inorderTraversal(root);
        System.out.println();
    }

    private void inorderTraversal(BinNode node) {
        if (node != null) {
            inorderTraversal(node.left());
            System.out.print(node.getValue() + " ");
            inorderTraversal(node.right());
        }
    }

    @Override
    public void preorder() {
        preorderTraversal(root);
        System.out.println();
    }

    private void preorderTraversal(BinNode node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            preorderTraversal(node.left());
            preorderTraversal(node.right());
        }
    }

    @Override
    public void postorder() {
        postorderTraversal(root);
        System.out.println();
    }

    private void postorderTraversal(BinNode node) {
        if (node != null) {
            postorderTraversal(node.left());
            postorderTraversal(node.right());
            System.out.print(node.getValue() + " ");
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public java.util.Iterator<E> iterator() {
        java.util.List<E> elements = new java.util.ArrayList<>();
        inorderIteratorTraversal(root, elements);
        return elements.iterator();
    }

    private void inorderIteratorTraversal(BinNode node, java.util.List<E> elements) {
        if (node != null) {
            inorderIteratorTraversal(node.left(), elements);
            elements.add(node.getValue());
            inorderIteratorTraversal(node.right(), elements);
        }
    }

    private class BinNode {
        private BinNode left;
        private BinNode right;
        private E value;

        public BinNode(E value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public BinNode left() {
            return left;
        }

        public void setLeft(BinNode left) {
            this.left = left;
        }

        public BinNode right() {
            return right;
        }

        public void setRight(BinNode right) {
            this.right = right;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }
    }
}
