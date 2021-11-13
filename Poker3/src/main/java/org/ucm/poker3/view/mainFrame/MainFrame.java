/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.ucm.poker3.view.mainFrame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.ucm.poker3.main.Main;
import org.ucm.poker3.model.cartas.Carta;
import org.ucm.poker3.model.cartas.Jugador;
import org.ucm.poker3.view.mainFrame.cartas.PanelCartasJugador;

public class MainFrame extends javax.swing.JFrame {
    JLabel labelFoto;
    MainPanel mP;
    public MainFrame() {
        //initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        this.setBounds(0, 0, 1200, 600);
        this.setTitle("Practica 3");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        mP = new MainPanel();       
        add(mP);
        PanelCartasJugador pCJ1
                = new PanelCartasJugador
                    (new Jugador(new Carta(3,'c', true),new Carta(2,'c', true), 1));
        add(pCJ1);
        PanelCartasJugador pCJ2
                = new PanelCartasJugador
                    (new Jugador(new Carta(9,'s', true),new Carta(8,'h', true), 2));
        add(pCJ2);
        PanelCartasJugador pCJ3
                = new PanelCartasJugador
                    (new Jugador(new Carta(4,'d', true),new Carta(2,'h', true), 3));
        add(pCJ3);
        PanelCartasJugador pCJ4
                = new PanelCartasJugador
                    (new Jugador(new Carta(8,'s', true),new Carta(6,'h', true), 4));
        add(pCJ4);
        PanelCartasJugador pCJ5
                = new PanelCartasJugador
                    (new Jugador(new Carta(5,'d', true),new Carta(7,'d', true), 5));
        add(pCJ5);
        PanelCartasJugador pCJ6
                = new PanelCartasJugador
                    (new Jugador(new Carta(6,'c', true),new Carta(6,'s', true), 6));
        add(pCJ6);
        iniImagenFondo();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
