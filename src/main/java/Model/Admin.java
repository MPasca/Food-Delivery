package Model;

public class Admin extends User{
    private final static String username = "admin";
    private final static String password = "admin";

    public Admin(){
        super(username, password);
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }
}
