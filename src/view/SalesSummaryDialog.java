package view;

import java.awt.*;
import javax.swing.*;
import persistence.SalesReportReader;

public class SalesSummaryDialog extends JDialog {
    
    private JLabel revenues;
    private JLabel transactions;

    private double totalRevenues;
    private int totalTransactions;

    public SalesSummaryDialog(JFrame parent){
        super(parent, "Sales Summary", true);

        // Setting window style
        setSize(260, 200);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout(10, 10));

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        totalTransactions = SalesReportReader.readTransactions("data/sales.csv");
        totalRevenues = SalesReportReader.readRevenue("data/sales.csv");

        transactions = JavaCafeGUI.H3Text("Total Transactions: " + totalTransactions);
        revenues = JavaCafeGUI.H3Text("Total Revenue: " + totalRevenues);

        content.add(transactions);
        content.add(revenues);

        transactions.setAlignmentX(Component.CENTER_ALIGNMENT);
        revenues.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(content, BorderLayout.CENTER);
        //setVisible(true);
    }
}
