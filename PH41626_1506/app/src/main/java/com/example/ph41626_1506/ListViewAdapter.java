package com.example.ph41626_1506;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    final Context  context;
    final ArrayList<Teacher> lstTeacher;

    public ListViewAdapter(Context context, ArrayList<Teacher> lstTeacher) {
        this.context = context;
        this.lstTeacher = lstTeacher;
    }
    @Override
    public int getCount() {
        return lstTeacher.size();
    }

    @Override
    public Object getItem(int position) {
        return lstTeacher.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    TextView magv,tengv,luong,tuoi;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
        convertView = layoutInflater.inflate(R.layout.item_listview,parent,false);

        magv = convertView.findViewById(R.id.maGV);
        tengv = convertView.findViewById(R.id.tenGV);
        luong = convertView.findViewById(R.id.luong);
        tuoi = convertView.findViewById(R.id.tuoi);

        magv.setText("Mã GV: " + lstTeacher.get(position).getMagv());
        tengv.setText("Tên GV: " + lstTeacher.get(position).getHoten());
        luong.setText("Lương: " + String.valueOf(lstTeacher.get(position).getLuong()));
        tuoi.setText("Tuổi: " + String.valueOf(lstTeacher.get(position).getTuoi()));

        return convertView;
    }
}
