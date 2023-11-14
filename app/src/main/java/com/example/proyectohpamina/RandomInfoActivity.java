// RandomInfoActivity.java
package com.example.proyectohpamina;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Random;

public class RandomInfoActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometer;
    private long lastUpdate;
    private float lastX, lastY, lastZ;
    private static final int SHAKE_THRESHOLD = 2700;

    private CardView cardViewRandomInfo;
    private TextView textViewRandomInfo;
    private ImageView imageViewRandomInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_info);

        cardViewRandomInfo = findViewById(R.id.cardViewRandomInfo);
        textViewRandomInfo = findViewById(R.id.textViewRandomInfo);
        imageViewRandomInfo = findViewById(R.id.imageViewRandomInfo);

        // Configurar el sensor de acelerómetro
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager != null) {
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            if (accelerometer != null) {
                sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
                lastUpdate = System.currentTimeMillis();
            } else {
                // El dispositivo no tiene acelerómetro
                Toast.makeText(this, "El dispositivo no tiene acelerómetro", Toast.LENGTH_SHORT).show();
            }
        }

        // Mostrar información inicial
        mostrarInformacionAleatoria();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            long currentTime = System.currentTimeMillis();
            if ((currentTime - lastUpdate) > 100) {
                long timeDiff = currentTime - lastUpdate;
                lastUpdate = currentTime;

                float x = event.values[0];
                float y = event.values[1];
                float z = event.values[2];

                float speed = Math.abs(x + y + z - lastX - lastY - lastZ) / timeDiff * 10000;

                if (speed > SHAKE_THRESHOLD) {
                    cambiarInformacion();
                }

                lastX = x;
                lastY = y;
                lastZ = z;
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }


    private void mostrarInformacionAleatoria() {
        // Obtener y mostrar información aleatoria sobre minería a cielo abierto
        String sabeQue = SabeQueManager.obtenerSabeQueAleatorio();
        textViewRandomInfo.setText(sabeQue);

        // Seleccionar una imagen aleatoria
        int[] imagenes = {R.drawable.sque1, R.drawable.sque2, R.drawable.sque3, R.drawable.sque4, R.drawable.sque5, R.drawable.sque6,
                R.drawable.sque8, R.drawable.sque9, R.drawable.sque10, R.drawable.sque11};
        int indiceImagenAleatoria = new Random().nextInt(imagenes.length);
        imageViewRandomInfo.setImageResource(imagenes[indiceImagenAleatoria]);
    }


    private void cambiarInformacion() {
        Toast.makeText(this, "Movimiento Detectado", Toast.LENGTH_SHORT).show();
        mostrarInformacionAleatoria();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Se detiene el sensor de acelerómetro
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
    }
}
