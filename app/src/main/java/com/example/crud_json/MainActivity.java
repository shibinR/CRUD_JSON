package com.example.crud_json;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      Retrofit retrofit =new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api=retrofit.create(Api.class);

        Call<List<ProfileModel>> call=api.getProfile();
        call.enqueue(new Callback<List<ProfileModel>>() {
            @Override
            public void onResponse(Call<List<ProfileModel>> call, Response<List<ProfileModel>> response) {
                List<ProfileModel> profiles=response.body();
                for(ProfileModel p:profiles){
                    Log.d("name",p.getName());
                    Log.d("email",p.getEmail());
                    Log.d("phone",p.getPhone());
                }
            }

            @Override
            public void onFailure(Call<List<ProfileModel>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void PostData(View view){
        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api=retrofit.create(Api.class);
        ProfileModel profileModel=new ProfileModel("","","","","");
        Call<ProfileModel> call=api.PostData(profileModel);
        call.enqueue(new Callback<ProfileModel>() {
            @Override
            public void onResponse(Call<ProfileModel> call, Response<ProfileModel> response) {
                response.body().getJson().getId();
                response.body().getJson().getName();
                response.body().getJson().getUsername();
                response.body().getJson().getEmail();
                response.body().getJson().getPhone();


            }

            @Override
            public void onFailure(Call<ProfileModel> call, Throwable t) {

            }
        });
    }

    public void DeleteData(View view){
        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api=retrofit.create(Api.class);
        Call<Void> call=api.DeleteDData(2);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.code()==200){
                    Log.d("response","deleted");
                }
                else{
                    Log.d("response","failed");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
}