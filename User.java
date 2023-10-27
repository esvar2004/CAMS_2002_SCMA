import java.util.Scanner;

public class User{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String username;
        // while (username )
        System.out.println("Input Your Username: ");
        username = sc.next();
    }
    public boolean contains_number(String s){
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') return true;
        }
        return false;
    }
    public boolean contains_char(String s){
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z' || s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') return true;
        }
        return false;
    }
}