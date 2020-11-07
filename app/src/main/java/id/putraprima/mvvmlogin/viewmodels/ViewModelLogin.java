package id.putraprima.mvvmlogin.viewmodels;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import id.putraprima.mvvmlogin.models.ModelLogin;

public class ViewModelLogin extends ViewModel{
    private MutableLiveData<ModelLogin> loginMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> validMutableLive = new MutableLiveData<>();
    private MutableLiveData<String> errorUsername = new MutableLiveData<>();
    private MutableLiveData<String> errorPassword = new MutableLiveData<>();
    private ModelLogin modelLogin;
    public String username, password;

    public ViewModelLogin(ModelLogin modelLogin){
        this.modelLogin = modelLogin;
        this.loginMutableLiveData.setValue(this.modelLogin);

    }

    public void isLogin(){
        if(modelLogin.getUsername().equals(username) && modelLogin.getPassword().equals(password)){
            loginMutableLiveData.setValue(modelLogin);
            validMutableLive.setValue(true);
            return;
        }else if(modelLogin.getUsername().isEmpty() && modelLogin.getPassword().isEmpty()){
            errorUsername.setValue("Masukkan username");
            errorPassword.setValue("Masukkan Password");
            validMutableLive.setValue(false);
            return;
        }else if(modelLogin.getUsername().isEmpty() || modelLogin.getUsername() == null && modelLogin.getPassword().equals(password)){
            errorUsername.setValue("Masukkan username");
            validMutableLive.setValue(false);
        }else if(modelLogin.getUsername().equals(username) && modelLogin.getPassword().isEmpty() || modelLogin.getPassword() == null){
            errorPassword.setValue("Masukkan password");
            validMutableLive.setValue(false);
            return;
        }else if(!modelLogin.getUsername().equals(username) || !modelLogin.getPassword().equals(password)){
            errorUsername.setValue("Masukkan username yang benar");
            errorPassword.setValue("Masukkan password yang benar");
            validMutableLive.setValue(false);
            return;
        }
    }
    public LiveData<ModelLogin> modelLoginLiveData(){
        return loginMutableLiveData;
    }
    public LiveData<Boolean> validLiveData() {
        return this.validMutableLive;
    }
    public LiveData<String> errorUsername(){
        return this.errorUsername;
    }
    public LiveData<String> errorPassword(){
        return this.errorPassword;
    }
}


    

