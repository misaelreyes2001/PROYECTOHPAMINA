package com.example.proyectohpamina;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseManager extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "comentarios.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_RESENAS = "resenas";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NOMBRE = "nombre";
    public static final String COLUMN_TEXTO = "texto";

    // Constructor
    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Método llamado cuando se crea la base de datos por primera vez
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_RESENAS + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NOMBRE + " TEXT, " +
                COLUMN_TEXTO + " TEXT)";
        db.execSQL(createTableQuery);
    }

    // Método llamado cuando se actualiza la versión de la base de datos
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESENAS);
        onCreate(db);
    }

    // Método para insertar una reseña en la base de datos
    public void insertResena(String nombre, String texto) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOMBRE, nombre);
        values.put(COLUMN_TEXTO, texto);
        db.insert(TABLE_RESENAS, null, values);
        db.close();
    }

    // Método para obtener todas las reseñas de la base de datos
    public Cursor getResenas() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_ID, COLUMN_NOMBRE, COLUMN_TEXTO};
        return db.query(TABLE_RESENAS, columns, null, null, null, null, null);
    }

    // Método para eliminar una reseña por su ID
    public void eliminarResena(int position) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = getResenas();
        cursor.moveToPosition(position);
        @SuppressLint("Range") long id = cursor.getLong(cursor.getColumnIndex(COLUMN_ID));
        db.delete(TABLE_RESENAS, COLUMN_ID + "=?", new String[]{String.valueOf(id)});
        db.close();
    }
    public void actualizarResena(long id, String nombre, String texto) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOMBRE, nombre);
        values.put(COLUMN_TEXTO, texto);
        db.update(TABLE_RESENAS, values, COLUMN_ID + "=?", new String[]{String.valueOf(id)});
        db.close();
    }
    @SuppressLint("Range")
    public Resena getResena(long idResena) {
        SQLiteDatabase db = getReadableDatabase();
        Resena resena = null;

        // Realiza la consulta del registro correspondiente al ID
        String query = "SELECT * FROM " + TABLE_RESENAS + " WHERE " + COLUMN_ID + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(idResena)});

        // Verifica si se obtuvieron resultados
        if (cursor != null && cursor.moveToFirst()) {
            // Construye el objeto Resena desde los datos del cursor
            resena = new Resena(
                    cursor.getLong(cursor.getColumnIndex(COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_NOMBRE)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_TEXTO))
            );

            // Cierra el cursor
            cursor.close();
        }

        // Cierra la base de datos
        db.close();

        return resena;
    }


}
