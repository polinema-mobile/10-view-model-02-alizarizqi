package id.putraprima.mvvmlogin.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
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
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewModelLogin.isLogin()){
                    Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment);
                }else{
                    binding.editTextEmail.setError("Username harus sesuai");
                    binding.editTextPassword.setError("Password harus sesuai");
                }
            }
        });
        return view;

    }
}