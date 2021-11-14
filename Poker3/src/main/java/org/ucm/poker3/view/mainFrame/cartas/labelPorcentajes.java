
package org.ucm.poker3.view.mainFrame.cartas;

import java.awt.Color;
import javax.swing.JLabel;


public class labelPorcentajes extends JLabel{
    public labelPorcentajes(){
        iniGUI();
    }
    private void iniGUI(){
        setBounds(0, 120, 100, 20);
        setBackground(Color.white);
        setText("0.0%");
    }
}
