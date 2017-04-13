package com.example.zimny.calculatorvlsm;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ZimnY on 11.04.2017.
 */

public class RowAdapter extends ArrayAdapter<Integer> {

    Context context;
    int layoutResourceId;
    ArrayList<Integer> data = null;

    public RowAdapter(Context context, int layoutResourceId, ArrayList<Integer> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Integer i  = data.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_item, null);

        EditText iloscHostow = (EditText) view.findViewById(R.id.iloscHostow);
        TextView numerPodsieci = (TextView)view.findViewById(R.id.numerPodsieci);


        numerPodsieci.setText("Podsieć "+(position+1)+" : ");


        return view;
    }


}
