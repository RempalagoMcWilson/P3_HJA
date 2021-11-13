/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.ucm.poker3.view.mainFrame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.ucm.poker3.view.mainFrame.opciones.PanelOpcionesJugador;

public class MainPanel extends JPanel {
    private JLabel labelFoto;
    private PanelOpcionesJugador pJ;
    public MainPanel() {
        iniGUI();
        //iniImagenFondo();
    }
    private void iniGUI(){
        setBounds(850,0,350,600);
        setBackground(new Color(76,111,145));
        setLayout(null);
        pJ = new PanelOpcionesJugador();
        add(pJ);
    }
    private void iniImagenFondo(){
        try {
            BufferedImage myPicture = ImageIO.read(new File("images/fondos/MarcoOpciones.png"));
            labelFoto = new JLabel(new ImageIcon(myPicture));
            labelFoto.setBounds(0,0 , 400, 600);
            add(labelFoto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
