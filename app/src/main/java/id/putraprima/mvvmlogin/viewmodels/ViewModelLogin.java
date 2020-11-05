package id.putraprima.mvvmlogin.viewmodels;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import id.putraprima.mvvmlogin.models.ModelLogin;

public class ViewModelLogin extends ViewModel{
    private MutableLiveData<ModelLogin> loginMutableLiveData = new MutableLiveData<>();
    private ModelLogin modelLogin;

    public ViewModelLogin(ModelLogin modelLogin){
        this.loginMutableLiveData.setValue(modelLogin);

    }

    public void Login(){
        Log.d("username", this.loginMutableLiveData.getValue().getUsername());
        Log.d("password", this.loginMutableLiveData.getValue().getPassword());

    }

    
}
