package com.example.deltajavatest.presenter;

import com.example.deltajavatest.model.JsonResponse;

import java.util.List;

public interface MainContract {

    interface Presenter {
        void getJson();
    }

    interface View {
        void displayJson(List<JsonResponse> jsons);
    }
}
