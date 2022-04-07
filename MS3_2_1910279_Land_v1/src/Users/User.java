package Users;

import java.io.Serializable;
import java.util.ArrayList;
import mainpkg.UserList;

public abstract class User implements Serializable{
    protected String fullName,userName,password,userType,email;
    
    public User(String name, String userName, String password, String email){
        this.fullName = name;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public static User login(String userName, String password, String userType){
        ArrayList<User> userList = UserList.GetListOfUser();
        for(User i: userList){
            if(i.userName.equals(userName) && i.password.equals(password) && i instanceof Seller){
                return i;
            }
            else if(i.userName.equals(userName) && i.password.equals(password) && i instanceof Buyer){
                return i;
            }
            else if(i.userName.equals(userName) && i.password.equals(password) && i instanceof REA){
                return i;
            }
        }
        return null;
    }
    
    @Override
    public String toString(){
        return "Name: "+fullName + " User name: "+ userName+
                " Password: "+ password + " Email: " + email + "\n";
    }
    
    
    
}
