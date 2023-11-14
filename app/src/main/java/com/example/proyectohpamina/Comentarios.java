package com.example.proyectohpamina;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Comentarios extends AppCompatActivity {

    private ListView listViewComentarios;
    private ComentariosAdapter comentariosAdapter;
    private DatabaseManager databaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentarios);

        listViewComentarios = findViewById(R.id.listViewComentarios);
        databaseManager = new DatabaseManager(this);

        // Configurar el adaptador con datos de la base de datos
        comentariosAdapter = new ComentariosAdapter(this, databaseManager.getResenas());
        listViewComentarios.setAdapter(comentariosAdapter);

        // Agregar el listener para clics en los elementos del ListView
        listViewComentarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mostrarOpcionesDialog(position);
            }
        });

        Button btnAgregarResena = findViewById(R.id.btnAgregarResena);
        btnAgregarResena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad para agregar reseña
                Intent intent = new Intent(Comentarios.this, Agregar_Resena.class);
                startActivity(intent);
            }
        });

        Button btnRegresar = findViewById(R.id.btnregresar);
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Comentarios.this, MenuCards.class);
                startActivity(intent);
            }
        });
    }

    private void mostrarOpcionesDialog(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Opciones de reseña");
        builder.setItems(new CharSequence[]{"Editar Reseña", "Eliminar Reseña"}, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        // Editar reseña
                        editarResena(position);
                        break;
                    case 1:
                        // Eliminar reseña
                        eliminarResena(position);
                        break;
                }
            }
        });
        builder.create().show();
    }

    private void editarResena(int position) {
        // Obten el identificador único de la reseña seleccionada
        long idResena = comentariosAdapter.getItemId(position);

        // Iniciar la actividad para agregar/editar reseña con el identificador
        Intent intent = new Intent(Comentarios.this, Agregar_Resena.class);
        intent.putExtra("idResena", idResena);
        startActivity(intent);
    }


    private void eliminarResena(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Eliminar reseña");
        builder.setMessage("¿Estás seguro de que deseas eliminar esta reseña?");
        builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Implementa la lógica para eliminar la reseña aquí
                databaseManager.eliminarResena(position);
                // Actualiza el adaptador
                comentariosAdapter.swapCursor(databaseManager.getResenas());
                Toast.makeText(Comentarios.this, "Reseña eliminada correctamente", Toast.LENGTH_SHORT).show();
            }
        }).setNegativeButton("No", null);
        builder.create().show();
    }
}
