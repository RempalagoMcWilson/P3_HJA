
package org.ucm.poker3.control;

import java.util.ArrayList;
import java.util.List;
import org.ucm.poker3.model.cartas.Board;
import org.ucm.poker3.model.cartas.Jugador;
import org.ucm.poker3.model.cartas.MazoCartas;
import org.ucm.poker3.model.equity.Equity;
import org.ucm.poker3.model.observer.Observer;
import org.ucm.poker3.view.porcentajeFrame.PorcentajeFrame;

public class Controller {
    private MazoCartas mazo;
    private List<Observer> obs;
    private Equity e;
    private ArrayList<Jugador> jugadores;
    private Board board;
    public Controller(){
        mazo = new MazoCartas();
        obs = new ArrayList<Observer>();
        e = new Equity();
        board = new Board();
        jugadores = new ArrayList();
    }
    public void addJugador(Jugador j){
        jugadores.add(j);
    }
    public void setBoard(Board b){
        board = b;
    }
    public MazoCartas getMazo(){
        return mazo;
    }
    public void addObserver(Observer o){
        obs.add(o);
    }
    public void calculaEquity(){
        PorcentajeFrame pF = new PorcentajeFrame();
        pF.setVisible(true);
        e.calculateEquity(jugadores, mazo, board,pF);
        for(Observer o: obs){
            o.actualizaEquity(e.getPorcentajes());
        }
    }
    
}
