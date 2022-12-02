package com.unitapplications.retro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.unitapplications.retro.Api_Package.ApiClient;
import com.unitapplications.retro.Api_Package.ApiSet;
import com.unitapplications.retro.Models.ResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AddActivity extends AppCompatActivity {
    Button save;
    EditText header_et;
    ApiSet apiSet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        save = findViewById(R.id.save);
        header_et = findViewById(R.id.editTextTextPersonName);

        Retrofit retrofit = ApiClient.getClient();
     apiSet = retrofit.create(ApiSet.class);

        save.setOnClickListener(view -> {
            if (header_et!=null){
                String hearder_str = header_et.getText().toString();
                header_et.setText("");
                setMeme(hearder_str);

            }else{
                header_et.setError("Name is Empty");
            }
        });

    }

    public void setMeme(String header_str){
        apiSet.setMemes(header_str).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                try {
                    if (response!=null){
                        if (response.body().getStatus().equals("1")){
                            Toast.makeText(AddActivity.this, "Added Successfully", Toast.LENGTH_SHORT).show();
            
                        }else{
                            Toast.makeText(AddActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
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
    }
}