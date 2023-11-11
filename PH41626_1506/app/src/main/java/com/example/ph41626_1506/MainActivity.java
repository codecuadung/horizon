package com.example.ph41626_1506;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn_add;
    ListView listView;
    ArrayList<Teacher> lstTeacher = new ArrayList<>();

    EditText txt_magv,txt_ten,txt_luong,txt_tuoi;
    Button cancel,add;
    Service service = new Service();
    boolean cData = true;
    ListViewAdapter listViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        btn_add = findViewById(R.id.btn_add);
        lstTeacher = (ArrayList<Teacher>) service.readFile(MainActivity.this,"teacher.txt");
        lstTeacher.add(new Teacher("jfdk","dnvk",430958,3489));
        listViewAdapter = new ListViewAdapter(MainActivity.this,lstTeacher);
        listView.setAdapter(listViewAdapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                lstTeacher.remove(position);
                service.writeFile(MainActivity.this,lstTeacher,"teacher.txt");
                listViewAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Đã xóa!", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog);

                Window window = dialog.getWindow();
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);

                txt_magv = dialog.findViewById(R.id.txt_magv);
                txt_ten = dialog.findViewById(R.id.txt_ten);
                txt_luong = dialog.findViewById(R.id.txt_luong);
                txt_tuoi = dialog.findViewById(R.id.txt_tuoi);

                cancel = dialog.findViewById(R.id.cancel);
                add = dialog.findViewById(R.id.submit);


                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            String magv = txt_magv.getText().toString().trim();
                            String tengv = txt_ten.getText().toString().trim();
                            double luong = Double.parseDouble(txt_luong.getText().toString());
                            int tuoi = Integer.parseInt(txt_tuoi.getText().toString());
                            if(magv.isEmpty() || tengv.isEmpty() || luong < 0 || tuoi < 0) {
                                Toast.makeText(MainActivity.this, "Không được để trống thông tin!", Toast.LENGTH_SHORT).show();
                            } else {
                            lstTeacher.add(new Teacher(magv,tengv,luong,tuoi));
                            service.writeFile(MainActivity.this,lstTeacher,"teacher.txt");
                            listViewAdapter.notifyDataSetChanged();
                            dialog.dismiss();
                            }
                    }
                });
                dialog.show();
            }
        });
    }
}