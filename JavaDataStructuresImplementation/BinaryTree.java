import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    static Scanner in = new Scanner(System.in);

    static Node buildTree() {
        System.out.println("Enter Data: ");
        int data = in.nextInt(); 
        if(data == -1) return null;
        Node root = new Node(data);

        System.out.println("Enter data for inserting left of: " + data);
        root.left = buildTree();
        System.out.println("Enter data for inserting right of: " + data);
        root.right = buildTree();

        return root;
    }

    static void levelOrderTraversal(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();

            if (temp != null) {
                System.out.print(temp.data + " ");
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
        System.out.println();
    }

    static Node buildFromLevelOrder() {
        Queue<Node> q = new LinkedList<>();
        System.out.println("Enter data for root Node: ");
        int data = in.nextInt();
        Node root = new Node(data);
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();

            System.out.println("Enter left node for " + temp.data);
            int leftData = in.nextInt();

            if (leftData != -1) {
                temp.left = new Node(leftData);
                q.add(temp.left);
            }

            System.out.println("Enter right node for " + temp.data);
            int rightData = in.nextInt();

            if (rightData != -1) {
                temp.right = new Node(rightData);
                q.add(temp.right);
            }
        }
        return root;
    }

    static void inorder(Node root) {
        if(root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    static void preorder(Node root) {
        if(root == null) return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    static void postorder(Node root) {
        if(root == null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        Node root;

        root = buildFromLevelOrder();//1 3 5 7 11 17 -1 -1 -1 -1 -1 -1 -1
        //root=buildTree(); //1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1 
        levelOrderTraversal(root);

        System.out.println("Inorder traversal: ");
        inorder(root);
        System.out.println();

        System.out.println("Preorder traversal: ");
        preorder(root);
        System.out.println();

        System.out.println("Postorder traversal: ");
        postorder(root);
        System.out.println();

        in.close();
    }
}
