package com.example.zimny.calculatorvlsm;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    EditText et1,et2,et3,et4,et5,et6;
    TextView tv;
    ArrayList<Integer> hostow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout= (LinearLayout) findViewById(R.id.linearlayout);
        tv = (TextView) findViewById(R.id.Wynik);
        et1 = (EditText) findViewById(R.id.oktet1);
        et2 = (EditText) findViewById(R.id.oktet2);
        et3 = (EditText) findViewById(R.id.oktet3);
        et4 = (EditText) findViewById(R.id.oktet4);
        et5 = (EditText) findViewById(R.id.maska);
        et6 = (EditText) findViewById(R.id.iloscPodsieci);
        hostow = new ArrayList<>();

    }

    public void Ustal(View view) {
        try {
            int i = Integer.valueOf(et6.getText().toString());
            linearLayout.removeAllViews();
            for (int x = 0; x < i; x++) {
                EditText editText = new EditText(getApplicationContext());
                editText.setHint("Podsieć " + (x + 1));
                editText.setVisibility(View.VISIBLE);
                editText.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                linearLayout.addView(editText);
            }
            linearLayout.refreshDrawableState();
        }
        catch (Exception ex)
        {
            Toast.makeText(this,ex.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    public void Oblicz(View view) {
    }
}
