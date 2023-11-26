public class UserLoginManager {

    public static void loginUser() {
        User user = Login.login(); // Handle login and get User object

        if (user != null) {
            boolean isDefaultPassword = Password.checkDefaultPassword(user);

            if (isDefaultPassword) {
                // Prompt new user to change password
                Password.changePassword(user);
            }

            // Continue with the regular process after password change or if not a new user        
        }
    }
}
