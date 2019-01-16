package tribu;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Eje2 {
	static Stack<String> stSigns = new Stack<>();
    static Stack<String> stNumbers = new Stack<>();

    public static void main(String args[]) {
        String operation = "2*4 +6";
        separateOperation(operation);
        System.out.println(orderOperation());
    }


    static public void separateOperation (String operation){
        Pattern patterns = Pattern.compile("[0-9]");
        Matcher matcher ;

        for (char c : operation.toCharArray()) {
            matcher = patterns.matcher("" + c);
            if (matcher.matches()) {
                stNumbers.push("" + c);
            } else {
            	stSigns.push("" + c);
            }
        }

    }
    static public String orderOperation (){
        StringBuilder result= new StringBuilder();
        int size = stSigns.size();
        for (int i =0; i<stSigns.size();i++){
            if (i==0 && (stSigns.peek().equals("*") || stSigns.peek().equals("/"))) {
                result.append(stSigns.pop()); 
                result.append(stNumbers.pop());
                result.append(stNumbers.pop());
            }else if (stSigns.peek().equals(" ")){
            	result.append(stSigns.pop());
                if (stSigns.peek().equals("*") || stSigns.peek().equals("/")) {
                	result.append(stSigns.pop());
                	result.append(stNumbers.pop());
                	result.append(stNumbers.pop());
                }else{
                	result.append(stSigns.pop());
                	result.append(stNumbers.pop());
                }

             }else if(stSigns.peek().equals("*") || stSigns.peek().equals("/")){
            	 result.append(stSigns.pop());
            	 result.append(stNumbers.pop());
            	 result.append(stNumbers.pop());

            }else{
            	result.append(stSigns.pop());
            	result.append(stNumbers.pop());
            }
        }

        return result.toString();
    }

}