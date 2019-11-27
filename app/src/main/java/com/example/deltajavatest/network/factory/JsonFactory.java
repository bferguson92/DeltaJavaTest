package com.example.deltajavatest.network.factory;

import com.example.deltajavatest.model.JsonResponse;
import com.example.deltajavatest.network.service.JsonService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JsonFactory {

    public JsonService jsonService;

    public JsonFactory() {
       jsonService = createService(getRetrofitInstance());
    }

    public Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public JsonService createService(Retrofit retrofit) {
        return retrofit.create(JsonService.class);
    }

    public Call<List<JsonResponse>> getJson(){
        return jsonService.getJson();
    }

    public JsonService getJsonService() {
        return jsonService;
    }

    public void setJsonService(JsonService jsonService) {
        this.jsonService = jsonService;
    }
}
