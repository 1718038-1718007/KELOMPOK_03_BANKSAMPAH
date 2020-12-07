package com.example.bank_sampah;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class sampahAdapter extends RecyclerView.Adapter<sampahAdapter.sampahViewHolder> {
    private ArrayList<sampah> dataList;
    public sampahAdapter(ArrayList<sampah> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public sampahAdapter.sampahViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_sampah, parent, false);
        return new sampahViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull sampahViewHolder holder, int position) {
        holder.txtnama.setText(dataList.get(position).getNamasampah());
        holder.txtjenis.setText(dataList.get(position).getJenissampah());
        holder.txturai.setText(dataList.get(position).getUrai());
        holder.gambar.setImageResource(dataList.get(position).getGambar());

    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class sampahViewHolder extends RecyclerView.ViewHolder {
        private TextView txtnama, txtjenis,txturai;
        private ImageView gambar;

        public sampahViewHolder(@NonNull View itemView) {
            super(itemView);
            gambar = (ImageView) itemView.findViewById(R.id.gambar_sampah) ;
            txtnama = (TextView) itemView.findViewById(R.id.txt_nama);
            txtjenis = (TextView) itemView.findViewById(R.id.txt_jenis);
            txturai = (TextView) itemView.findViewById(R.id.txt_urai);

        }
    }
}
