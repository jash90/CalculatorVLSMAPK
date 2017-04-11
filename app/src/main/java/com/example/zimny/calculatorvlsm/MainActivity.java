package com.example.zimny.calculatorvlsm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    EditText et1,et2,et3,et4,et5,et6;
    TextView tv;
    ArrayList<Integer> hostow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        tv = (TextView) findViewById(R.id.Wynik);
        et1 = (EditText) findViewById(R.id.oktet1);
        et2 = (EditText) findViewById(R.id.oktet2);
        et3 = (EditText) findViewById(R.id.oktet3);
        et4 = (EditText) findViewById(R.id.oktet4);
        et5 = (EditText) findViewById(R.id.maska);
        et6 = (EditText) findViewById(R.id.iloscPodsieci);
        hostow = new ArrayList<>();
        RowAdapter adapter = new RowAdapter(this,R.layout.layout_item, hostow);
        listView.setAdapter(adapter);
    }

    public void Ustal(View view) {
        hostow.clear();
        int i = Integer.valueOf(et6.getText().toString());
        for (int x=0;x<i;x++)
        {
            hostow.add(0);
        }
    }

    public void Oblicz(View view) {
    }
}
