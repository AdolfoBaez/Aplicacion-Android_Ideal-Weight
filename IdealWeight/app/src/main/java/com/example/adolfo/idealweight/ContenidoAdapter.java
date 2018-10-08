package com.example.adolfo.idealweight;
/**
 * Created by Adolfo on 22/09/2017.
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ContenidoAdapter extends ArrayAdapter<String> {

    String[] titulo;
    int[] imagenes;
    Context nContext;

    public ContenidoAdapter (Context context, String[] TipoAlimento, int[] imagenesAlimentos) {
        super(context, R.layout.contenido_adapter);
        this.titulo = TipoAlimento;
        this.imagenes = imagenesAlimentos;
        this.nContext = context;
    }

    @Override
    public int getCount() {
        return titulo.length;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder cViewHolder = new ViewHolder();
        if(convertView==null) {
            LayoutInflater mInflater = (LayoutInflater) nContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.contenido_adapter, parent, false);
            cViewHolder.mImagenes = (ImageView) convertView.findViewById(R.id.list_cimg);
            cViewHolder.mTitulos = (TextView) convertView.findViewById(R.id.list_titlec);
            convertView.setTag(cViewHolder);
        }
        else{
            cViewHolder = (ViewHolder)convertView.getTag();

        }

        cViewHolder.mImagenes.setImageResource(imagenes[position]);
        cViewHolder.mTitulos.setText(titulo[position]);

        return convertView;
    }

    static class ViewHolder{
        ImageView mImagenes;
        TextView mTitulos;

    }
}
