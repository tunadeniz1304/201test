import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    public char c;
    public Node left, right;

    public Node(char c) {
        this.c = c;
        this.left = this.right = null;
    }
}

class Main {
    public static void main(String[] args) {
        Node root = buildTree("43-12+*");
        printTree(root);
    }

    public static Node buildTree(String postfixFormula) {
        // write your implementation of buildTree here
        Stack<Node> stack = new Stack<Node>();

        for (int i = 0; i < postfixFormula.length(); ++i) {
            char c = postfixFormula.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                // * çıktı + çıktı 1 2 çıktı - den de 4 3 çıktı
                Node node = new Node(c);
                Node right = stack.pop();
                Node left = stack.pop();
                node.right = right;
                node.left = left;
                stack.push(node);
            } else {
                Node node = new Node(c);
                stack.push(node);
            }

        }

        return stack.pop();

    }

    public static void printTree(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while (queue.size() > 0) {
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                Node node = queue.remove();
                System.out.print(node.c + " ");

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            System.out.println();
        }

    }
}