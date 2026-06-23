package view;

import java.awt.*;
import javax.swing.*;

public class ReceiptJDialog extends JDialog {
    private JLabel javaCafe;
    private JTextArea items;

    public ReceiptJDialog(JFrame parent, String receiptText){
        super(parent, "Receipt", true);

        // Customizing ---------------------------------------------------
        this.setSize(470,570);
        this.setLocationRelativeTo(parent);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        
        // Creating its components ---------------------------------------
        javaCafe = JavaCafeGUI.H1Text("Java Cafe");
        items = new JTextArea(receiptText);
        items.setEditable(false);
        

        // Adding components to itself -----------------------------------
        panel.add(javaCafe, BorderLayout.NORTH);
        panel.add(items, BorderLayout.CENTER);
        this.add(panel);
    }
    
}
