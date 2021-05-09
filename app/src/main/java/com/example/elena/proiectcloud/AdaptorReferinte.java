package com.example.elena.proiectcloud;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class AdaptorReferinte extends ArrayAdapter {
    public AdaptorReferinte(@NonNull Context context, int resource, @NonNull ArrayList<Referinta> objects) {
        super(context, resource, objects);
    }


    static class ViewHolder {
        TextView tvTitlu;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder v;
        View res;
        Referinta referinta=(Referinta)getItem(position);
        if(convertView==null) {
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.afisare_referinta, parent,false );
            v=new ViewHolder();
            v.tvTitlu=(TextView)convertView.findViewById(R.id.tv_element);
            convertView.setTag(v);
        } else {
            v=(ViewHolder)convertView.getTag();
            res= convertView;

        }

        v.tvTitlu.setText(referinta.getTitluJurnal());

        return convertView;
    }
}
