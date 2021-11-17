/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.ucm.poker3.view.mainFrame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.ucm.poker3.control.Controller;
import org.ucm.poker3.main.Main;
import org.ucm.poker3.model.cartas.Board;
import org.ucm.poker3.model.cartas.Carta;
import org.ucm.poker3.model.cartas.Jugador;
import org.ucm.poker3.model.observer.Observer;
import org.ucm.poker3.view.mainFrame.cartas.PanelCartasJugador;

public class MainFrame extends javax.swing.JFrame implements Observer{
    JLabel labelFoto;
    MainPanel mP;
    Controller ctrl;
    public MainFrame(Controller ctrl) {
        this.ctrl = ctrl;
        ctrl.addObserver(this);
        //initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        this.setBounds(0, 0, 1200, 600);
        this.setTitle("Practica 3");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        mP = new MainPanel(ctrl);       
        add(mP);
        //prueba();
        iniImagenFondo();
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iniImagenFondo(){
        try {
            BufferedImage myPicture = ImageIO.read(new File("images/fondos/FondoMain.png"));
            labelFoto = new JLabel(new ImageIcon(myPicture));
            labelFoto.setBounds(0,0 , 1200, 600);
            add(labelFoto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actualizaEquity(ArrayList<Double> porcentajes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void hacerFold(int numJug) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void meterCartaJug(Jugador j) {
        remove(labelFoto);
        add(new PanelCartasJugador(j, ctrl));
        add(labelFoto);
    }

    @Override
    public void meterCartaJugOmaha(Jugador j) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void meterBoard(Board board) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    private void prueba(){
        PanelCartasJugador pCJ1
                = new PanelCartasJugador
                    (new Jugador(new Carta(14,'d', true),new Carta(14,'c', true), 1), ctrl);
        add(pCJ1);
        PanelCartasJugador pCJ2
                = new PanelCartasJugador
                    (new Jugador(new Carta(8,'d', true),new Carta(8,'h', true), 2), ctrl);
        add(pCJ2);
        PanelCartasJugador pCJ3
                = new PanelCartasJugador
                    (new Jugador(new Carta(6,'d', true),new Carta(7,'c', true), 3), ctrl);
        add(pCJ3);
        PanelCartasJugador pCJ4
                = new PanelCartasJugador
                    (new Jugador(new Carta(13,'c', true),new Carta(12,'s', true), 4), ctrl);
        add(pCJ4);
        PanelCartasJugador pCJ5
                = new PanelCartasJugador
                    (new Jugador(new Carta(14,'s', true),new Carta(13,'s', true), 5), ctrl);
        add(pCJ5);
        PanelCartasJugador pCJ6
                = new PanelCartasJugador
                    (new Jugador(new Carta(12,'h', true),new Carta(12,'d', true), 6), ctrl);
        add(pCJ6);
        iniImagenFondo();// c 1, s 0, d 2, h 3
        ctrl.getMazo().meteCarta(14-2, 2);ctrl.getMazo().meteCarta(14-2, 1);
        ctrl.getMazo().meteCarta(8-2, 2);ctrl.getMazo().meteCarta(8-2, 3);
        ctrl.getMazo().meteCarta(6-2, 2);ctrl.getMazo().meteCarta(7-2, 1);
        ctrl.getMazo().meteCarta(13-2, 1);ctrl.getMazo().meteCarta(12-2, 0);
        ctrl.getMazo().meteCarta(14-2, 0);ctrl.getMazo().meteCarta(13-2, 0);
        ctrl.getMazo().meteCarta(12-2, 3);ctrl.getMazo().meteCarta(12-2, 2);
        
        Board b = new Board();
        b.addCarta(new Carta(12,'c', true));
        b.addCarta(new Carta(6,'s', true));
        b.addCarta(new Carta(8,'c', true));
        //b.addCarta(new Carta(6,'s', true));
        ctrl.getMazo().meteCarta(12-2, 1);ctrl.getMazo().meteCarta(6-2, 0);
        ctrl.getMazo().meteCarta(8-2, 1);//ctrl.getMazo().meteCarta(6-2, 0);*/
        ctrl.setBoard(b);
        //ctrl.calculaEquity();
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
