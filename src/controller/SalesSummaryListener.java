package controller;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// import model.*;
import view.*;


public class SalesSummaryListener implements ActionListener{

    private JavaCafeGUI javaCafeGUI;

    public SalesSummaryListener(JavaCafeGUI javaCafeGUI){
        this.javaCafeGUI = javaCafeGUI;
    }

    @Override 
    public void actionPerformed(ActionEvent e){
		new SalesSummaryDialog(javaCafeGUI).setVisible(true);
	}
}
