package com.example.narudzbe.narudzbe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;



public class NarudzbaAdapter extends BaseAdapter {

    private ArrayList<Narudzba> narudzbe;

    public NarudzbaAdapter(ArrayList<Narudzba> narudzbe) {
        this.narudzbe = narudzbe;
    }
    @Override
    public int getCount() {
        return this.narudzbe.size();
    }
    @Override
    public Object getItem(int position) {
        return this.narudzbe.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder narudzbaViewHolder;
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.item_narudzba, parent, false);
            narudzbaViewHolder = new ViewHolder(convertView);
            convertView.setTag(narudzbaViewHolder);
        }
        else{
            narudzbaViewHolder = (ViewHolder) convertView.getTag();
        }
        Narudzba narudzba = this.narudzbe.get(position);
        narudzbaViewHolder.tvNarudzbaStol.setText(narudzba.getStol());
        return convertView;
    }

    public static class ViewHolder {
        public TextView tvNarudzbaStol;
        public ViewHolder(View narudzbaView) {
            tvNarudzbaStol = (TextView) narudzbaView.findViewById(R.id.tvNarudzbaStol);
        }
    }

    public void add(Narudzba narudzba) {
        this.narudzbe.add(narudzba);
        this.notifyDataSetChanged();
    }
    public void deleteAt(int position) {
        this.narudzbe.remove(position);
        this.notifyDataSetChanged();
    }
}
