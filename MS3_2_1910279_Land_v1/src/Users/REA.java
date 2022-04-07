package Users;

public class REA extends User {

    public REA(String name, String userName, String password, String email) {
        super(name, userName, password, email);
    }
    @Override
    public String toString(){
        return "Name: "+fullName + " User name: "+ userName+
                " Password: "+ password + " Email: " + email;
    }
}