/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.ucm.poker3.view.mainFrame.cartas;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.ucm.poker3.model.cartas.Jugador;

public class PanelCartasJugador extends JPanel {

    private Jugador jugador;
    private JLabel fondo;
    private JLabel carta1;
    private JLabel carta2;

    public PanelCartasJugador(Jugador jugador) {
        this.jugador = jugador;
        iniGUI();
    }

    private void iniGUI() {
        setLayout(null);
        setBoundsJugador();
        ImageIcon img = null;
        Image image = null;

        try {
            BufferedImage myPicture = ImageIO.read(new File(jugador.getCarta1().getCartaImagen()));
            image = myPicture;
            img = new ImageIcon(image.getScaledInstance(60, 80, Image.SCALE_SMOOTH));
            carta1 = new JLabel(img);
            carta1.setBounds(40, 40, 60, 80);
            add(carta1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            BufferedImage myPicture = ImageIO.read(new File(jugador.getCarta2().getCartaImagen()));
            image = myPicture;
            img = new ImageIcon(image.getScaledInstance(60, 80, Image.SCALE_SMOOTH));
            carta2 = new JLabel(img);
            carta2.setBounds(40, 0, 60, 80);
            add(carta2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            BufferedImage myPicture = ImageIO.read(new File("images/fondos/jugadores/jugador" + jugador.getNumJugador() + ".png"));
            fondo = new JLabel(new ImageIcon(myPicture));
            fondo.setBounds(0, 0, 100, 120);
            add(fondo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void setBoundsJugador() {
        switch (jugador.getNumJugador()) {
            case 1:
                setBounds(60, 100, 100, 120);
                break;
            case 2:
                setBounds(60, 400, 100, 120);
                break;
            case 3:
                setBounds(350, 50, 100, 120);
                break;
            case 4:
                setBounds(350, 430, 100, 120);
                break;
            case 5:
                setBounds(600, 100, 100, 120);
                break;
            case 6:
                setBounds(600, 400, 100, 120);
                break;
        }
    }

}
