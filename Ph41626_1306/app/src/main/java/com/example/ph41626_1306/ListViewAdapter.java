package com.example.ph41626_1306;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    Context context;
    ArrayList<Client> lstClient;

    public ListViewAdapter(Context context, ArrayList<Client> lstClient) {
        this.context = context;
        this.lstClient = lstClient;
    }

    @Override
    public int getCount() {
        return lstClient.size();
    }

    @Override
    public Object getItem(int position) {
        return lstClient.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    TextView maKH,tenKH,sdt,tuoi;
    Button btnEdit,btnDelete;
    EditText txt_makh,txt_ten,txt_tuoi,txt_sdt;
    Button cancel,submit;
    Service service = new Service();
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
        convertView = layoutInflater.inflate(R.layout.item_listview,parent,false);

        maKH = convertView.findViewById(R.id.maKH);
        tenKH = convertView.findViewById(R.id.tenKH);
        tuoi = convertView.findViewById(R.id.tuoi);
        sdt = convertView.findViewById(R.id.sdt);
        btnEdit = convertView.findViewById(R.id.edit);
        btnDelete = convertView.findViewById(R.id.delete);

        maKH.setText("Mã KH: " + lstClient.get(position).getMaKH());
        tenKH.setText("Tên KH: " + lstClient.get(position).getTenKH());
        tuoi.setText("Tuổi: " + String.valueOf(lstClient.get(position).getTuoi()));
        sdt.setText("SDT: " + lstClient.get(position).getSdt());

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lstClient.remove(position);
                service.writeFile(context,lstClient,"client.txt");
                notifyDataSetChanged();
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog);

                Window window = dialog.getWindow();
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);

                txt_makh = dialog.findViewById(R.id.txt_makh);
                txt_ten = dialog.findViewById(R.id.txt_ten);
                txt_tuoi = dialog.findViewById(R.id.txt_tuoi);
                txt_sdt = dialog.findViewById(R.id.txt_sdt);

                cancel = dialog.findViewById(R.id.cancel);
                submit = dialog.findViewById(R.id.submit);

                txt_makh.setText(lstClient.get(position).getMaKH());
                txt_ten.setText(lstClient.get(position).getTenKH());
                txt_tuoi.setText(String.valueOf(lstClient.get(position).getTuoi()));
                txt_sdt.setText(lstClient.get(position).getSdt());

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String maKH = txt_makh.getText().toString();
                        String tenKH = txt_ten.getText().toString();
                        int tuoi = Integer.parseInt(txt_tuoi.getText().toString());
                        String sdt = txt_sdt.getText().toString();

                        if(maKH.isEmpty() || tenKH.isEmpty() || tuoi <= 0 || sdt.isEmpty()) {
                            Toast.makeText(context, "Không được để trống thông tin.", Toast.LENGTH_SHORT).show();
                        } else {
                            lstClient.get(position).setMaKH(maKH);
                            lstClient.get(position).setTenKH(tenKH);
                            lstClient.get(position).setTuoi(tuoi);
                            lstClient.get(position).setSdt(sdt);
                            service.writeFile(context,lstClient,"client.txt");
                            notifyDataSetChanged();
                        }
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        return convertView;
    }
}
