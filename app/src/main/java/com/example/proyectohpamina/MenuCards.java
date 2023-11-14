package com.example.proyectohpamina;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuCards extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_cards);

        CardView randomInfoCard = findViewById(R.id.randominfoCard);
        CardView conceptosCard = findViewById(R.id.conceptosCard);
        CardView comentariosCard = findViewById(R.id.comentariosCard);
        CardView leyesCard = findViewById(R.id.leyesCard);

        conceptosCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuCards.this, ConceptosActivity.class);
                startActivity(intent);
            }
        });
        leyesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuCards.this, MainActivity_ley406.class);
                startActivity(intent);
            }
        });
        comentariosCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuCards.this, Comentarios.class);
                startActivity(intent);
            }
        });
        randomInfoCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuCards.this, RandomInfoActivity.class);
                startActivity(intent);
            }
        });
    }
}
