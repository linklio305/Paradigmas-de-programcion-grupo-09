/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contenido;


import java.util.Random;

/**
 *
 * @author jarg
 */
public class QuestionGenerator {

    private String level;

    public QuestionGenerator(String level) {
        this.level = level;
    }

    String[][][] easyQuestions = {
        {
            {"The nave was broke, what material is the best for fix it?"},
            {"plastic", "iron", "stone"},
            {"iron"}
        },
        {
            {"Se averio el tablero de mando ¿cuantos tornillos necesito si tiene 5 x 7 perforaciones?"},
            {"4", "25", "35"},
            {"35"}
        },
        {
            {"Los ingenieros no se entienden para arreglar la fuente de poder ¿que significa gear?"},
            {"tornillo", "engranaje", "piston"},
            {"engranaje"}
        },
        {
            {"Se escapo mucho aire ¿que reserva deberíamos utilizar?"},
            {"helio", "oxigeno", "carbon"},
            {"oxigeno"}
        },
        {
            {"Han destruido el aislante termico de comunicaciones ¿cuanto necesitamos si es un triangulo de 15 de base y 25 de altura?"},
            {"133.4", "187.5", "193.2"},
            {"187.5"}
        }
    };

    String[][][] mediumQuestions = {
        {
            {"Se requiere un barra de metal lo suficientemente grande para resanar el lado mas largo de un triangulo rectandulo de 10 y 15 unidades de largo"},
            {"18.0", "11.5", "17.3"},
            {"18.0"}
        },
        {
            {"tanque de cobustible en fuga, cuanto debemos recuperar si se perdio 1/3 del tanque de 10m cubicos"},
            {"5m3", "3.33m3", "9.2m3"},
            {"3.33m3"}
        },
        {
            {"Which of the available metals is the lightest to repair?"},
            {"0.2A", "0.3A", "0.5A"},
            {"0,5A"}
        },
        {
            {"which tool is used to seal the steel?"},
            {"titanium", "platinum", "gold"},
            {"gold"}
        },
        {
            {"Perdida de provisiones, cuanta masa podemos generar con un liquido de 2.42 kilogramos por metro cubico y un volumen de 21 metros cubicos?"},
            {"51kg", "12Kg", "45Kg"},
            {"51kg"}
        }
    };

    String[][][] hardQuestions = {
        {
            {"Penetraron la nave, necesitamos un parche de hierro que tenga el radio necesario para cubrir un area de 33.33 unidades"},
            {"3.25", "4.25", "3.33"},
            {"3.25"}
        },
        {
            {"cables de comunicacion rotos, de cada 10 bytes llegan 2 bytes cuantos kB necesitamos enviar si se requiere 1MB"},
            {"5000kB", "15000kB", "3000kB"},
            {"5000kB"}
        },
        {
            {"electricidad averiada, cuanta intesidad energetica se requiere para alcanzar una potencia de 60w si tenemos 120V?"},
            {"0.2A", "0.3A", "0.5A"},
            {"0,5A"}
        },
        {
            {"which tool is used to seal the steel?"},
            {"blowtorch", "hammer", "welder"},
            {"welder"}
        },
        {
            {"Perdida de provisiones, cuanta masa podemos generar con un liquido de 2.42 kilogramos por metro cubico y un volumen de 21 metros cubicos?"},
            {"51kg", "12Kg", "45Kg"},
            {"51kg"}
        }
    };

    Random random = new Random();

    public String[][] buildQuestion() {
        int randomNum = random.nextInt(5);
  
        switch (this.level){
            case "easy":
                return(easyQuestions[randomNum]);
            case "medium":
                return (mediumQuestions[randomNum]);
            case "hard":
                return (hardQuestions[randomNum]);
        }
        return null;
    };
    
}
