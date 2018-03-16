package com.example.binhnl.datn_ggmap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        SqlController s = new SqlController(this);
        boolean c = s.insert("test", "abc");


//        Cursor cu = s.getSetting("test");
        List<String> listString = s.selectData("test", SqlController.SETTING, 2);
        for (int i = 0; i < listString.size(); i++) {
            Log.d("BinhLN: " + i, listString.get(i));
        }
        //roller(this);
    }
}
