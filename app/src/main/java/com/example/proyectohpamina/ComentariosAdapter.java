package com.example.proyectohpamina;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class ComentariosAdapter extends CursorAdapter {

    public ComentariosAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.comentarioadapter, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView textViewNombre = view.findViewById(R.id.textViewNombre);
        TextView textViewTexto = view.findViewById(R.id.textViewTexto);

        @SuppressLint("Range") String nombre = cursor.getString(cursor.getColumnIndex(DatabaseManager.COLUMN_NOMBRE));
        @SuppressLint("Range") String texto = cursor.getString(cursor.getColumnIndex(DatabaseManager.COLUMN_TEXTO));

        textViewNombre.setText(nombre);
        textViewTexto.setText(texto);
    }
    @SuppressLint("Range")
    @Override
    public long getItemId(int position) {
        // Devuelve el ID asociado con la posición del elemento en el cursor
        Cursor cursor = getCursor();
        cursor.moveToPosition(position);
        return cursor.getLong(cursor.getColumnIndex(DatabaseManager.COLUMN_ID));
    }
}