
//This class holds the leaf nodes of the parse tree
public class Tree {
      //Node value
      String value;
      //Left leaf
      Tree left;
      //Right leaf
      Tree right;
      //Third leaf(for the ternary operator)
      Tree third;

      //constructor
      public Tree(String value) {
            this.value = value;
      }




      public String toString(){
    return toStringHelper(0);
}


//---------------this code is copied from AI to help visualize the tree----------------

private String toStringHelper(int depth) {
    String indent = "  ".repeat(depth);
    StringBuilder sb = new StringBuilder();
    sb.append(indent).append(value).append("\n");
    
    if (left != null) {
        sb.append(left.toStringHelper(depth + 1));
    }
    if (right != null) {
        sb.append(right.toStringHelper(depth + 1));
    }
    if (third != null) {
        sb.append(third.toStringHelper(depth + 1));
    }
    
    return sb.toString();
}
}
