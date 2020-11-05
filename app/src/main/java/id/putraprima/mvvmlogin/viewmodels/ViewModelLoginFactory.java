package id.putraprima.mvvmlogin.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;


import id.putraprima.mvvmlogin.models.ModelLogin;

public class ViewModelLoginFactory implements ViewModelProvider.Factory {

    private ModelLogin modelLogin;

    public ViewModelLoginFactory(ModelLogin modelLogin){
        this.modelLogin = modelLogin;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(ViewModelLogin.class)){
            return (T) new ViewModelLogin(modelLogin);
        }
        throw new IllegalArgumentException("Permintaan ViewModel ViewModelLogin");
    }
}
