package view;

import java.awt.*;
import javax.swing.*;

public class CoffeeStockButton extends JPanel{
    private JButton button;
    private JLabel stockS;
    private JLabel stockM;
    private JLabel stockL;

    public CoffeeStockButton(String name,
                             String imgPath,
                             int s,
                             int m,
                             int l) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        button = new JButton(name);

        stockS = new JLabel("S: " + s);
        stockM = new JLabel("M: " + m);
        stockL = new JLabel("L: " + l);

        add(button);
        add(stockS);
        add(stockM);
        add(stockL);
    }
}
