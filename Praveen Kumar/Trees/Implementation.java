import java.util.ArrayList;
import java.util.List;

class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
    public static void displayTree(Node root) {
        if (root == null)
            return;
        System.out.println(root.val);
        displayTree(root.left);
        displayTree(root.right);
    }

    public static int maxInTree(Node root) {
        if (root == null)
            return Integer.MIN_VALUE;
        int leftMax = maxInTree(root.left);
        int rightMax = maxInTree(root.right);
        return Math.max(root.val, Math.max(leftMax, rightMax));
    }

    public static int sumOfTree(Node root) {
        if (root == null)
            return 0;
        return root.val + sumOfTree(root.left) + sumOfTree(root.right);
    }

    public static int sizeOfTree(Node root) {
        if (root == null)
            return 0;
        return 1 + sizeOfTree(root.left) + sizeOfTree(root.right);
    }

    public static int diameterOfTree(Node root) {
        int[] diameter = new int[1]; // Use an array to store the max diameter
        helper(root, diameter);
        return diameter[0];
    }

    private static int helper(Node root, int[] diameter) {
        if (root == null)
            return 0;
        int leftHeight = helper(root.left, diameter);
        int rightHeight = helper(root.right, diameter);
        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    private static void pathHelper(Node root, String path, List<String> ans) {
        if (root == null)
            return;
        if (!path.isEmpty()) {
            path += "->";
        }
        path += root.val;
        if (root.left == null && root.right == null) {
            ans.add(path);
            return;
        }
        pathHelper(root.left, path, ans);
        pathHelper(root.right, path, ans);
    }

    public static List<String> binaryTreePaths(Node root) {
        List<String> ans = new ArrayList<>();
        pathHelper(root, "", ans);
        return ans;
    }
}

public class Implementation {
    public static void main(String args[]) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;

        System.out.println("Tree Display:");
        BinaryTree.displayTree(a);

        System.out.println("Max Value in Tree: " + BinaryTree.maxInTree(a));
        System.out.println("Sum of Tree: " + BinaryTree.sumOfTree(a));
        System.out.println("Size of Tree: " + BinaryTree.sizeOfTree(a));
        System.out.println("Diameter of Tree: " + BinaryTree.diameterOfTree(a));

        System.out.println("Binary Tree Paths: " + BinaryTree.binaryTreePaths(a));
    }
}
