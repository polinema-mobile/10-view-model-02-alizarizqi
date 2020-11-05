package id.putraprima.mvvmlogin.viewmodels;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import id.putraprima.mvvmlogin.models.ModelLogin;

public class ViewModelLogin extends ViewModel{
    private MutableLiveData<ModelLogin> loginMutableLiveData = new MutableLiveData<>();
    private ModelLogin modelLogin;

    public String username, password;

    public ViewModelLogin(ModelLogin modelLogin){
        this.modelLogin = modelLogin;
        this.loginMutableLiveData.setValue(this.modelLogin);

    }

    public boolean isLogin(){
        if(username.equals(modelLogin.getUsername()) && password.equals(modelLogin.getPassword())){
            return true;
        }else{
            return false;
        }
    }
    public LiveData<ModelLogin> modelLoginLiveData(){
        return loginMutableLiveData;
    }
    }

    

