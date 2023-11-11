package com.example.ph41626_1306;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button btnAdd;
    ListViewAdapter listViewAdapter;
    ArrayList<Client> lstClient = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
//        btnAdd = findViewById(R.id.btn_add);

        lstClient = (ArrayList<Client>) new Service().readFile(MainActivity.this, "client.txt");

       lstClient.add(new Client("KH001","Nguyễn Văn A", 18, "0943567834"));
       lstClient.add(new Client("KH002","Nguyễn Văn B", 18, "0943567834"));
       lstClient.add(new Client("KH003","Nguyễn Văn C", 18, "0943567834"));
       lstClient.add(new Client("KH004","Nguyễn Văn D", 18, "0943567834"));
       lstClient.add(new Client("KH005","Nguyễn Văn E", 18, "0943567834"));

        listViewAdapter = new ListViewAdapter(MainActivity.this, lstClient);
        listView.setAdapter(listViewAdapter);
    }
}