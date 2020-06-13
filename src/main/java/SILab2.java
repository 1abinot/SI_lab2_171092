import java.util.List;

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

public class SILab2 {

    public boolean function (User user, List<String> allUsers) {
        String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}"; //A
        if (user!=null) { //B
            if (user.getUsername()!=null && user.getPassword()!=null) { //C
                String password = user.getPassword(); //D
                String passwordLower = password.toLowerCase(); //E
                if (!passwordLower.contains(user.getUsername().toLowerCase()) && password.length()>=8) { //F
                    boolean digit = false, upper = false, special = false; //G
                    for (int i=0;i<password.length();i++) { //H
                        if (Character.isDigit(password.charAt(i))) //I
                            digit = true; //J
                        if (Character.isUpperCase(password.charAt(i))) //K
                            upper = true; //L
                        if (specialCharacters.contains(String.valueOf(password.charAt(i)))) //M
                            special = true; //N
                    }
                    if (digit && upper && special) //O
                        return true; //P
                }
            }
        }
        return false; //Q
    }
}
