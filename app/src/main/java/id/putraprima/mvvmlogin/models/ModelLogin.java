package id.putraprima.mvvmlogin.models;

public class ModelLogin {
    String password;
    String username;

    public ModelLogin(){

    }
    public ModelLogin(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
