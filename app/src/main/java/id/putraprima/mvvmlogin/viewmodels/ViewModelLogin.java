package id.putraprima.mvvmlogin.viewmodels;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import id.putraprima.mvvmlogin.models.ModelLogin;

public class ViewModelLogin extends ViewModel{
    private MutableLiveData<ModelLogin> loginMutableLiveData = new MutableLiveData<>();
    private ModelLogin modelLogin;

    public void Login(){
        this.cekUsername();
        this.cekPassword();

    }

    public void cekUsername(){

    }
    public void cekPassword(){

    }
}
