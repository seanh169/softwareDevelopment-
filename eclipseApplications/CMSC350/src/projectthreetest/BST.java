package projectthreetest;

class BST<T extends Comparable<T>> {

    // Variables
    private BSTnode root;
    private StringBuilder result = new StringBuilder();

    /**
     * Default Constructor for BST
     */
    BST() {
        root = null;
        result.setLength(0);    // Resets result StringBuilder
    }

    /**
     * Inserts Node into BST, First node becomes the root
     * @param value Integer or Fraction stored in node
     */
    void insertNode (T value) {
        if (root == null) {                 // if there is no root
            root = new BSTnode(value);      // current node is root
            return;
        }
        insertNodeRecursive(value, root);   // else call insertNodeRecursive(current node, root node)
    }

    /**
     * Determines where each node should be placed in BST
     * @param value Integer or Fraction stored in node
     * @param node Node that current value is compared to, determines location in tree
     */
    private void insertNodeRecursive(T value, BSTnode node) {
        if (value.compareTo(node.value) <= 0) {         // if current node is <= previous node
            if (node.left != null) {                    // and left node is not null
                insertNodeRecursive(value, node.left);  // recurse with new values (current node, left node)
            } else {                                    // else insert current node on left
                node.left = new BSTnode(value);
            }
        } else if (value.compareTo(node.value) > 0) {   // if current node is > previous node
            if (node.right !=null) {                    // and right node is not null
                insertNodeRecursive(value, node.right); // recurse with new values (current node, right node)
            } else {                                    // else insert current node on right
                node.right = new BSTnode(value);
            }
        }
    }

    /**
     * Gets Ascending Sort Order of List
     * @return List of ordered elements
     */
    String getAscending() {
        inorderTraversal(root);
        return result.toString();
    }

    /**
     * Reverses Order of getAscending()
     * @return List of ordered elements
     */
    String getDescending() {
        getAscending();

        // Splits Ascending into array of numbers
        String[] nums = result.toString().split(" ");   // result string is put into an array
        result.setLength(0);    // resets result String
        int len = nums.length;  // gets length of array

        // iterates over array to reverse order of numbers
        for (int i = len - 1; i >= 0; i--) {
            result.append(nums[i]).append(" ");
        }
        return result.toString();
    }

    /**
     * Builds a String of the inorder traversal of the BST
     * @param root Root value of each subtree within BST
     */
    private void inorderTraversal(BSTnode root) {
        if (root.value != null) {
            if (root.getLeft() != null) inorderTraversal(root.getLeft());   // Checks for child on the left
            String res = (root.value).toString();                           // Get toString for root/parent node
            result.append(res).append(" ");
            if (root.getRight() != null) inorderTraversal(root.getRight()); // Checks for child on the right
        }
    }

    /**
     * Defines Node in BST
     */
    class BSTnode {

        // Variables
        private T value;
        private BSTnode left, right;

        BSTnode(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        BSTnode getLeft() {
            return left;
        }

        BSTnode getRight() {
            return right;
        }
    }
    public static void main(String[] args) {
    	BST x = new BST();
    	x.insertNode(4);
    	x.insertNode(8);
    	x.insertNode(2);
    	x.insertNode(1);
    	x.insertNode(23);
    	x.insertNode(16);
    	x.insertNode(8);
    	x.insertNode(16);
    	x.insertNode(3);
    	x.insertNode(14);
    	x.insertNode(2);
    	x.insertNode(10);
    	x.insertNode(24);
//    	System.out.println(x.getAscending());
//    	x.inorderTraversal(x.root);
//    	System.out.println(x.result.toString());
    	System.out.println(x.getDescending());
    	
    	
	}
}
