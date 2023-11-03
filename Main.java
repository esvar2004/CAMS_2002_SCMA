import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String user = Login.login();

        // What to do about passwords 🥲

        
        if (user.charAt(2) == 'a'){
            String username = user.substring(user.indexOf(' ')+1, user.length());
            String[] list = Login.getList(username, true);
            // for (int i = 0; i < list.length; i++){
            //     System.out.println(list[i]);
            // }
            
            Staff staff = new Staff(list[0], list[1], list[2]);
            // Code for "What commands do you wanna do?"
        }else{
            // student stuff
        }
    }
}

/*
 *                 User
 *                  
 *            student   staff
 *           comm
 * 
 * 
 * 
 */