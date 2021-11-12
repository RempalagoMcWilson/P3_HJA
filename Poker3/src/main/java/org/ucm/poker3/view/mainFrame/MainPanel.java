/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.ucm.poker3.view.mainFrame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MainPanel extends JPanel {

    public MainPanel(Graphics g) {
        paintComponent(g);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Image fondo = null;
        try {
            URL url = this.getClass().getClassLoader().getResource("images/fondos/FondoMain.png");
            BufferedImage image = ImageIO.read(url);
            fondo = new ImageIcon(image).getImage();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (fondo != null) {
            super.paintComponent(g);
            g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        }
    }

}
