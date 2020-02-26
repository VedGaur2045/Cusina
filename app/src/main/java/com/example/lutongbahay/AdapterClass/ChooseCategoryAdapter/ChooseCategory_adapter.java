package com.example.lutongbahay.AdapterClass.ChooseCategoryAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lutongbahay.R;

import java.util.ArrayList;


public class ChooseCategory_adapter extends BaseAdapter {

    ArrayList<ChooseCategory_datamodel> model;
    Context context;
    String  url;

    public ChooseCategory_adapter(ArrayList<ChooseCategory_datamodel> model, Context context) {
        this.model = model;
        this.context = context;
    }



    @Override
    public int getCount() {
        return model.size();
    }

    @Override
    public Object getItem(int position) {
        return model.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        convertView= LayoutInflater.from(context).inflate(R.layout.category_list,parent,false);

        final viewholder holder=new viewholder();

        holder.name=convertView.findViewById(R.id.categoryname);
        holder.name.setText(model.get(position).getName());


        return  convertView;

    }
    public class viewholder
    {
        TextView name;
        ImageView icon,download;

    }


}
