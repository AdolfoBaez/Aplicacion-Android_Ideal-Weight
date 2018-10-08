package com.example.adolfo.idealweight;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
public class AdapterDesayuno1 extends ArrayAdapter<String> {

    String[] titulo;
    String[] description;
    int[] imagenes;
    Context mContext;

    public AdapterDesayuno1(Context context, String[] AlimentosDesayuno, String[] description, int[] imagenesDesayunos) {
        super(context, R.layout.adapter_desayuno1);
        this.titulo = AlimentosDesayuno;
        this.description = description;
        this.imagenes = imagenesDesayunos;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return titulo.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        AdapterDesayuno1.ViewHolder mViewHolder = new AdapterDesayuno1.ViewHolder();
        if(convertView==null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.adapter_desayuno1, parent, false);
            mViewHolder.mImagenes = (ImageView) convertView.findViewById(R.id.imagen_d1);
            mViewHolder.mTitulos = (TextView) convertView.findViewById(R.id.title_d1);
            mViewHolder.mDescription = (TextView) convertView.findViewById(R.id.description_d1);
            convertView.setTag(mViewHolder);
        }
        else{
            mViewHolder = (AdapterDesayuno1.ViewHolder)convertView.getTag();

        }

        mViewHolder.mImagenes.setImageResource(imagenes[position]);
        mViewHolder.mTitulos.setText(titulo[position]);
        mViewHolder.mDescription.setText(description[position]);

        return convertView;
    }

    static class ViewHolder{
        ImageView mImagenes;
        TextView mTitulos;
        TextView mDescription;

    }



}
