package org.ucm.poker3.model.observer;

import java.util.ArrayList;

public interface Observer {
    public void actualizaEquity(ArrayList<Double> porcentajes);
    public void hacerFold(int numJug);
    public void meterCartaJug(int numJug, String cartas);
    public void meterCartaJugAleatoria(int numJug);
    public void meterBoard(String board);
    public void meterBoardAleatorio(int numCartas);
}
