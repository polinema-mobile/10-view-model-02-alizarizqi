package id.putraprima.mvvmlogin.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import id.putraprima.mvvmlogin.models.ModelLogin;

public class ViewModelHome extends ViewModel {
    private MutableLiveData<ModelLogin> homeMutableLiveData = new MutableLiveData<>();
    private ModelLogin modelLogin;

    public ViewModelHome(ModelLogin modelLogin){
        this.modelLogin = modelLogin;
        this.homeMutableLiveData.setValue(modelLogin);
    }
    public LiveData<ModelLogin> modelLoginLiveData(){
        return homeMutableLiveData;
    }
}
