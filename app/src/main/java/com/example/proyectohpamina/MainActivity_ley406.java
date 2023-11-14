package com.example.proyectohpamina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_ley406 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ley406);

        List<InfoConceptos> minas = new ArrayList<>();
        minas.add(new InfoConceptos(R.drawable.ley1, "¿Qué es la ley 406 y cómo se llegó a esto?", "Esta normativa, sancionada el pasado 20 de octubre, y en tiempo récord según conocedores y juristas, " +
                "permite la continuidad de la explotación de cobre a cielo abierto a 120 kilómetros de la ciudad, en la" +
                "provincia deColón, en los bosques tropicales delCaribe panameño.\nLa explotación minera a cargo de First Quantum Minerals LTD, a través de su subsidiaria Minera Panamá, " +
                "S.A. estaba en juego a raíz del fallo de laCorte Suprema de Justicia, el máximo tribunal panameño que" +
                "declaró en 2017 la inconstitucionalidad del contrato ley original de 1997.\nLa actual administración gubernamental decidió renegociarlo, aumentar " +
                "sus regalías entre 2% hasta el 16% y añadir cláusulas de asuntos ambientales y laborales que no" +
                "contemplaba previamente."));

        minas.add(new InfoConceptos(R.drawable.ley2, "¿Qué se negoció y qué está en juego?", "La negociación se inició desde septiembre de 2021 y culminó en diciembre de 2022, según anunció el " +
                "gobierno panameño, pero la empresa se negó a firmar el contrato en el tiempo propuesto por el gobierno lo " +
                "que generó amenazas de ambas partes, la paralización de operaciones ordenada por el Estado y la " +
                "gestión de arbitrajes internacionales con los que la compañía defendería su inversión declarada en US$10 " +
                "mil millones.\nFinalmente, y tras el acuerdo entre las partes, el Ejecutivo publicó el contrato en el portal Agora con el fin de que los " +
                "ciudadanos hicieran sus consultas en un proceso de consulta pública no vinculante, a pesar de la magnitud del proyecto."));

        minas.add(new InfoConceptos(R.drawable.ley3, "¿Qué decía el nuevo contrato?", "El nuevo documento cuya médula de reforma se basaba en el aporte al Estado o las regalías, " +
                "y en el que se pactó un aporte anual mínimo de US$375 millones, dondoles a la trasnacional canadiense más de 12 mil hectáreas de concesión.\nEntre sus puntos más polémicos se estableció que la empresa podía expropiar terrenos que requiriese para la explotación minera.\n" +
                "El contrato ley que le permite la operación de cobre de First Quantum Minerals, por 40 años."));

        minas.add(new InfoConceptos(R.drawable.ley4, "¿Por qué ha sido cuestionado este proyecto minero?", "El proyecto minero " +
                "Cobre Panamá a cargo de Minera Panamá, la subsidiaria de First Quantum Minerals, ha sido cuestionada por presentar un historial de 209 incumplimientos a " +
                "compromisos ambientales de mitigación en una zona protegida y que conforma elCorredor Biológico Mesoamericano, así como quejas de moradores por la contaminación a sus ríos"));

        minas.add(new InfoConceptos(R.drawable.ley5, "Lista de las 15 concesiones mineras vigentes", "La más antigua es una expedida originalmente en 1995, a favor de Zioro, S.A., para la exploración de oro y otros metales en 12 mil hectáreas repartidas en Sorá, El Cacao, Chiguirí Arriba, Chame, Capira y Penonomé.\n\n" +
                "En la lista también están las tres concesiones dadas a Minera Cerro Quema, S.A., para la extracción de oro y plata. Las tres, además, son para explotar en conjunto casi 15 mil hectáreas en Bajo de Güera, Llano de Piedra, Mogollón, Bayano, Altos de Güera, Flores, Macaracas, Las Tablas y Tonosí, en la provincia de Los Santos."));

        minas.add(new InfoConceptos(R.drawable.ley6, "Ley 407 del 3 de noviembre de 2023", "La Ley 407 marca un punto de inflexión en la política minera del país y nace como un símbolo de la voluntad del pueblo panameño de proteger su entorno natural y preservar la salud de su población. " +
                "La medida prohíbe de manera indefinida la concesión de permisos para la exploración, extracción, transporte y beneficio de minerales metálicos en todo el territorio nacional."));


        ConceptosAdapter minaAdapter = new ConceptosAdapter(this, minas);

        // Configurar el adaptador en tu ListView.
        ListView listView = findViewById(R.id.listViewMinas);
        listView.setAdapter(minaAdapter);
    }
}