package view;

import java.awt.*;
import javax.swing.*;

public class CoffeeStockButton extends JPanel {

    private JLabel nameLabel;
    private JLabel stockS;
    private JLabel stockM;
    private JLabel stockL;
    private JButton updateButton;

    public CoffeeStockButton(String coffeeName,
                             int s,
                             int m,
                             int l) {

        setBackground(new Color(124, 64, 67));
        setPreferredSize(new Dimension(160, 220));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        nameLabel = new JLabel(coffeeName);
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        stockS = new JLabel("S: " + s);
        stockM = new JLabel("M: " + m);
        stockL = new JLabel("L: " + l);

        stockS.setForeground(Color.WHITE);
        stockM.setForeground(Color.WHITE);
        stockL.setForeground(Color.WHITE);

        stockS.setAlignmentX(Component.CENTER_ALIGNMENT);
        stockM.setAlignmentX(Component.CENTER_ALIGNMENT);
        stockL.setAlignmentX(Component.CENTER_ALIGNMENT);

        updateButton = new JButton("Update");
        updateButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createVerticalStrut(15));
        add(nameLabel);
        add(Box.createVerticalStrut(10));
        add(stockS);
        add(stockM);
        add(stockL);
        add(Box.createVerticalStrut(15));
        add(updateButton);
        add(Box.createVerticalGlue());
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public void updateStock(int s, int m, int l) {
        stockS.setText("S: " + s);
        stockM.setText("M: " + m);
        stockL.setText("L: " + l);
    }
}