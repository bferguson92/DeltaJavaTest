package com.example.deltajavatest.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.deltajavatest.R;
import com.example.deltajavatest.model.JsonResponse;

import org.w3c.dom.Text;

import java.util.List;

public class JsonAdapter extends RecyclerView.Adapter<JsonAdapter.CustomViewHolder> {
    private List<JsonResponse> jsons;

    public List<JsonResponse> getJsons() {
        return jsons;
    }

    public void setJsons(List<JsonResponse> jsons) {
        this.jsons = jsons;
    }

    public JsonAdapter(List<JsonResponse> jsons) {
        this.jsons = jsons;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_view, parent, false);

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.userId.setText(jsons.get(position).getUserId().toString());
        holder.id.setText(jsons.get(position).getId().toString());
        holder.title.setText(jsons.get(position).getTitle());
        holder.overview.setText(jsons.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return jsons.size();
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        private TextView userId;
        private TextView id;
        private TextView title;
        private TextView overview;

        private CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            userId = itemView.findViewById(R.id.user_id);
            id = itemView.findViewById(R.id.id);
            title = itemView.findViewById(R.id.title);
            overview = itemView.findViewById(R.id.body);
        }
    }
}
