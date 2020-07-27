package com.example.crud_json;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface Api {
    String BASE_URL="https://my-json-server.typicode.com/shibinR/sample/";
    @GET("profile")
    Call<List<ProfileModel>> getProfile();

    @PUT("profile")
    Call<ProfileModel> PostData(@Body ProfileModel profileModel);

    @DELETE("profile/{id}")
    Call<Void> DeleteDData(@Path("id") int id);
}
