
public class AVLTree {

    private Node root;

    private class Node {
        int key;
        int height;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
            this.height = 1;
        }
    }

    // Calculates the height of a node
    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // Calculates the balance factor of a node
    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    // Right rotation
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    // Left rotation
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        updateHeight(x);
        updateHeight(y);

        return y;
    }

    // Updates the height of a node
    private void updateHeight(Node node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    // Inserts a key into the AVL tree
    public void insert(int key) {
        root = insert(root, key);
    }

    // Recursive insert helper function
    private Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            // Duplicate keys not allowed
            return node;
        }

        // Update height and balance factor
        updateHeight(node);
        int balance = getBalance(node);

        // Rebalance if needed
        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }
        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }
    
    public void printTree(Node node, int indent) {
        if (node == null) {
            return;
        }
    
        // Print current node first (root-to-leaf order)
        String spacer = "  "; // Adjust spacing as needed
        String leftBranch = "├─";
        String rightBranch = "└─";
    
        // Construct indentation string:
        String indention = "";
        for (int i = 0; i < indent; i++) {
            indention += spacer;
        }
        System.out.print(indention + rightBranch + node.key + "\n");
    
        // Then print subtrees
        printTree(node.left, indent + 1);
        printTree(node.right, indent + 1);
    }

    public static void main(String[] args) {
        // Create an AVL tree
        AVLTree tree = new AVLTree();

        // Insert some keys into the tree
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(60);
        tree.insert(70);
        
        // Print the tree
        tree.printTree(tree.root, 0);
    }
}