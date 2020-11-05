package id.putraprima.mvvmlogin.models;

import android.os.Parcel;
import android.os.Parcelable;

public class ModelLogin implements Parcelable {
    String password="aliza";
    String username ="alizarizqi@gmail.com";

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.password);
        dest.writeString(this.username);
    }

    protected ModelLogin(Parcel in) {
        this.password = in.readString();
        this.username = in.readString();
    }

    public static final Creator<ModelLogin> CREATOR = new Creator<ModelLogin>() {
        @Override
        public ModelLogin createFromParcel(Parcel source) {
            return new ModelLogin(source);
        }

        @Override
        public ModelLogin[] newArray(int size) {
            return new ModelLogin[size];
        }
    };
}
