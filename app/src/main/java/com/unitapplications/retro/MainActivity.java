package com.unitapplications.retro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.unitapplications.retro.Adapters.MemeAdapter;
import com.unitapplications.retro.Api_Package.ApiClient;
import com.unitapplications.retro.Api_Package.ApiSet;
import com.unitapplications.retro.Models.MemeModel;
import com.unitapplications.retro.Models.ResponseModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    //ArrayList<MemeModel> memeList;
    List<MemeModel> memeList = new ArrayList<>();
    MemeModel memeModel;
    MemeAdapter adapter;
    ApiSet apiSet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        memeList.add(new MemeModel("imran","imran.jpg"));
//        memeList.add(new MemeModel("imran1","imran.jpg"));
//        memeList.add(new MemeModel("imran1","imran.jpg"));

        rv=findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MemeAdapter(MainActivity.this,memeList);
        //adapter.updatememeList(memeList);
        rv.setAdapter(adapter);
        Retrofit retrofit = ApiClient.getClient();
        apiSet = retrofit.create(ApiSet.class);


      makeApiCall();
        //memeList = new ArrayList<>();
    }
    public void makeApiCall(){
        apiSet.getMemes().enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
            try {
                if (response!=null){
                    if (response.body().getStatus().equals("1")){
                        setAdapter(response.body().getData());

                    }else{
                        Toast.makeText(MainActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }

            } catch (Exception e) {
                Log.d("TAG2", "onFailure: "+e.getLocalizedMessage());
            }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Log.d("TAG2", "onFailure: "+t.getLocalizedMessage());
            }
        });
      /*  Call<List<MemeModel>> call = ApiClient.getInstance()
                .getApi()
                .getMemes();
        call.enqueue(new Callback<List<MemeModel>>() {
            @Override
            public void onResponse(Call<List<MemeModel>> call, Response<List<MemeModel>> response) {
                //memeList = new ArrayList<>();
                memeList=response.body();
                Log.d("TAG2", "onResponse: Successful");
                adapter = new MemeAdapter(MainActivity.this,memeList);
                adapter.updatememeList(memeList);
                rv.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<MemeModel>> call, Throwable t) {
                Log.d("TAG2", "onFailure: "+t);
            }
        });*/
    }
    public void setAdapter(List<MemeModel> memeModels){
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        adapter = new MemeAdapter(MainActivity.this,memeModels);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(adapter);
    }
}