/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ldumay;

import java.util.Calendar;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author ldumay
 */
public class Horloge extends JFrame{
    
    int tailleDeLaPolice = 30;
    JButton plusButton = new JButton("+");
    JButton moinsButton = new JButton("-");
    Font police = new Font("Verdana", Font.PLAIN, tailleDeLaPolice);
    HorlogeLabel clock = new HorlogeLabel();

    public Horloge() {
        super("Horloge");
        setSize(300, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel panelTop = new JPanel();
        getContentPane().add(clock, BorderLayout.EAST);
        
        JPanel panelContent = new JPanel();
        panelContent.add(moinsButton);
        panelContent.add(plusButton);
        getContentPane().add(panelContent, BorderLayout.WEST);
        
        iniButtons();
    }
    
    class HorlogeLabel extends JLabel implements ActionListener{
 
        public HorlogeLabel( ) {
            super("" + Calendar.getInstance());
            Timer t = new Timer(1000, this);
            t.start( );
            setFont(new Font("Verdana", Font.PLAIN, tailleDeLaPolice));
        }
 
        @Override
        public void actionPerformed(ActionEvent ae) {
          setText(String.format("%tT", Calendar.getInstance()));
        }
    }
    
   public void iniButtons(){
       plusButton.addActionListener(event -> {
           tailleDeLaPolice++;
           clock.setFont(police);
       });
       moinsButton.addActionListener(event -> {
            tailleDeLaPolice--;
            clock.setFont(police);
       });
   }
}
