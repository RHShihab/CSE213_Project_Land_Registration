package Users;

public class RegistrationOfficer extends User {

    public RegistrationOfficer(String name, String userName, String password, String email) {
        super(name, userName, password, email);
    }
    @Override
    public String toString(){
        return "Name: "+fullName + " User name: "+ userName+
                " Password: "+ password + " Email: " + email;
    }
}