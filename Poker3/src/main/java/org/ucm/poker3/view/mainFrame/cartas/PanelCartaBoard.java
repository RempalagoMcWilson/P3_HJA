package org.ucm.poker3.view.mainFrame.cartas;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.ucm.poker3.model.cartas.Carta;

public class PanelCartaBoard extends JPanel {

    private Carta carta;
    private JLabel carta1;
    private int pos;

    public PanelCartaBoard(Carta carta, int pos) {
        this.carta = carta;
        this.pos = pos;
        iniGUI();
    }

    public void iniGUI() {
        setLayout(null);
        setBoundsCarta();
        ImageIcon img = null;
        Image image = null;
        try {
            BufferedImage myPicture = ImageIO.read(new File(carta.getCartaImagen()));
            image = myPicture;
            img = new ImageIcon(image.getScaledInstance(60, 80, Image.SCALE_SMOOTH));
            carta1 = new JLabel(img);
            carta1.setBounds(0, 0, 60, 80);
            add(carta1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void setBoundsCarta() {
        switch (pos) {
            case 1:
                setBounds(250, 250, 60, 80);
                break;
            case 2:
                setBounds(330, 250, 60, 80);
                break;
            case 3:
                setBounds(410, 250, 60, 80);
                break;
            case 4:
                setBounds(490, 250, 60, 80);
                break;
            case 5:
                setBounds(570, 250, 60, 80);
                break;

        }
    }

}
