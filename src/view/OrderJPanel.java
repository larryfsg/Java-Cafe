package view;

import java.awt.*;
import javax.swing.*;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;

public class OrderJPanel extends JPanel {
    
    private JLabel coffeeName;
    private JLabel size;
    //private JSpinner quantity;
    private JLabel price;
    private JButton remove;

    public OrderJPanel(String name, String size, String price){
         // Customization
        this.setBackground(new Color(238,132,132));
		this.setPreferredSize(new Dimension(0, 80));
		this.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80)); // Isso aqui é pra ele esticar o máximo possível de largura        

        // Components
        this.coffeeName = new JLabel(name);
        this.size = new JLabel(size);
        this.price = new JLabel(price);
        remove = new JButton("remove");

        this.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        this.add(coffeeName);
        this.add(this.size);
        this.add(this.price);
        this.add(remove);
    }


}
