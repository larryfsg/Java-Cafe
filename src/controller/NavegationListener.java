package controller;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

// import model.*;
// import view.*;


public class NavegationListener  implements ActionListener{
    private CardLayout layoutManager;
    private String screenName;
    private JPanel contentPanel;

    public NavegationListener(String name, CardLayout cardLayout, JPanel panel){
        this.layoutManager = cardLayout;
        this.screenName = name;
        this.contentPanel = panel;
    }

    @Override 
    public void actionPerformed(ActionEvent e){
		layoutManager.show(contentPanel, screenName);
	}

}
