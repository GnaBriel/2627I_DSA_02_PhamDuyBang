import java.util.*;
import java.io.*;
public class JavaStringReverse{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder reversed = new StringBuilder(input);
        reversed.reverse();
        if(input.equals(reversed.toString())){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}