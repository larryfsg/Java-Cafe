package controller;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// import model.*;
import view.*;

// For when Sale Summary button is clicked
public class SalesSummaryListener implements ActionListener{

    private JavaCafeGUI javaCafeGUI;

    public SalesSummaryListener(JavaCafeGUI javaCafeGUI){
        this.javaCafeGUI = javaCafeGUI;
    }

    // Displays Sale Summary
    @Override 
    public void actionPerformed(ActionEvent e){
		new SalesSummaryDialog(javaCafeGUI).setVisible(true);
	}
}
