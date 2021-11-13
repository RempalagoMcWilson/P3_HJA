package org.ucm.poker3.view.mainFrame.opciones;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class PanelOpcionesJugador extends JPanel {

    private JSpinner numJugador;
    private JButton foldB;
    private JButton randomB;
    private JButton okB;
    private JTextField cartasTF;
    
    public PanelOpcionesJugador() {//350 600
        iniGUI();
    }
    
    private void iniGUI() {
        //setLayout(null);
        setBounds(0,0,350,150);
        
        //setMinimunSize();
        setBackground(new Color(76,111,145));
        Border b = BorderFactory.createLineBorder(Color.black, 2);
        setBorder(BorderFactory.createTitledBorder(b, "Opciones JUGADOR", TitledBorder.LEFT, TitledBorder.TOP));
        //setLayout(null);
        
        SpinnerNumberModel modeloSpinner = new SpinnerNumberModel(1, 1, 6, 1);
        numJugador = new JSpinner(modeloSpinner);
        //numJugador.setLayout(null);
        numJugador.setBounds(5, 5, 10, 10);
        numJugador.setToolTipText("Seleccionar numero de jugador");
        
        
        foldB = new JButton();
        //foldB.setLayout(null);
        foldB.setBounds(5, 20, 30, 10);
        foldB.setText("FOLD");
        foldBListener();
        
        randomB = new JButton();
        //foldB.setLayout(null);
        randomB.setBounds(5, 20, 30, 10);
        randomB.setText("ALEATORIO");
        //foldBListener();
        
        okB = new JButton();
        //foldB.setLayout(null);
        okB.setBounds(5, 20, 30, 10);
        okB.setText("METER");
        //foldBListener();
        cartasTF = new JTextField();
        
        
        add(numJugador);
        add(foldB);
        add(randomB);
        add(okB);
        add(cartasTF);
    }
    
    private void foldBListener() {
        foldB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("fold de jugador " + numJugador.getValue());
            }
        });
    }
}
