import java.util.List;

public class Parser {

    static List<String> tokens;
    static int pos = 0;

    public static Node parse(List<String> t) {
        tokens = t;
        pos = 0;
        return parseExpression();
    }
    //recursive descent parser
    public static Node parseExpression() {
      String token = tokens.get(pos);
      pos++; //Get the next token

      if(checkfunction(token)){
            Node node = new Node(token);

            pos++ //eat the (

            node.left = parseExpression();


      }else{
            return new Node(token);//just a number
      }
        
    }
}
