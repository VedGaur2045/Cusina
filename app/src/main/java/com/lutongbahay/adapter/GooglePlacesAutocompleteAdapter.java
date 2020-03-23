package com.lutongbahay.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.lutongbahay.R;
import com.lutongbahay.rest.response.google_places_response.GooglePlacesAPIData;
import com.lutongbahay.rest.response.google_places_response.Predictions;
import com.lutongbahay.rest.service.GooglePlacesServices;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GooglePlacesAutocompleteAdapter extends BaseAdapter {
    private Context context = null;
    private List<Predictions> predictionsList;

    public GooglePlacesAutocompleteAdapter(Context context, List<Predictions> predictionsList) {
        this.context = context;
        this.predictionsList = predictionsList;
    }

    @Override
    public int getCount() {
        return predictionsList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.adapter_search_location_list_item, parent, false);
            viewHolder.city_name = convertView.findViewById(R.id.list_item);
            viewHolder.city_name.setText(predictionsList.get(position).description);
        }
        return convertView;
    }

    public class ViewHolder{
        public TextView city_name;
    }
}