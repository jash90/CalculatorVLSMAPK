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
        View row = convertView;
        RowBeanHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new RowBeanHolder();
            holder.iloscHostow = (EditText) row.findViewById(R.id.iloscHostow);
            holder.numerPodsieci = (TextView)row.findViewById(R.id.numerPodsieci);

            row.setTag(holder);
        }
        else
        {
            holder = (RowBeanHolder)row.getTag();
        }
        Integer i  = data.get(position);
        holder.numerPodsieci.setText("Podsieć "+(position+1)+" : ");


        return row;
    }

    static class RowBeanHolder
    {
        TextView numerPodsieci;
        EditText iloscHostow;
    }
}
