package com.example.bank_sampah;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MetaAdapter  extends RecyclerView.Adapter<MetaAdapter.MetaViewHolder> {
    private List<setor_sampah> setorItems;

    public MetaAdapter(List<setor_sampah> setorItems) {
        this.setorItems = setorItems;
    }

    @NonNull
    @Override
    public MetaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.costum_list, null);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MetaViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MetaViewHolder extends RecyclerView.ViewHolder {
        public MetaViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
