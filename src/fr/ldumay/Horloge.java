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

    public Horloge() {
        super("Horloge");
        setSize(300, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        HorlogeLabel clock = new HorlogeLabel();
        getContentPane( ).add(clock, BorderLayout.CENTER);
    }
    
    class HorlogeLabel extends JLabel implements ActionListener{
 
        public HorlogeLabel( ) {
            super("" + Calendar.getInstance());
            Timer t = new Timer(1000, this);
            t.start( );
            setFont(new Font("Verdana", Font.PLAIN, 30));
        }
 
        @Override
        public void actionPerformed(ActionEvent ae) {
          setText(String.format("%tT", Calendar.getInstance()));
        }
    }
    
}
