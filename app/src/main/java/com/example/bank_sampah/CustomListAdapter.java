package com.example.bank_sampah;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
   private Activity activity;
   private LayoutInflater inflater;
   private List<setor_sampah>setorItems;

   CustomListAdapter(Activity activity, List<setor_sampah> setorItems){
       this.activity = activity;
       this.setorItems = setorItems;
   }


    @Override
    public int getCount()
    {
        return setorItems.size();
    }

    @Override
    public Object getItem(int location)
    {
        return setorItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null){
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null){
//            convertView = inflater.inflate(R.layout.costum_list, null);
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.costum_list, null);
        }

        TextView nama = (TextView) convertView.findViewById(R.id.text_nama);
        TextView alamat = (TextView) convertView.findViewById(R.id.text_alamat);
        TextView sampah = (TextView) convertView.findViewById(R.id.text_sampah);
        TextView berat = (TextView) convertView.findViewById(R.id.text_berat);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.iconid);

        setor_sampah m = setorItems.get(position);
        nama.setText("nama : "+ m.getNama());
        alamat.setText("Alamat :"+m.getAlamat());
        sampah.setText("sampah " + m.getSampah());
        berat.setText("berat"+ m.getBerat());
        return convertView;
    }
   }

