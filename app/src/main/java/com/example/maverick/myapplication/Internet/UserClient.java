package com.example.maverick.myapplication.Internet;

import com.example.maverick.myapplication.Internet.User;
import com.example.maverick.myapplication.Internet.Login;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserClient {


    @POST("login/")
    Call<User> login(@Body Login login);

    //@GET("secretinfo")
    //Call<ResponseBody> getSecret(@Header("Authorisation") String authToken);
}
