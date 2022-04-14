package Users;

import java.io.Serializable;

public class RegistrationOfficer extends User  implements Serializable{

    public RegistrationOfficer(String name, String userName, String password, String email) {
        super(name, userName, password, email);
    }

    public String getFullName() {
        return fullName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }

    public String getEmail() {
        return email;
    }
    @Override
    public String toString(){
        return "User name: "+ userName+ 
               ", Password: "+ password +
               ", Name: "+fullName + 
               ", Email: " + email;
    }
}