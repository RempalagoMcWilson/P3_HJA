
package org.ucm.poker3.view.mainFrame.opciones;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class PanelOpcionesBoard extends JPanel{
    
    
    private JSpinner numJugador;
    private JButton randomB;
    private JButton okB;
    private JTextField cartasTF;
    private JLabel infoSpinner;
    private JLabel infoTField;
    
    public PanelOpcionesBoard() {
        iniGUI();
    }
    
    private void iniGUI() {
        setLayout(null);
        setBackground(new Color(76,111,145));
        setBounds(0,220,330,150);

        Border b = BorderFactory.createLineBorder(Color.black, 2);
        setBorder(BorderFactory.createTitledBorder(b, "Opciones BOARD ", TitledBorder.LEFT, TitledBorder.TOP));
        
        infoSpinner = new JLabel();
        infoSpinner.setText("Seleccionar Nº de cartas en el board:");
        infoSpinner.setBounds(10, 20, 230, 30);
        
        SpinnerNumberModel modeloSpinner = new SpinnerNumberModel(1, 1, 5, 1);
        numJugador = new JSpinner(modeloSpinner);
        numJugador.setBounds(240, 20, 40, 30);
        numJugador.setToolTipText("Seleccionar Nº de cartas en el board:");
        
        randomB = new JButton();
        randomB.setBounds(10, 70, 130, 30);
        randomB.setText("ALEATORIO");
        randomBListener();
        
        okB = new JButton();
        okB.setBounds(210, 70, 100, 30);
        okB.setText("METER");
        okBListener();
        
        infoTField = new JLabel();
        infoTField.setText("Introducir cartas por texto: ");
        infoTField.setBounds(10, 110, 160, 30);
        
        cartasTF = new JTextField();
        cartasTF.setBounds(180,110,130,30);
        
        add(infoSpinner);
        add(numJugador);
        add(randomB);
        add(okB);
        add(infoTField);
        add(cartasTF);
    }
    
    private void randomBListener() {
        randomB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Hacer random a " + numJugador.getValue());
            }
        });
    }
    
    private void okBListener() {
        okB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Meter cartas " + cartasTF.getText() +  " al jugador nº " + numJugador.getValue());
            }
        });
    }
}
