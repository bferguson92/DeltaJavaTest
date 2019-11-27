package com.example.deltajavatest.network.service;

import com.example.deltajavatest.model.JsonResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface  JsonService {

    @GET("posts")
    Call<List<JsonResponse>> getJson();

}
