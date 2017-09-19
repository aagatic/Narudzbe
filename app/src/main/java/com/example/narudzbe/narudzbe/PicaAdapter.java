package com.example.narudzbe.narudzbe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class PicaAdapter extends BaseAdapter {

    private ArrayList<Pice> pica;

    public PicaAdapter(ArrayList<Pice> pica) {
        this.pica = pica;
    }
    @Override
    public int getCount() {
        return this.pica.size();
    }
    @Override
    public Object getItem(int position) {

        return this.pica.get(position);
    }
    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PicaAdapter.ViewHolder piceViewHolder;
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.item_pice, parent, false);
            piceViewHolder = new PicaAdapter.ViewHolder(convertView);
            convertView.setTag(piceViewHolder);
        }
        else{
            piceViewHolder = (PicaAdapter.ViewHolder) convertView.getTag();
        }
        Pice pice = this.pica.get(position);
        piceViewHolder.tvPicaStol.setText(pice.getNarudzba());
        piceViewHolder.tvPicaKategorija.setText(pice.getKategorija());
        piceViewHolder.tvPicaIme.setText(pice.getIme());
        piceViewHolder.tvPicaCijena.setText(pice.getCijena());
        return convertView;
    }

    public static class ViewHolder {
        public TextView tvPicaStol;
        public TextView tvPicaKategorija;
        public TextView tvPicaIme;
        public TextView tvPicaCijena;
        public ViewHolder(View picaView) {
            tvPicaStol = (TextView) picaView.findViewById(R.id.tvPicaStol);
            tvPicaKategorija = (TextView) picaView.findViewById(R.id.tvPicaKategorija);
            tvPicaIme = (TextView) picaView.findViewById(R.id.tvPicaIme);
            tvPicaCijena = (TextView) picaView.findViewById(R.id.tvPicaCijena);
        }
    }

    public void add(Pice pice) {
        this.pica.add(pice);
        this.notifyDataSetChanged();
    }
    public void deleteAt(int position) {
        this.pica.remove(position);
        this.notifyDataSetChanged();
    }
}
