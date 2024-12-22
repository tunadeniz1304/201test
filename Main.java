import java.util.Stack;

class Main {
 public static void main( String[] args ){
 Node root = buildTree( "43-12+*" );
 }
 public static Node buildTree( String postfixFormula ) {
 // write your implementation of buildTree here
 Stack<Node> stack = new Stack<Node>();


    for (int i = 0; i < postfixFormula.length(); i++) {

        char c = postfixFormula.charAt(i);
        
        Node right = stack.pop();
        Node left = stack.pop();
        Node node = new Node(c);
        node.left = left;
        node.right = right;
        stack.push(node);   
 }
    return stack.pop();
    }
}