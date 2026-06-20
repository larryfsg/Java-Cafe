package view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeListener;


public class OrderJPanel extends JPanel {
    
    private JLabel coffeeName;
    private JLabel size;
    private JSpinner qtd;
    private JLabel price;
    private JButton remove;

    public OrderJPanel(String name, String sizeInput, String priceInput, int maxQtd){
         // Customization ------------------------------------------------
        this.setBackground(new Color(255,199,82));
		this.setPreferredSize(new Dimension(0, 80));
		this.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80)); // Isso aqui é pra ele esticar o máximo possível de largura        
        this.setBorder(BorderFactory.createEmptyBorder(5,10,5,10)); 

        // Creating components -------------------------------------------
        this.coffeeName = new JLabel(name);
        this.price = new JLabel(priceInput);
        this.size = new JLabel(sizeInput);
        remove = new JButton("Remove");
        qtd = new JSpinner();

        // Customizing components ----------------------------------------
        coffeeName.setFont(new Font("Arial", Font.BOLD, 14));
        price.setFont(new Font("Arial", Font.BOLD, 14));
        size.setFont(new Font("Arial", Font.BOLD, 12));

        qtd.setModel(new SpinnerNumberModel(1, 1, maxQtd, 1));
		((JSpinner.DefaultEditor) qtd.getEditor()).getTextField().setEditable(false);

        remove.setBorderPainted(false);      
        remove.setContentAreaFilled(false);   
        remove.setFocusPainted(false);


        // Addint its components to itself -------------------------------
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints(); // Isso vai organizar os componentes 

        // adding coffee name in first column first row 
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0; // streches coffee name pushing total price to the right corner
        gbc.anchor = GridBagConstraints.WEST;
        this.add(coffeeName, gbc);

        // adding total price in second column first row
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.0; // Não estica horizontalmente
        gbc.weighty = 0.5;
        gbc.anchor = GridBagConstraints.EAST;
        this.add(price, gbc);

        // adding size under coffee name
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        this.add(size, gbc);

        // adding qtd modifier
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        this.add(qtd, gbc);

        // adding remove button
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 0.0;
        gbc.anchor = GridBagConstraints.EAST;
        this.add(remove, gbc);
    }

    public void increaseQtd(){
        this.qtd.setValue(qtd.getNextValue());
    }

    public void setMaxQtd(int maxQtd){
        ((SpinnerNumberModel) qtd.getModel()).setMaximum(maxQtd);
    }

    // This method accept a listener that tells what it need to do when 'remove' button is clicked
    public void onRemoveAction(ActionListener listener){
        this.remove.addActionListener(listener);
    }

    // public void onQuantityChange(ChangeListener listener){
    //     this.qtd.addChangeListener(listener);
    // }


}
