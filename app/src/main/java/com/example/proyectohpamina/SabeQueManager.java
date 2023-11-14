// SabeQueManager.java
package com.example.proyectohpamina;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SabeQueManager {

    private static final List<String> sabeQueList = new ArrayList<>();

    static {
        // Sabías que sobre minería en general
        sabeQueList.add("La minería es una actividad milenaria que ha sido fundamental para el desarrollo de sociedades humanas a lo largo de la historia.");
        sabeQueList.add("La minería aporta una variedad de minerales esenciales para la fabricación de productos cotidianos, como teléfonos móviles, automóviles y dispositivos electrónicos.");
        sabeQueList.add("La extracción de minerales puede realizarse de diversas formas, incluyendo la minería a cielo abierto, subterránea y la minería de placer.");
        sabeQueList.add("Algunos minerales, como el oro y el diamante, han desempeñado un papel importante en la economía y han sido objeto de fiebres del oro en diversas partes del mundo.");

        // Sabías que sobre minería en Panamá
        sabeQueList.add("Panamá cuenta con yacimientos de minerales como el cobre y el oro, que son explotados a través de la minería a cielo abierto.");
        sabeQueList.add("La minería en Panamá ha generado debates intensos entre el impulso económico y la preservación del medio ambiente, especialmente en áreas ricas en biodiversidad.");
        sabeQueList.add("El proyecto minero de Cerro Colorado en Panamá ha sido uno de los más grandes en la región, enfrentando críticas y desafíos ambientales.");
        sabeQueList.add("En Panamá, la minería ha sido un tema controvertido debido a preocupaciones sobre la contaminación del agua y la afectación de ecosistemas sensibles.");

        // Más Sabías que generales
        sabeQueList.add("La minería a cielo abierto puede tener impactos negativos en la salud humana debido a la liberación de sustancias tóxicas en el aire y el agua.");
        sabeQueList.add("La rehabilitación de áreas mineras afectadas es un desafío importante para mitigar los impactos a largo plazo de la minería a cielo abierto.");
        sabeQueList.add("La minería ilegal es un problema global que contribuye a la deforestación, degradación ambiental y violaciones de derechos humanos.");
        sabeQueList.add("La extracción de minerales a menudo está asociada con conflictos sociales y territoriales, especialmente en regiones ricas en recursos naturales.");
        sabeQueList.add("La innovación tecnológica está desempeñando un papel importante en la reducción de los impactos ambientales de la minería a través de prácticas más sostenibles.");

        // Sabías que adicionales
        sabeQueList.add("La minería submarina es una tendencia emergente que busca extraer minerales del lecho marino, pero plantea preocupaciones sobre los ecosistemas marinos.");
        sabeQueList.add("La industria minera enfrenta desafíos significativos en términos de responsabilidad social corporativa y la adopción de prácticas sostenibles.");
        sabeQueList.add("La demanda global de minerales está aumentando con el crecimiento de la población y el desarrollo económico, lo que destaca la importancia de abordar los desafíos ambientales y sociales asociados.");
        sabeQueList.add("La minería artesanal y de pequeña escala es una fuente importante de empleo en muchos países, pero a menudo enfrenta dificultades en términos de seguridad y condiciones de trabajo.");
        sabeQueList.add("La diversificación de la economía en regiones dependientes de la minería es un objetivo clave para reducir la vulnerabilidad económica y ambiental.");


    }


    public static String obtenerSabeQueAleatorio() {
        // Obtén un "Sabías que" aleatorio de la lista
        Random random = new Random();
        int index = random.nextInt(sabeQueList.size());
        return sabeQueList.get(index);
    }
}
