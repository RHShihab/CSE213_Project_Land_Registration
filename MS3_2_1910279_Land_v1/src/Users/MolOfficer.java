package Users;

import java.io.Serializable;

public class MolOfficer extends User  implements Serializable{

    public MolOfficer(String name, String userName, String password, String email) {
        super(name, userName, password, email);
    }
    @Override
    public String toString(){
        return "User name: "+ userName+ 
               ", Password: "+ password +
               ", Name: "+fullName + 
               ", Email: " + email;
    }
}