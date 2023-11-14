package com.example.proyectohpamina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ConceptosActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conceptos);

        // Crear una lista de objetos Mina
// Crear una lista de objetos InfoConceptos
        List<InfoConceptos> minas = new ArrayList<>();
        minas.add(new InfoConceptos(R.drawable.mina1, "¿Que es una Mina a Cielo Abierto?", "Una mina a cielo abierto es un tipo de explotación minera donde se extraen minerales o materiales valiosos " +
                "de la superficie de la Tierra. A diferencia de las minas subterráneas, las minas a " +
                "cielo abierto implican la eliminación de grandes cantidades de tierra y roca para acceder a los depósitos de minerales."));
        minas.add(new InfoConceptos(R.drawable.mina2, "Ventajas y desventajas de la minería a cielo abierto",
                "La minería a cielo abierto es rentable cuando el yacimiento no es muy profundo o cuando el terreno es arenoso o delicado, de modo que la minería subterránea no sea posible. Los costos de trabajo son menores, " +
                        "tanto en excavación como en transporte, y permiten utilizar maquinaria grande. No precisa de iluminación artificial y permite el uso de explosivos de cualquier tipo, sin olvidar que la seguridad y la higiene de los trabajadores es mucho mejor.\n\n" +
                        "Sin embargo, es cierto que tiene implicaciones medioambientales a considerar, que genera un fuerte impacto ambiental (estético, de ruido, polvo) en la zona y que el trabajo se realiza a la intemperie. La necesidad de trabajar una gran extensión " +
                        "de terreno es otra de las cuestiones a tener en cuenta."));
        minas.add(new InfoConceptos(R.drawable.mina4, "Tipos de minas a cielo abierto", "1-Canteras: Suelen ser pequeñas y los materiales que se explotan no necesitan un fuerte tratamiento posterior. De estas se extraen áridos, rocas industriales y ornamentales, " +
                "y se utilizan esquemas de bancos y bermas para su explotación.\n\n2-Descubiertas: Minas casi horizontales, a una cota constante.\n\n3-Cortas: Se suelen excavar con perforación y voladura en forma de cono invertido. Suelen ser de metales o carbón." +
                "\n\n4-Aluviones: Explotación de depósitos de arena para oro, piedras preciosas y otros elementos."));
        minas.add(new InfoConceptos(R.drawable.mina3, "Consecuencias de la minería a cielo abierto", "Una de las principales desventajas de este tipo de explotación minera es el impacto medioambiental que provoca. Dado que se utiliza cianuro, mercurio y ácido sulfúrico " +
                "para eliminar el estéril, se contaminan aguas subterráneas y el aire en forma de polvo tóxico. Esto es absorbido por animales y plantas.\n\nLa excavación en sí genera un impacto sonoro que ahuyenta a los animales de la zona, lo que provoca un cambio en el hábitat de muchas especies. " +
                "Además, se trabaja sobre una gran extensión de terreno que queda desfigurada por la acción mecánica. Esto disminuye el atractivo estético y el turismo de la zona, y perturba a las comunidades."));
        minas.add(new InfoConceptos(R.drawable.mina5, "Minería a cielo abierto en Panamá", "Panamá ha sido escenario de debates y controversias en relación con la minería a cielo abierto. Uno de los proyectos más notorios fue el proyecto minero Petaquilla, ubicado en la provincia de Colón. " +
                "Aunque no es un proyecto a cielo abierto puro, ya que implica una combinación de minería a cielo abierto y subterránea, ha suscitado preocupaciones ambientales y sociales."));


        ConceptosAdapter minaAdapter = new ConceptosAdapter(this, minas);

        // Configurar el adaptador en tu ListView.
        ListView listView = findViewById(R.id.listViewMinas);
        listView.setAdapter(minaAdapter);
    }
}
