package com.example.deltajavatest.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.deltajavatest.R;
import com.example.deltajavatest.adapter.JsonAdapter;
import com.example.deltajavatest.model.JsonResponse;
import com.example.deltajavatest.presenter.MainContract;
import com.example.deltajavatest.presenter.MainPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        MainPresenter mainPresenter = new MainPresenter(this);
        mainPresenter.getJson();
    }

    @Override
    public void displayJson(List<JsonResponse> jsons) {

        JsonAdapter jsonAdapter = new JsonAdapter(jsons);
        recyclerView.setAdapter(jsonAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
