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

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

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
            linearLayout.setVisibility(View.VISIBLE);
            tv.setText("");
            int i = Integer.valueOf(et6.getText().toString());
            linearLayout.removeAllViews();
            for (int x = 0; x < i; x++) {
                EditText editText = new EditText(getApplicationContext());
                editText.setHint("Podsieć " + (x + 1));
                editText.setVisibility(View.VISIBLE);
                editText.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                linearLayout.addView(editText);
            }
            linearLayout.refreshDrawableState();
        }
        catch (Exception ex)
        {
            Toast.makeText(getApplicationContext(), ex.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void Oblicz(View view) {
        try {
            String s = IpToString(et1, et2, et3, et4, et5);
            ArrayList<Integer> ip = Api.validacjaIP(s);
            ArrayList<Integer> podsieci = getPodsieci(linearLayout);
            Collections.sort(podsieci, Collections.<Integer>reverseOrder());
            if (podsieci.size()>0)
            tv.setText(Api.kalkulacja(ip,podsieci));
            linearLayout.setVisibility(View.GONE);
        }
        catch (Exception ex)
        {
            Toast.makeText(getApplicationContext(), ex.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }

    }
    public String IpToString(EditText et1, EditText et2, EditText et3, EditText et4, EditText et5) {
        try {
            return String.valueOf(Integer.valueOf(et1.getText().toString()) + "." + Integer.valueOf(et2.getText().toString()) + "." + Integer.valueOf(et3.getText().toString()) + "." + Integer.valueOf(et4.getText().toString()) + "/" + Integer.valueOf(et5.getText().toString()));
        }
        catch (Exception ex)
        {
            Toast.makeText(getApplicationContext(), ex.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            return null;
        }
    }
    public ArrayList<Integer> getPodsieci(LinearLayout linearLayout) {
        try {
            ArrayList<Integer> podsieci = new ArrayList<>();
            final int childcount = linearLayout.getChildCount();
            for (int i = 0; i < childcount; i++) {
                View v = linearLayout.getChildAt(i);
                if (v instanceof EditText) {
                    EditText e = (EditText) v;
                    if (!e.getText().toString().isEmpty())
                        podsieci.add(Integer.valueOf(e.getText().toString()));
                }
            }
            return podsieci;
        }
        catch (Exception ex)
        {
            Toast.makeText(getApplicationContext(), ex.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            return null;
        }
    }
}
