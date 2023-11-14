package com.example.proyectohpamina;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.biometric.BiometricPrompt;

import android.content.Context;
import android.hardware.biometrics.BiometricManager;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.TextView;
import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity {
    private Button loginButton;
    private TextView msgTextView;
    private BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;
    private String authenticationMessage = "Para ingresar, debe utilizar biometría";


    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = findViewById(R.id.loginButton);
        msgTextView = findViewById(R.id.textView2);

        // Inicializa BiometricPrompt y PromptInfo
        initializeBiometricPrompt();

        // Configura el onClickListener para el botón de login
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Muestra el diálogo de autenticación biométrica
                biometricPrompt.authenticate(promptInfo);
            }
        });
    }

    // Inicializa BiometricPrompt y PromptInfo
    private void initializeBiometricPrompt() {
        Executor executor = ContextCompat.getMainExecutor(this);

        biometricPrompt = new BiometricPrompt(this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                if (errorCode == BiometricPrompt.ERROR_NEGATIVE_BUTTON) {
                    // El usuario ha cancelado la autenticación, muestra el mensaje deseado.
                    msgTextView.setText(authenticationMessage);
                } else {
                    msgTextView.setText(errString);
                }
            }

            @Override
            public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                msgTextView.setText("Para ingresar, debe utilizar biometría");
                // Autenticación exitosa, envía al usuario a la clase MenuCards
                Intent intent = new Intent(MainActivity.this, MenuCards.class);
                startActivity(intent);
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                msgTextView.setText("Para ingresar, debe utilizar biometría");
            }
        });

        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Para ingresar, debe utilizar biometría")
                .setSubtitle("")
                .setNegativeButtonText("Cancelar")
                .build();
    }
}
