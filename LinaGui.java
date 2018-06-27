package lp;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LinaGui {
    JFrame ramka;
    JLabel etykieta_1;
    JLabel etykieta_2;
    int i = 50;
    JProgressBar progress_bar;


    public void grafika() {

        new LinaGui.Gracz1Listener();
        new LinaGui.Gracz2Listener();

        this.progress_bar = new JProgressBar();
        this.ramka = new JFrame();
        this.ramka.setDefaultCloseOperation(3);
        JButton gracz_1 = new JButton("GRACZ_1");
        gracz_1.addActionListener(new LinaGui.Gracz1Listener());
        JButton gracz_2 = new JButton("GRACZ_2");
        gracz_2.addActionListener(new LinaGui.Gracz2Listener());
        this.etykieta_1 = new JLabel("START!", 0);
        this.progress_bar.setValue(this.i);
        this.progress_bar.setStringPainted(true);
        Border border = BorderFactory.createTitledBorder("Trwa przeciaganie liny");
        this.progress_bar.setBorder(border);
        this.ramka.getContentPane().add("North", this.etykieta_1);
        this.ramka.getContentPane().add("West", gracz_1);
        this.ramka.getContentPane().add("East", gracz_2);
        this.ramka.getContentPane().add("Center", this.progress_bar);
        this.ramka.setSize(400, 300);
        this.ramka.setVisible(true);
    }

    class Gracz2Listener implements ActionListener {
        Gracz2Listener() {
        }

        public void actionPerformed(ActionEvent zdarzenie) {
            LinaGui.this.progress_bar.setValue(LinaGui.this.i);
            if (LinaGui.this.i == 100) {
                JOptionPane.showMessageDialog((Component)null, "GRACZ 2 WYGRYWA");
            } else {
                ++LinaGui.this.i;
                LinaGui.this.progress_bar.setValue(LinaGui.this.i);
            }

        }
    }

    class Gracz1Listener implements ActionListener {
        Gracz1Listener() {
        }

        public void actionPerformed(ActionEvent zdarzenie) {
            LinaGui.this.progress_bar.setValue(LinaGui.this.i);
            if (LinaGui.this.i == 0) {
                JOptionPane.showMessageDialog((Component)null, "GRACZ 1 WYGRYWA");
            } else {
                --LinaGui.this.i;
                LinaGui.this.progress_bar.setValue(LinaGui.this.i);
            }

        }
    }
}
