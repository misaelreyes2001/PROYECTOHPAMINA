package com.example.proyectohpamina;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Agregar_Resena extends AppCompatActivity {
    private EditText editTextNombre;
    private EditText editTextTexto;
    private DatabaseManager databaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_resena);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextTexto = findViewById(R.id.editTextResena);
        Button btnEnviar = findViewById(R.id.btnEnviarResena);

        databaseManager = new DatabaseManager(this);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("idResena")) {
            long idResena = intent.getLongExtra("idResena", -1);
            if (idResena != -1) {
                // Obtener la reseña por su ID
                Resena resena = databaseManager.getResena(idResena);

                // Mostrar los datos en el diseño
                editTextNombre.setText(resena.getNombre());
                editTextTexto.setText(resena.getTexto());
            }
        }

        btnEnviar.setOnClickListener(v -> {
            String nombre = editTextNombre.getText().toString();
            String texto = editTextTexto.getText().toString();

            // Validar que se haya ingresado un nombre y un texto
            if (!nombre.isEmpty() && !texto.isEmpty()) {
                // Si hay un ID, actualiza la reseña; de lo contrario, inserta una nueva
                if (intent != null && intent.hasExtra("idResena")) {
                    long idResena = intent.getLongExtra("idResena", -1);
                    if (idResena != -1) {
                        // Actualizar la reseña en la base de datos
                        databaseManager.actualizarResena(idResena, nombre, texto);
                        Toast.makeText(this, "Reseña actualizada Correctamente", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Insertar una nueva reseña en la base de datos
                    databaseManager.insertResena(nombre, texto);
                }

                // Limpiar los campos después de enviar la reseña
                editTextNombre.setText("");
                editTextTexto.setText("");
                Toast.makeText(this, "Reseña agregada correctamente", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(Agregar_Resena.this, Comentarios.class);
                startActivity(intent1);
            } else {
                Toast.makeText(this, "Ingresa un nombre y un texto", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
