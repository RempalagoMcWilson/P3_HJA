
package org.ucm.poker3.model.cartas;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Carta> listaCartas;
    public Board(){
        listaCartas = new ArrayList<Carta>();
    }
    public void addCarta(Carta carta){
        listaCartas.add(carta);
    }
    public void reset(){
        listaCartas = new ArrayList<Carta>();
    }
    public int getNumCartas(){
        return listaCartas.size();
    }
    public List<Carta> getListaCartas() {
        return listaCartas;
    }
}
