package com.example.project311;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Date;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    public List<Record> records;
    List<String>names = new ArrayList<String>();
    List<Double>prices = new ArrayList<Double>();
    List<Integer>ids = new ArrayList<Integer>();
    List<String>Merchant_Names = new ArrayList<String>();
    List<Date>dates = new ArrayList<Date>();

    public ItemAdapter(Context c, List<Record> r)
    {
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.records = r;
        for(Record record: r ){
            names.add(record.getCategory());
            prices.add(record.getAmount());
            ids.add(record.getId());
            dates.add(record.getMyDate());
            Merchant_Names.add(record.getMerchant_Name());
        }
    }

    @Override
    public int getCount() {
        return records.size();
    }

    @Override
    public Object getItem(int position) {
        return names.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = mInflater.inflate(R.layout.item_layout, null);
        TextView nameTextView = (TextView) v.findViewById(R.id.nameTextView);
        TextView priceTextView = (TextView) v.findViewById(R.id.priceTextView);
        TextView idTextView = (TextView) v.findViewById(R.id.idTextView);
        TextView M_NameTextView = (TextView) v.findViewById(R.id.M_NameTextView);
        TextView dateTextView = (TextView) v.findViewById(R.id.dateTextView);

        String name = names.get(position);
        String cost = "$" + prices.get(position).toString();
        String date = dates.get(position).toString();
        String mName = Merchant_Names.get(position);
        String id = ids.get(position).toString();


        nameTextView.setText(name);
        priceTextView.setText(cost);
        idTextView.setText(id);
        M_NameTextView.setText(mName);
        dateTextView.setText(date);

        return v;
    }
}
