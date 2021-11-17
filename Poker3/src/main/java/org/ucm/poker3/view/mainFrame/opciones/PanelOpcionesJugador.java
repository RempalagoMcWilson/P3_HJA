package org.ucm.poker3.view.mainFrame.opciones;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import org.ucm.poker3.control.Controller;
import org.ucm.poker3.model.cartas.Carta;
import org.ucm.poker3.model.cartas.Jugador;
import org.ucm.poker3.model.cartas.JugadorOmaha;

public class PanelOpcionesJugador extends JPanel {

    private JSpinner numJugador;
    private JButton foldB;
    private JButton randomB;
    private JButton okB;
    private JTextField cartasTF;
    private JLabel infoSpinner;
    private JLabel infoTField;
    Controller ctrl;
    public PanelOpcionesJugador(Controller ctrl) {
        this.ctrl = ctrl;
        iniGUI();
    }
    
    private void iniGUI() {
        setLayout(null);
        setBackground(new Color(76,111,145));
        setBounds(0,70,330,150);

        Border b = BorderFactory.createLineBorder(Color.black, 2);
        setBorder(BorderFactory.createTitledBorder(b, "Opciones JUGADOR ", TitledBorder.LEFT, TitledBorder.TOP));
        
        infoSpinner = new JLabel();
        infoSpinner.setText("Seleccionar NºJugador:");
        infoSpinner.setBounds(10, 20, 135, 30);
        
        SpinnerNumberModel modeloSpinner = new SpinnerNumberModel(1, 1, 6, 1);
        numJugador = new JSpinner(modeloSpinner);
        numJugador.setBounds(155, 20, 40, 30);
        numJugador.setToolTipText("Seleccionar numero de jugador");
        
        
        foldB = new JButton();
        foldB.setBounds(210, 20, 100, 30);
        foldB.setText("FOLD");
        foldB.setBackground(new Color(140,190,240));
        foldBListener();
        
        randomB = new JButton();
        randomB.setBounds(10, 70, 130, 30);
        randomB.setText("ALEATORIO");
        randomB.setBackground(new Color(140,190,240));
        randomBListener();
        
        okB = new JButton();
        okB.setBounds(210, 70, 100, 30);
        okB.setText("METER");
        okB.setBackground(new Color(140,190,240));
        okBListener();
        
        infoTField = new JLabel();
        infoTField.setText("Introducir cartas por texto: ");
        infoTField.setBounds(10, 110, 160, 30);
        
        cartasTF = new JTextField();
        cartasTF.setBounds(180,110,130,30);
        
        add(infoSpinner);
        add(numJugador);
        add(foldB);
        add(randomB);
        add(okB);
        add(infoTField);
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
                String cartas = cartasTF.getText(), excep = "";
                boolean normal = ctrl.getModo();
                Jugador j = null; JugadorOmaha jO = null;
                if(normal){
                    if(cartas.length() != 4)
                        excep = "La longitud debe de ser de 4 (AhQh)";
                    try{
                        int c1 = Character.getNumericValue(cartas.charAt(0));
                        char p1 = cartas.charAt(1);
                        int c2 = Character.getNumericValue(cartas.charAt(2));
                        char p2 = cartas.charAt(3);
                        int nJ = (int) numJugador.getValue();
                        j = new Jugador(new Carta(c1,p1,true),new Carta(c2,p2,true), nJ);
                        ctrl.existeJugadorOCartaN(j);
                    }catch(Exception e){
                        excep = e.getMessage();
                    }
                }
                else{
                    if(cartas.length() != 8)
                        excep = "La longitud debe de ser de 8 (AhKhQhJh)";
                    try{
                        int c1 = Character.getNumericValue(cartas.charAt(0));
                        char p1 = cartas.charAt(1);
                        int c2 = Character.getNumericValue(cartas.charAt(2));
                        char p2 = cartas.charAt(3);
                        int c3 = Character.getNumericValue(cartas.charAt(4));
                        char p3 = cartas.charAt(5);
                        int c4 = Character.getNumericValue(cartas.charAt(6));
                        char p4 = cartas.charAt(7);
                        int nJ = (int) numJugador.getValue();
                        jO = new JugadorOmaha
                            (new Carta(c1,p1,true),new Carta(c2,p2,true),
                                new Carta(c3,p3,true),new Carta(c4,p4,true), nJ);
                        ctrl.existeJugadorOCartaO(jO);
                    }catch(Exception e){
                        excep = e.getMessage();
                    }
                }
                if(!"".equals(excep)){
                    if(normal)
                        ctrl.addJugador(j);
                    else
                        ctrl.addJugadorOmaha(jO);
                }
                else
                    JOptionPane.showMessageDialog(null, excep,"Error message", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
