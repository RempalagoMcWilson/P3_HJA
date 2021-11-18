package org.ucm.poker3.model.equity;

import java.text.DecimalFormat;
import java.util.ArrayList;

import java.util.HashSet;

import java.util.Map;
import java.util.TreeMap;
import org.ucm.poker3.model.cartas.Board;
import org.ucm.poker3.model.cartas.Carta;
import org.ucm.poker3.model.cartas.Jugador;
import org.ucm.poker3.model.cartas.MazoCartas;
import org.ucm.poker3.utils.Util;
import org.ucm.poker3.view.porcentajeFrame.PorcentajeFrame;

public class Equity {

    private ArrayList<Double> porcentajes;
    private double totales = 0;
    private ArrayList<Integer> numGanados;
    private ArrayList<Jugador> jugadores;
    private Board boardActual;
    int cont;
    private Boolean[][] mazoE;
    private HashSet<Board> calculado;
    private PorcentajeFrame pF;
    private int combTotales;

    public Equity() {

    }//FALTA EQUITY CASO BASE DE 5 CARTAS BOARD Y EL OMAHA

    public ArrayList<Double> getPorcentajes() {
        return porcentajes;
    }

    public void calculateEquity(ArrayList<Jugador> jugadores, MazoCartas mazo, Board board, PorcentajeFrame pF) {
        combTotales = Util.getNumJug(jugadores.size(), board.getNumCartas());
        this.pF = pF;
        this.jugadores = jugadores;
        totales = 0;
        cont = board.size();
        porcentajes = new ArrayList<Double>();
        numGanados = new ArrayList<Integer>();
        for (int i = 0; i < jugadores.size(); i++) {
            numGanados.add(0);
        }
        boardActual = board;

        mazoE = new Boolean[13][4];
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                if (mazo.isCarta(i, j)) {
                    mazoE[i][j] = true;
                } else {
                    mazoE[i][j] = false;
                }
            }
        }
        calculado = new HashSet<>();

        llamaCombinaciones();

        for (int i = 0; i < jugadores.size(); i++) {
            Double auxD = (numGanados.get(i) / totales) * 100.0;
            new DecimalFormat("#.##").format(auxD);
            //System.out.println( (i+1) + " " +numGanados.get(i) + " " + jugadores.get(i).getCarta1() + "" +jugadores.get(i).getCarta2());
            porcentajes.add(auxD);
        }
        System.out.println(totales);
        pF.dispose();
    }

    private void llamaCombinaciones() {
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                if (!mazoE[i][j]) {
                    cont++;
                    mazoE[i][j] = true;
                    boardActual.addCarta(cont - 1, new Carta(i + 2, Util.numAPalo(j), false));
                    if (cont == 5) {
                        Board auxB = copiaBoard(boardActual);
                        if (!calculado.contains(auxB)) {
                            calculaLugadores(auxB);
                            calculado.add(auxB);
                        }
                    } else {
                        llamaCombinaciones();
                    }
                    boardActual.deleteCarta(cont - 1);
                    mazoE[i][j] = false;
                    cont--;
                }
            }
        }
    }

    private void calculaLugadores(Board board) {
        TreeMap<Solucion, Integer> mapa = new TreeMap<>();
        /*for(Carta c:board.getListaCartas()){
            p.println(c.getNum()+ " "+c.getPalo());
        }
        p.println("------");*/
        for (Jugador j : jugadores) {
            if(j.getActivo()){
                Mano aux = new Mano();
                mapa.put(aux.calcula(j, board), j.getNumJugador() - 1);
            }
            
        }
        Map.Entry<Solucion, Integer> entry = mapa.firstEntry();      
        int auxI = numGanados.get(entry.getValue());
        auxI++;
        numGanados.set(entry.getValue(), auxI);
        totales++;
        double p = (totales / combTotales) * 100.00;//376740  98280

        //new DecimalFormat("#.##").format(p);
        if ((p-(int)p)<=0.001) {
            pF.actualizaPorcentaje((int) p);
        //System.out.println(p);//totales + " " +*
        }
    }

    private Board copiaBoard(Board boardActual) {
        Board aux = new Board();
        for (Carta c : boardActual.getListaCartas()) {
            aux.addCarta(c);
        }
        aux.ordenar();
        return aux;
    }
}
