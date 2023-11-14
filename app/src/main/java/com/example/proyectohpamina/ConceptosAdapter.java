package com.example.proyectohpamina;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ConceptosAdapter extends ArrayAdapter<InfoConceptos> {
    public ConceptosAdapter(Context context, List<InfoConceptos> minas) {
        super(context, 0, minas);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.minaadapter, parent, false);
        }

        InfoConceptos currentMina = getItem(position);

        ImageView imageViewMina = convertView.findViewById(R.id.imageViewMina);
        TextView textViewTitulo = convertView.findViewById(R.id.textViewTitulo);
        TextView textViewTextoInformativo = convertView.findViewById(R.id.textViewTextoInformativo);

        if (currentMina != null) {
            imageViewMina.setImageResource(currentMina.getImagenResId());
            textViewTitulo.setText(currentMina.getTitulo());
            textViewTextoInformativo.setText(currentMina.getTextoInformativo());
            textViewTextoInformativo.setOnClickListener(v -> {
                currentMina.setMostrarTextoCompleto(!currentMina.isMostrarTextoCompleto());
                notifyDataSetChanged();
            });
        }

        return convertView;
    }
}
