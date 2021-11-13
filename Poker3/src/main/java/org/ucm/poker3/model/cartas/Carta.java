/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.ucm.poker3.model.cartas;

public class Carta {

    private int carta;
    private char palo;
    private boolean Jugador;

    public Carta(int carta, char palo, boolean Jugador) {
        this.carta = carta;
        this.palo = palo;
        this.Jugador = Jugador;
    }

    public String getCartaImagen() {
        String salida = "";
        salida += "images/cartas/" + carta + "_of_" + paloAString() + ".png";
        return salida;
    }

    private String paloAString() {
        switch (palo) {
            case 'h':
                return "hearts";
            case 'c':
                return "clubs";
            case 'd':
                return "diamonds";
            case 's':
                return "spades";
            default:
                return "";
        }
    }
}
