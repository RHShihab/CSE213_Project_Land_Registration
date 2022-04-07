package Users;

import java.io.Serializable;

public class Seller extends User implements Serializable {

    public Seller(String name, String userName, String password, String email) {
        super(name, userName, password, email);
    }
    
    @Override
    public String toString(){
        return "Name: "+fullName + " User name: "+ userName+
                " Password: "+ password + " Email: " + email;
    }
}
