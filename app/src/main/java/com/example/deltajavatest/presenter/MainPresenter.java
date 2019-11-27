package com.example.deltajavatest.presenter;

import com.example.deltajavatest.model.JsonResponse;
import com.example.deltajavatest.network.factory.JsonFactory;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContract.Presenter {
    private JsonFactory jsonFactory;
    private MainContract.View view;

    public MainPresenter(MainContract.View view) {
        jsonFactory = new JsonFactory();
        this.view = view;
    }

    public JsonFactory getJsonFactory() {
        return jsonFactory;
    }

    public void setJsonFactory(JsonFactory jsonFactory) {
        this.jsonFactory = jsonFactory;
    }

    @Override
    public void getJson() {
        jsonFactory.getJson().enqueue(new Callback<List<JsonResponse>>() {

            @Override
            public void onResponse(Call<List<JsonResponse>> call, Response<List<JsonResponse>> response) {
                view.displayJson(response.body());
            }

            @Override
            public void onFailure(Call<List<JsonResponse>> call, Throwable t) {

            }
        });
    }
}
