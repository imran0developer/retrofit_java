package com.unitapplications.retro.Api_Package;

import com.unitapplications.retro.Models.MemeModel;
import com.unitapplications.retro.Models.ResponseModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiSet {
    @GET("get_posts.php")
    Call<ResponseModel> getMemes();
}