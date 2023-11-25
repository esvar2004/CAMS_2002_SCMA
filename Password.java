public class Password {
    public static boolean inputPassword(){

        System.out.println("Input Password: ");

        for (int i = 0; i < 3; i++){

            char[] passwordChars = System.console().readPassword(); // Masked input
            // Convert char array to a string
            String password = new String(passwordChars);
            if (password.equals("password")) {
                return true;
            }
            System.out.println("Wrong Password!");
        }
        System.out.println("You have entered an incorrect password 3 times.");
        return false;
    }
    public static boolean checkDefaultPassword(User user) {
        // Assuming 'password' is the default password
        return user.getPassword().equals("password");
    }

    public static void changePassword(User user) {
        System.out.println("As a new user, please change your password.");
        // Add logic to input and validate new password
        // Update user's password
    }
}
