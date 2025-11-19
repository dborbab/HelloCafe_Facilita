package com.example.facilita;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {
    //String BASE_URL = "http://10.17.235.216/facilita/api/";
    String BASE_URL = "http://192.168.244.186/facilita/api/";

    @GET("users/login")
    Call<ResponseBody> login(@Header("email") String email, @Header("password") String password);

    @GET("products/{cafe_id}")
    Call<ProductResponse> getProducts(@Path("cafe_id") int cafeId);

    @GET("tasks/{cafe_id}")
    Call<TaskResponse> getTasks(@Path("cafe_id") int cafeId);

    @POST("users/add")
    Call<ResponseBody> register(@Body RequestBody body);
}
