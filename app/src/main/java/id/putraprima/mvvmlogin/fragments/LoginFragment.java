package id.putraprima.mvvmlogin.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.putraprima.mvvmlogin.R;
import id.putraprima.mvvmlogin.databinding.FragmentLoginBinding;
import id.putraprima.mvvmlogin.databinding.FragmentLoginBindingImpl;
import id.putraprima.mvvmlogin.models.ModelLogin;
import id.putraprima.mvvmlogin.viewmodels.ViewModelLogin;
import id.putraprima.mvvmlogin.viewmodels.ViewModelLoginFactory;

public class LoginFragment extends Fragment {
    private ViewModelLogin viewModelLogin;
    Bundle bundle = new Bundle();
    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentLoginBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login, container, false);
        ViewModelLoginFactory viewModelLoginFactory = new ViewModelLoginFactory(new ModelLogin("alizarizqi@gmail.com","aliza"));
        viewModelLogin = new ViewModelProvider(this, viewModelLoginFactory).get(ViewModelLogin.class);
        View view = binding.getRoot();
        binding.setViewModel(viewModelLogin);
        binding.setLifecycleOwner(this);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModelLogin.validLiveData().observe(this.getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(viewModelLogin.validLiveData().getValue() == true){
                    bundle.putString("username", viewModelLogin.modelLoginLiveData().getValue().username);
                    Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment, bundle);
                }
            }
        });


    }
}