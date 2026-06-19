package view;

import java.awt.*;
import javax.swing.*;

// Jdialog to update stock levels
public class UpdateStockDialog extends JDialog {

    // Input Text fields
    private JTextField smallField;
    private JTextField mediumField;
    private JTextField largeField;

    // Buttons
    private JButton confirmButton;
    private JButton cancelButton;

    // Constructor
    public UpdateStockDialog(JFrame parent) {
        super(parent, "Update Stock", true);

        // Setting window style
        setSize(320, 200);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout(10, 10));

        // Fields
        JPanel fieldsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // GridBag config
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Small
        gbc.gridx = 0;
        gbc.gridy = 0;
        fieldsPanel.add(new JLabel("Small:"), gbc);

        gbc.gridx = 1;
        smallField = new JTextField();
        smallField.setPreferredSize(new Dimension(120, 25));
        fieldsPanel.add(smallField, gbc);

        // Medium
        gbc.gridx = 0;
        gbc.gridy = 1;
        fieldsPanel.add(new JLabel("Medium:"), gbc);

        gbc.gridx = 1;
        mediumField = new JTextField();
        mediumField.setPreferredSize(new Dimension(120, 25));
        fieldsPanel.add(mediumField, gbc);

        // Large
        gbc.gridx = 0;
        gbc.gridy = 2;
        fieldsPanel.add(new JLabel("Large:"), gbc);

        gbc.gridx = 1;
        largeField = new JTextField();
        largeField.setPreferredSize(new Dimension(120, 25));
        fieldsPanel.add(largeField, gbc);

        // Buttons
        JPanel buttonPanel = new JPanel();

        confirmButton = new JButton("Confirm");
        cancelButton = new JButton("Cancel");

        buttonPanel.add(confirmButton);
        buttonPanel.add(cancelButton);

        // Adding panels
        add(fieldsPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(parent);
        this.setVisible(true);
    }

    public int getStockS() {
        return Integer.parseInt(smallField.getText());
    }

    public int getStockM() {
        return Integer.parseInt(mediumField.getText());
    }

    public int getStockL() {
        return Integer.parseInt(largeField.getText());
    }
}