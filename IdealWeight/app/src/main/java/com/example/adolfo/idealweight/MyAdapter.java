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

public class MyAdapter extends ArrayAdapter<String> {

    String[] titulo;
    String[] description;
    int[] imagenes;
    Context mContext;

    public MyAdapter(Context context, String[] NameNiveles, String[] description, int[] imagenesNiveles) {
        super(context, R.layout.list_adapter);
        this.titulo = NameNiveles;
        this.description = description;
        this.imagenes = imagenesNiveles;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return titulo.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if(convertView==null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.list_adapter, parent, false);
            mViewHolder.mImagenes = (ImageView) convertView.findViewById(R.id.list_imagen);
            mViewHolder.mTitulos = (TextView) convertView.findViewById(R.id.list_title);
            mViewHolder.mDescription = (TextView) convertView.findViewById(R.id.list_description);
            convertView.setTag(mViewHolder);
        }
        else{
            mViewHolder = (ViewHolder)convertView.getTag();

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
