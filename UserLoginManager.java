public class UserLoginManager extends Login{

    public static void loginUser() {
        User user = login();

        if (user != null) {
            boolean isDefaultPassword = Password.checkDefaultPassword(user);

            if (isDefaultPassword) {
                // Prompt new user to change password
                Password.changePassword(user);
            }     
        }
    }
}
